package iuh.fit.se.lab08bai2.controllers;

import iuh.fit.se.lab08bai2.entities.DienThoai;
import iuh.fit.se.lab08bai2.entities.NhaCungCap;
import iuh.fit.se.lab08bai2.services.DienThoaiService;
import iuh.fit.se.lab08bai2.services.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class NhaCungCapController {
    private final NhaCungCapService nhaCungCapService;
    private final DienThoaiService dienThoaiService;
    @Autowired
    public  NhaCungCapController(NhaCungCapService nhaCungCapService,DienThoaiService dienThoaiService){
        this.dienThoaiService=dienThoaiService;
        this.nhaCungCapService=nhaCungCapService;
    }
    @GetMapping("")
    public ModelAndView index(ModelAndView modelAndView){
        List<NhaCungCap> nccs=nhaCungCapService.findAll();
        List < DienThoai> dts=dienThoaiService.findAll();

        modelAndView.addObject("nccs",nccs);
        modelAndView.addObject("dts",dts);
        modelAndView.setViewName("DanhSachDienThoaiNCC");
        return modelAndView;
    }
}
