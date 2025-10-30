package iuh.fit.se.lab08bai2.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "dienthoai")
public class DienThoai {
    @Id
    @Column(name = "MADT")
    @NotBlank(message = "Mã ĐT không được để trống")
    private String maDt;

    @Column(name = "TENDT")
    @NotBlank(message = "Tên điện thoại không được để trống")
    private String tenDt;

    /**
     * Yêu cầu: Năm sản xuất là số nguyên 4 chữ số.
     * Dùng regex: ^\d{4}$
     */
    @Column(name = "NAMSANXUAT")
    @NotBlank(message = "Năm sản xuất không được để trống")
    @Pattern(regexp = "^\\d{4}$", message = "Năm sản xuất phải là 4 chữ số (ví dụ: 2023)")
    private String namSanXuat;

    /**
     * Yêu cầu: Thông tin cấu hình không quá 255 ký tự.
     * Dùng regex để đảm bảo 1..255 ký tự: ^.{1,255}$
     */
    @Column(name = "CAUHINH")
    @NotBlank(message = "Thông tin cấu hình không được để trống")
    @Pattern(regexp = "^.{1,255}$", message = "Thông tin cấu hình tối đa 255 ký tự")
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private NhaCungCap ncc;

    /**
     * Hình ảnh: không bắt buộc (nếu bắt buộc hãy thêm @NotBlank).
     * Kiểm tra định dạng file ảnh (jpg,jpeg,png) có thể làm bằng @Pattern cho tên file,
     * nhưng lưu ý: MultipartFile validation thường thực hiện ở controller.
     *
     * Pattern (case-insensitive) cho tên file: (?i).+\.(jpg|jpeg|png)$
     */
    @Column(name = "HINHANH")
    @Pattern(regexp = "(?i).+\\.(jpg|jpeg|png)$", message = "Chỉ chấp nhận định dạng ảnh: jpg, jpeg, png")
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
