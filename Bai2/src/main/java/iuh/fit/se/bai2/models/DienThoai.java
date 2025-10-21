package iuh.fit.se.bai2.models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dienthoai")
public class DienThoai {
    @Id
    @Column(name = "MADT")
    private String maDt;
    @Column(name = "TENDT")
    private String tenDt;
    @Column(name = "NAMSANXUAT")
    private String namSanXuat;
    @Column(name = "CAUHINH")
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private NhaCungCap ncc;

    @Column(name = "HINHANH")
    private String hinhAnh;

    public String getMaDt() {
        return maDt;
    }

    public void setMaDt(String maDt) {
        this.maDt = maDt;
    }

    public String getTenDt() {
        return tenDt;
    }

    public void setTenDt(String tenDt) {
        this.tenDt = tenDt;
    }

    public String getNamSanXuat() {
        return namSanXuat;
    }

    public void setNamSanXuat(String namSanXuat) {
        this.namSanXuat = namSanXuat;
    }

    public String getCauHinh() {
        return cauHinh;
    }

    public void setCauHinh(String cauHinh) {
        this.cauHinh = cauHinh;
    }

    public NhaCungCap getNcc() {
        return ncc;
    }

    public void setNcc(NhaCungCap ncc) {
        this.ncc = ncc;
    }

    public String getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(String hinhAnh) {
        this.hinhAnh = hinhAnh;
    }
}
