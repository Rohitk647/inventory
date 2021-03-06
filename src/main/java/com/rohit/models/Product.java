package com.rohit.models;

/**
 * Pojo class for Product
 *
 */
public class Product implements  Comparable<Product>{

    private String productName;
    private double costPrice;
    private double sellingPrice;
    private long quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Product product = (Product) o;
//
//        return productName.equals(product.productName);
//    }
//
//    @Override
//    public int hashCode() {
//        return productName.hashCode();
//    }

    public Product(String productName, double costPrice, double sellingPrice, long quantity ){
        this.productName = productName;
        this.costPrice=costPrice;
        this.quantity=quantity;
        this.sellingPrice=sellingPrice;

    }

    public Product(){}

    /**
     *  Compares objects to be written into treeset
     */

    public int compareTo(Product o) {
        return this.getProductName().compareTo(o.getProductName());}
}
