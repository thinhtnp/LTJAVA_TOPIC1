package ut.edu.webjava.dto;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponse {
    private Long orderId;
    private String status;
    private String message;
    private double totalAmount;
    private LocalDateTime timestamp;
    private List<Item> items;

    // Constructors
    public OrderResponse() {
        this.timestamp = LocalDateTime.now();
    }

    public OrderResponse(Long orderId, String status, String message, double totalAmount, List<Item> items) {
        this();
        this.orderId = orderId;
        this.status = status;
        this.message = message;
        this.totalAmount = totalAmount;
        this.items = items;
    }

    // Getters and Setters
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Item {
        private String productId;
        private String name;
        private int quantity;
        private double price;

        // Constructors
        public Item() {
        }

        public Item(String productId, String name, int quantity, double price) {
            this.productId = productId;
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        // Getters and Setters
        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
