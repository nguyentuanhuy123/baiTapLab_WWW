package iuh.fit.se.bai03.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "DANHMUC")
public class DanhMuc {
    @Id
    @Column(name = "MADM")
    private String maDM;

    @Column(name = "TENDANHMUC")
    private String tenDanhMuc;

    @Column(name = "NGUOIQUANLY")
    private String nguoiQuanLy;

    @Column(name = "GHICHU")
    private String ghiChu;

    @OneToMany(mappedBy = "danhMuc")
    private List<TinTuc> tinTucs;

}
