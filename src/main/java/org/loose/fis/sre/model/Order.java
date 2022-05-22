package org.loose.fis.sre.model;

public class Order {

    private String sellerName;
    private String customerName;
    private String productName;
    private int quantity;
    private String status;
    private int customerId;
    private int orderId;

    public Order() {

    }

    public Order(String sellerName, String customerName, String productName, int quantity, String status, int customerId, int orderId) {
        this.sellerName = sellerName;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
        this.customerId = customerId;
        this.orderId = orderId;
    }


    public String getSellerName() {
        return sellerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getOrderId() {
        return orderId;
    }


    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
