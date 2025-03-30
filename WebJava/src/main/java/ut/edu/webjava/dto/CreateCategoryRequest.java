package ut.edu.webjava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCategoryRequest {

    @NotBlank(message = "Tên danh mục không được để trống")
    @Size(min = 3, max = 50, message = "Tên danh mục phải từ 3 đến 50 ký tự")
    private String name;

    @Size(max = 255, message = "Mô tả danh mục tối đa 255 ký tự")
    private String description;
}
