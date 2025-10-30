package iuh.fit.se.lab08bai2.controllers;

import iuh.fit.se.lab08bai2.entities.DienThoai;
import iuh.fit.se.lab08bai2.entities.NhaCungCap;
import iuh.fit.se.lab08bai2.services.DienThoaiService;
import iuh.fit.se.lab08bai2.services.NhaCungCapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class DienThoaiController {
    private final NhaCungCapService nhaCungCapService;
    private final DienThoaiService dienThoaiService;
    @Autowired
    public  DienThoaiController(NhaCungCapService nhaCungCapService,DienThoaiService dienThoaiService){
        this.dienThoaiService=dienThoaiService;
        this.nhaCungCapService=nhaCungCapService;
    }
    @GetMapping("/dt-form")
    public ModelAndView showForm(ModelAndView modelAndView){
        List<NhaCungCap> nccs=nhaCungCapService.findAll();

        modelAndView.addObject("nccs",nccs);
        modelAndView.addObject("dienthoai",new DienThoai());
        modelAndView.setViewName("DienThoaiForm");
        return modelAndView;
    }
    @PostMapping("/dt-form")
    public ModelAndView save(ModelAndView modelAndView,
                             @Valid @ModelAttribute("dienthoai") DienThoai dienThoai,
                             BindingResult result,
                             @RequestParam("file") MultipartFile file) {

        List<NhaCungCap> nccs = nhaCungCapService.findAll();
        modelAndView.addObject("nccs", nccs);
        if (result.hasErrors()) {
            modelAndView.setViewName("DienThoaiForm");
            return modelAndView;
        }

        try {
            String uploadDir = new File("src/main/resources/static/images").getAbsolutePath();
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            String originalFilename = file.getOriginalFilename();

            if (originalFilename != null && !originalFilename.isEmpty()) {
                String fileName = originalFilename;
                File destination = new File(uploadDir, fileName);
                int count = 1;
                String name = fileName.substring(0, fileName.lastIndexOf('.'));
                String extension = fileName.substring(fileName.lastIndexOf('.'));
                while (destination.exists()) {
                    fileName = name + "(" + count + ")" + extension;
                    destination = new File(uploadDir, fileName);
                    count++;
                }

                file.transferTo(destination);
                dienThoai.setHinhAnh(fileName);
            }
            dienThoaiService.save(dienThoai);
            modelAndView.setViewName("redirect:/");
            return modelAndView;

        } catch (IOException e) {
            e.printStackTrace();
            modelAndView.addObject("errorMessage", "Lỗi khi lưu file: " + e.getMessage());
            modelAndView.setViewName("DienThoaiForm");
            return modelAndView;
        }
    }
    @GetMapping("/quanly")
    public String quanLy(Model model) {
        List<NhaCungCap> nccs=nhaCungCapService.findAll();
        List < DienThoai> dts=dienThoaiService.findAll();

        model.addAttribute("nccs", nccs);
        model.addAttribute("dts", dts);
        return "QuanLyForm";
    }



    @PostMapping("/quanly")
    public String deleteDienThoai(@RequestParam("maDt") String maDt,
                                  RedirectAttributes redirectAttributes) {
        try {
            dienThoaiService.delete(maDt);
            redirectAttributes.addFlashAttribute("message", "Xóa thành công: " + maDt);
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Xóa thất bại: " + e.getMessage());
        }
        return "redirect:/quanly";
    }

}
