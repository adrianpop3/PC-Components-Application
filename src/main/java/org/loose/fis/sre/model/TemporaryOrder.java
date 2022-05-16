package org.loose.fis.sre.model;

public class TemporaryOrder {

    private String sellerName;
    private String customerName;
    private String productName;
    private int quantity = 1, idCustomer;

    public TemporaryOrder() {

    }

    public TemporaryOrder(String sellerName, String customerName, String productName, int idCustomer) {
        this.sellerName = sellerName;
        this.customerName = customerName;
        this.productName = productName;
        this.idCustomer = idCustomer;
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

    public int getIdCustomer() {
        return idCustomer;
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

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }
}
