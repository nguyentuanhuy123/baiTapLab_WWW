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
        List<NhaCungCap> nccs;
        if (kw != null && !kw.trim().isEmpty()) {
            nccs = nhaCungCapService.search(kw.trim());
        } else {
            nccs = nhaCungCapService.findAll();
        }

        List<String> nccIds = nccs.stream()
                .map(NhaCungCap::getMaNcc)
                .toList();
        List<DienThoai> dts;
        if (nccIds.isEmpty()) {
            dts = List.of();
        } else {
            dts = dienThoaiService.getByDanhMuc(nccIds);
        }

        model.addAttribute("nccs", nccs);
        model.addAttribute("dts", dts);
        model.addAttribute("kw", kw);

        return "DanhSachDienThoaiNCC";
    }
}
