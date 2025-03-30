package ut.edu.webjava.dto;

import java.util.Set;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequest {

    @NotBlank(message = "Tên sản phẩm không được để trống")
    @Size(min = 5, max = 50, message = "Tên sản phẩm phải từ 5 đến 50 ký tự")
    @Schema(description = "Tên sản phẩm", example = "Product1", required = true)
    private String name;

    @NotBlank(message = "Mô tả không được để trống")
    @Size(min = 5, max = 1000, message = "Mô tả sản phẩm phải từ 5 đến 1000 ký tự")
    @Schema(description = "Mô tả sản phẩm", example = "Đây là sản phẩm thứ 1")
    private String description;

    @NotNull(message = "Giá tiền không được để trống")
    @Min(value = 1, message = "Giá tiền phải lớn hơn 0")
    @Schema(description = "Giá sản phẩm", example = "12")
    private Long price;

    @NotNull(message = "Số lượng không được để trống")
    @Min(value = 0, message = "Số lượng sản phẩm không được âm")
    @Schema(description = "Số lượng sản phẩm", example = "12")
    private Integer quantity;

    @NotNull(message = "Danh mục không được để trống")
    @Schema(description = "ID của danh mục", example = "1")
    private Long categoryId;

    @NotNull(message = "Ảnh sản phẩm không được để trống")
    @Schema(description = "Mảng ID của hình ảnh", example = "[1,2,3]")
    private Set<Long> imageIds;
}