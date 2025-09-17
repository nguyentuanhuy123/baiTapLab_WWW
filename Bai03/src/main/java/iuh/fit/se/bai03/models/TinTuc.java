package iuh.fit.se.bai03.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TINTUC")
public class TinTuc {

    @Id
    @NotBlank(message = "Mã tin tức không được để trống")
    @Column(name = "MATT")
    private String maTT;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Column(name = "TIEUDE")
    private String tieuDe;

    @NotBlank(message = "Nội dung không được để trống")
    @Size(max = 255, message = "Nội dung không được vượt quá 255 ký tự")
    @Column(name = "NOIDUNGTT")
    private String noiDungTT;

    @NotBlank(message = "Liên kết không được để trống")
    @Pattern(regexp = "^http://.*", message = "Liên kết phải bắt đầu bằng http://")
    @Column(name = "LIENKET")
    private String lienKet;

    @NotNull(message = "Danh mục không được để trống")
    @ManyToOne
    @JoinColumn(name = "MADM")
    private DanhMuc danhMuc;
}
