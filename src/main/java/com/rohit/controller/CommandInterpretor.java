package com.rohit.controller;

import com.rohit.Util.ServiceFactory;
import com.rohit.service.InventoryService;
import com.rohit.service.ProductCatalogImpl;
import com.rohit.service.ProductService;
import com.rohit.service.ReportService;

/**
 * CommandInterpretor class for performing required operations
 */

public class CommandInterpretor {

    public void execute(String option)
    {
        ProductService productService = ServiceFactory.getInstance().getProductService();
        InventoryService inventoryService = ServiceFactory.getInstance().getInventoryService();
        ReportService reportService = ServiceFactory.getInstance().getReportService();

        String[] operation = option.split(" ");
        operation[0]=operation[0].toLowerCase();
        if(operation[0].equals("create")){
            productService.createProduct(operation[1], operation[2], operation[3]);}
        else if(operation[0].equals("updatebuy")){
           inventoryService.increaseQuantity(operation[1],operation[2]);
        }
        else if(operation[0].equals("updatesell")){
            inventoryService.reduceQuantity(operation[1],operation[2]);
        }
        else if(operation[0].equals("delete")){
            productService.delProdCost(operation[1]);
            productService.deleteProduct(operation[1]);
        }
        else if (operation[0].equals("report")){
            reportService.report();}
        else{
            System.out.println("please enter valid option");
        }

    }
}
