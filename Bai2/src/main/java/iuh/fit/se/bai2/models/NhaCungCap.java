package iuh.fit.se.bai2.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "nhacungcap")
public class NhaCungCap {
    @Id
    @Column(name = "MANCC")
    private String maNcc;
    @Column(name = "TENNHACC")
    private String tenNhaCc;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;

    @OneToMany(mappedBy = "ncc")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private List<DienThoai> dienThoais;

    public String getMaNcc() {
        return maNcc;
    }

    public void setMaNcc(String maNcc) {
        this.maNcc = maNcc;
    }

    public String getTenNhaCc() {
        return tenNhaCc;
    }

    public void setTenNhaCc(String tenNhaCc) {
        this.tenNhaCc = tenNhaCc;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
