package com.rohit.view;

import com.rohit.models.Product;
import com.rohit.service.ProductCatalogImpl;
import com.rohit.service.ReportService;

import java.util.Set;

/**
 * Generates Report
 */
public class Report implements ReportService{
    ProductCatalogImpl productCatalog=new ProductCatalogImpl();
    public void report() {
        Set<Product> printReport = productCatalog.getProductset();
        double i = 0;
        long a = 0;
        long b = 0;

        System.out.println("           " + "INVENTORY REPORT");
        System.out.println("Item Name" + "    " + "Bought At" + "    " + "Sold At" + "   " + "AvailableQty" + "  " + "Value");
        System.out.println("---------" + "    " + "---------" + "    " + "-------" + "   " + "------------" + "  " + "-----");


        for (Product product : printReport) {
            i = i + ((product.getCostPrice()) * (product.getQuantity()));
            System.out.println(product.getProductName() + "        " + product.getCostPrice() + "         " + product.getSellingPrice() + "          " + product.getQuantity() + "          " + ((product.getCostPrice()) * (product.getQuantity())));
        }
        a = a + (long) productCatalog.getProfit();
        b = b + (long) productCatalog.getCostPrice();
        System.out.println(a + " " + b);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Total Value                                             " + i);

        System.out.println("Profit from previous report                             " + (a - b));

        System.out.println();
        productCatalog.setCostPrice(0);
        productCatalog.setProfit(0);
    }
}
