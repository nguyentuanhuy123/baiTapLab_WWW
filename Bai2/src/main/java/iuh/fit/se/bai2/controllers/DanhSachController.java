package iuh.fit.se.bai2.controllers;

import iuh.fit.se.bai2.models.DienThoai;
import iuh.fit.se.bai2.models.NhaCungCap;
import iuh.fit.se.bai2.services.DienThoaiService;
import iuh.fit.se.bai2.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class DanhSachController {

    private final NhaCungCapService nhaCungCapService;
    private final DienThoaiService dienThoaiService;

    @Autowired
    public DanhSachController(NhaCungCapService nhaCungCapService,
                              DienThoaiService dienThoaiService) {
        this.nhaCungCapService = nhaCungCapService;
        this.dienThoaiService = dienThoaiService;
    }

    @GetMapping("/danhsach")
    public String danhSach(
            @RequestParam(value = "kw", required = false) String kw,
            Model model
    ) {
        // Lấy danh sách NhaCungCap (tìm hoặc tất cả)
        List<NhaCungCap> nccs;
        if (kw != null && !kw.trim().isEmpty()) {
            nccs = nhaCungCapService.search(kw.trim());
        } else {
            nccs = nhaCungCapService.findAll();
        }

        // Lấy danh sách mã nhà cung cấp
        List<String> nccIds = nccs.stream()
                .map(NhaCungCap::getMaNcc)   // đảm bảo tên getter đúng: getMaNcc()
                .toList();

        // Lấy danh sách DienThoai theo danh mục (nccIds)
        List<DienThoai> dts;
        if (nccIds.isEmpty()) {
            dts = List.of();
        } else {
            dts = dienThoaiService.getByDanhMuc(nccIds);
        }

        // Đưa vào model và trả view (JSP)
        model.addAttribute("nccs", nccs);
        model.addAttribute("dts", dts);
        model.addAttribute("kw", kw);

        // Nếu bạn dùng JSP trong /WEB-INF/views/ -> cấu hình .jsp tên "DanhSachDienThoaiNCC"
        return "DanhSachDienThoaiNCC";
    }
}
