package ut.edu.webjava.dto;

import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrderRequest {

    @NotBlank(message = "Họ khách hàng không được để trống")
    @Size(min = 3, max = 50, message = "Họ khách hàng phải từ 3 đến 50 ký tự")
    private String firstname;

    @NotBlank(message = "Tên khách hàng không được để trống")
    @Size(min = 3, max = 50, message = "Tên khách hàng phải từ 3 đến 50 ký tự")
    private String lastname;

    @NotBlank(message = "Tên quốc gia không được để trống")
    private String country;

    @NotBlank(message = "Địa chỉ không được để trống")
    private String address;

    @NotBlank(message = "Thành phố không được để trống")
    private String town;

    @NotBlank(message = "Khu vực không được để trống")
    private String state;

    @Min(value = 1, message = "Mã bưu điện phải là số dương")
    private Long postCode;

    @NotBlank(message = "Email không được để trống")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    private String phone;

    private String note;

    @Min(value = 0, message = "Tổng giá trị đơn hàng không hợp lệ")
    private long totalPrice;

    private String username;

    private List<CreateOrderDetailRequest> orderDetails;
}
