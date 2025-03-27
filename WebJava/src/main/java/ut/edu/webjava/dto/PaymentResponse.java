package ut.edu.webjava.dto;

import java.time.LocalDateTime;

public class PaymentResponse {
    private String transactionId;
    private String status;
    private LocalDateTime timestamp;
    private String message;
    private double amount;
    private String currency;

    // Constructors
    public PaymentResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public PaymentResponse(String transactionId, String status, String message, double amount, String currency) {
        this();
        this.transactionId = transactionId;
        this.status = status;
        this.message = message;
        this.amount = amount;
        this.currency = currency;
    }

    // Getters and Setters
    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void setSuccess(boolean b) {
    }
}