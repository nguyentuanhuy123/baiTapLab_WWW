package iuh.fit.se.bai2.controllers;

import iuh.fit.se.bai2.models.DienThoai;
import iuh.fit.se.bai2.models.NhaCungCap;
import iuh.fit.se.bai2.services.DienThoaiService;
import iuh.fit.se.bai2.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Optional;

@Controller
public class DienThoaiController {

    private final NhaCungCapService nhaCungCapService;
    private final DienThoaiService dienThoaiService;

    // cấu hình upload directory trong application.properties
    @Value("${app.upload.dir:uploads/images}")
    private String uploadDir;

    public DienThoaiController(NhaCungCapService nhaCungCapService,
                               DienThoaiService dienThoaiService) {
        this.nhaCungCapService = nhaCungCapService;
        this.dienThoaiService = dienThoaiService;
    }

    @GetMapping("/dt-form")
    public String showForm(Model model) {
        List<NhaCungCap> nccs = nhaCungCapService.findAll();
        model.addAttribute("nccs", nccs);
        // cung cấp một object DienThoai rỗng nếu bạn dùng form:form binding
        model.addAttribute("dienThoai", new DienThoai());
        return "DienThoaiForm"; // DienThoaiForm.jsp trong /WEB-INF/views/
    }

    @PostMapping("/dt-form")
    public String handleSubmit(
            @RequestParam("maDt") String maDt,
            @RequestParam("tenDt") String tenDt,
            @RequestParam("namSanXuat") String namSanXuat,
            @RequestParam("cauHinh") String cauHinh,
            @RequestParam("maNcc") String maNcc,
            @RequestParam(name = "hinhAnh", required = false) MultipartFile hinhAnh,
            RedirectAttributes redirectAttributes
    ) {

        // Lấy NhaCungCap (service nên trả Optional or entity)
        Optional<NhaCungCap> maybeNcc = nhaCungCapService.findById(maNcc);
        NhaCungCap ncc = maybeNcc.orElse(null);

        // Tạo object DienThoai (constructor hoặc setter tuỳ bạn)
        DienThoai dienThoai = new DienThoai();
        dienThoai.setMaDt(maDt);
        dienThoai.setTenDt(tenDt);
        dienThoai.setNamSanXuat(namSanXuat);
        dienThoai.setCauHinh(cauHinh);
        dienThoai.setNcc(ncc);

        // Xử lý upload file nếu có
        if (hinhAnh != null && !hinhAnh.isEmpty()) {
            // sạch tên file
            String originalFilename = StringUtils.cleanPath(hinhAnh.getOriginalFilename());
            try {
                Path uploadPath = Paths.get(uploadDir);
                if (Files.notExists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }
                // Nếu muốn tránh trùng tên, bạn có thể thêm timestamp hoặc UUID
                Path target = uploadPath.resolve(originalFilename);
                try (var in = hinhAnh.getInputStream()) {
                    Files.copy(in, target, StandardCopyOption.REPLACE_EXISTING);
                }
                dienThoai.setHinhAnh(originalFilename);
            } catch (IOException ex) {
                ex.printStackTrace();
                redirectAttributes.addFlashAttribute("message", "Không upload được file: " + ex.getMessage());
                // bạn có thể redirect về form hiển thị lỗi
                return "redirect:/dt-form";
            }
        }

        // Lưu vào DB qua service
        try {
            dienThoaiService.add(dienThoai);
            redirectAttributes.addFlashAttribute("message", "Thêm điện thoại thành công");
        } catch (Exception e) {
            e.printStackTrace();
            redirectAttributes.addFlashAttribute("message", "Lỗi khi lưu vào DB: " + e.getMessage());
            return "redirect:/dt-form";
        }

        return "redirect:/danhsach";
    }
}
