package com.rohit;

import com.rohit.inventoryService.InventoryService;

/**
 * Util class for CRUD operations
 */

public class Util {
    public void option(String option)
    {
        InventoryService inventoryService=new InventoryService();
        String[] operation = option.split(" ");
        operation[0]=operation[0].toLowerCase();
        if(operation[0].equals("create")){
            inventoryService.createProduct(operation[1],operation[2],operation[3]);
        }
        else if(operation[0].equals("updateby")){
           inventoryService.increaseQuantity(operation[1],operation[2]);
        }
        else if(operation[0].equals("updatesell")){
            inventoryService.reduceQuantity(operation[1],operation[2]);
        }
        else if(operation[0].equals("delete")){
            inventoryService.delProdCost(operation[1]);
            inventoryService.deleteProduct(operation[1]);
        }
        else if (operation[0].equals("report")){inventoryService.report();}
        else{}

    }
}
