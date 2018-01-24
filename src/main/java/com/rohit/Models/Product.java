package com.rohit.Models;

/**
 * Created by rohit on 1/24/2018.
 */
public class Product {

     private String productName;
     private double costPrice;
     private double sellingPrice;
     private int quantity;

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


     public Product(String productName,double costPrice,double sellingPrice,int quantity ){
         this.productName = productName;
         this.costPrice=costPrice;
         this.quantity=quantity;
         this.sellingPrice=sellingPrice;

     }

     public Product(){}


}
