package com.rohit.service;

/**
 * Service that manages Inventory Operations.
 */

public interface InventoryService {


    /**
     * Increases the inventory of a product
     * @param productName
     * @param quantity
     * @return
     */
    boolean increaseQuantity(String productName, String quantity);

    /**
     *
     * @param productName
     * @param quantity
     * @return
     */
    boolean reduceQuantity(String productName, String quantity);





}