//package ut.edu.webjava.service;
//
//import org.springframework.stereotype.Service;
//import ut.edu.webjava.dto.PaymentRequest;
//import ut.edu.webjava.dto.PaymentResponse;
//
//import java.util.UUID;
//
//@Service
//public class PaymentService {
//    public PaymentResponse processPayment(PaymentRequest paymentRequest) {
//        PaymentResponse response = new PaymentResponse();
//
//        // Giả lập kiểm tra thông tin thẻ
//        if (isValidCard(paymentRequest)) {
//            response.setSuccess(true);
//            response.setMessage("Payment processed successfully");
//            response.setTransactionId(UUID.randomUUID().toString()); // Tạo ID giao dịch giả lập
//        } else {
//            response.setSuccess(false);
//            response.setMessage("Payment failed: Invalid card details");
//        }
//
//        return response;
//    }
//
//    private boolean isValidCard(PaymentRequest paymentRequest) {
//        // Giả lập kiểm tra thông tin thẻ
//        // Ví dụ: Số thẻ phải có 16 chữ số, CVV có 3 chữ số, v.v.
//        return paymentRequest.getCardNumber().length() == 16 &&
//                paymentRequest.getCvv().length() == 3 &&
//                !paymentRequest.getExpiryDate().isEmpty();
//    }
//}