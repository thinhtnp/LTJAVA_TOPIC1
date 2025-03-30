package ut.edu.webjava.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {

    @NotBlank(message = "Tên khách hàng không được để trống")
    private String customerName;

    @NotEmpty(message = "Danh sách sản phẩm không được để trống")
    private List<String> productIds;

    @Positive(message = "Tổng giá phải lớn hơn 0")
    private double totalPrice;
}