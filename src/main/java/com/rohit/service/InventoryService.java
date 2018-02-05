package com.rohit.service;

/**
 * Service that manages Inventory Operations.
 */

public interface InventoryService {


    /**
     * Increases the inventory of a product
     * @param productName
     * @param quantity
     * @return boolean
     */
    boolean increaseQuantity(String productName, String quantity);

    /**
     * Reduces the inventory of the product
     * @param productName
     * @param quantity
     * @return boolean
     */
    boolean reduceQuantity(String productName, String quantity);

    /**
     * Modifies the selling Price of the product
     * @param productName
     * @param sellingPrice
     * @return boolean
     */
    boolean changeSellingPrice(String productName,String sellingPrice);





}
