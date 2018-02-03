package com.rohit.Util;

import com.rohit.service.InventoryService;
import com.rohit.service.ProductCatalogImpl;
import com.rohit.service.ProductService;
import com.rohit.service.ReportService;
import com.rohit.view.Report;


public class ServiceFactory {

    private ProductCatalogImpl productCatalogService =new ProductCatalogImpl();
    private Report report=new Report();

    static private ServiceFactory instance = null ;
    private ServiceFactory() {

    }

    public static ServiceFactory getInstance() {
        if ( instance == null ) instance= new ServiceFactory();
        return instance;
    }

    public ProductService getProductService() {
        return productCatalogService;
    }

    public ReportService getReportService() {
        return report;
    }

    public InventoryService getInventoryService() {
        return productCatalogService;
    }
}
