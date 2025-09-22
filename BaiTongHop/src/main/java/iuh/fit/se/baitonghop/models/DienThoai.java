package iuh.fit.se.baitonghop.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dienthoai")
public class DienThoai {
    @Id
    @Column(name = "MADT")
    @NotBlank(message = "MADT khong duoc de trong")
    private String maDt;
    @Column(name = "TENDT")
    @NotBlank(message = "TENDT khong duoc de trong")
    private String tenDt;
    @Column(name = "NAMSANXUAT")
    @NotBlank(message = "NAMSANXUAT khong duoc de trong")
    @Pattern(regexp = "\\d{4}",message = "NAMSANXUAT phai co 4 chu so")
    private String namSanXuat;
    @Column(name = "CAUHINH",length = 255)
    @NotBlank(message = "CAUHINH khong duoc de trong")
    @Size(max = 255, message = "Thông tin cấu hình không quá 255 ký tự")
    private String cauHinh;

    @ManyToOne
    @JoinColumn(name = "MANCC")
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @NotNull(message = "Nhà cung cấp phải được chọn")
    private NhaCungCap ncc;
    @Column(name = "HINHANH")
    @Pattern(
            regexp = "([^\\s]+(\\.(?i)(png|jpg|jpeg))$)",
            message = "Hình ảnh chỉ chấp nhận định dạng: png, jpg, jpeg"
    )
    private String hinhAnh;
}

