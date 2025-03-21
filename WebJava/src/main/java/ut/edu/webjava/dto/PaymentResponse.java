package ut.edu.webjava.dto;


public class PaymentResponse {
    private boolean success; // Trạng thái thanh toán
    private String message; // Thông báo kết quả
    private String transactionId; // ID giao dịch giả lập

    // Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}