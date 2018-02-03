package com.rohit.dao;

/**
 *  Factory for DAO
 */
public class InventoryDaoFactory {

    public InventoryDAO getInventoryDAO() {
        return inventoryDAO;
    }

    InventoryDAO inventoryDAO=new InventoryDAO();

    public static InventoryDaoFactory getFactory() {
        return factory;
    }

    private static InventoryDaoFactory factory=new InventoryDaoFactory();

    private InventoryDaoFactory(){}
}
