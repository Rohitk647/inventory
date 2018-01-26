package com.rohit.service;

/**
 * Service That Manages Product Operations
 */
public interface ProductService {

    /**
     * To add a product to the inventory
     * @param productName
     * @param costPrice
     * @param sellingPrice
     * @return boolean
     */
    boolean createProduct(String productName, String costPrice, String sellingPrice);

    /**
     * To delete a product from the inventory
     * @param productName
     * @return boolean
     */
    boolean deleteProduct(String productName);

    /**
     * To calculate cost price of deleted products
     * @param productName
     * @return double
     */
    public double delProdCost(String productName);





}
