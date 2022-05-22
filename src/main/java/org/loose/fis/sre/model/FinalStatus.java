package org.loose.fis.sre.model;

public class FinalStatus {

    private String sellerName;
    private String customerName;
    private String productName;
    private int quantity;
    private String status;

    public FinalStatus() {

    }

    public FinalStatus(String sellerName, String customerName, String productName, int quantity, String status) {
        this.sellerName = sellerName;
        this.customerName = customerName;
        this.productName = productName;
        this.quantity = quantity;
        this.status = status;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
