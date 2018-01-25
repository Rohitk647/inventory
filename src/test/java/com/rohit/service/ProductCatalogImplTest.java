package com.rohit.service;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test Cases for the ProductCatalogImpl
 */

public class ProductCatalogImplTest {
    ProductCatalogImpl productCatalogImpl =new ProductCatalogImpl();

    @Test
    public void createProductTrue(){
        boolean result= productCatalogImpl.createProduct("Fettucine","20","32");
        assertEquals(true,result);
    }
    @Test
    public void createProductFalse(){
        boolean result= productCatalogImpl.createProduct(null,"20","32");
        assertEquals(false,result);
    }

    @Test
    public void deleteProductTrue(){
        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result= productCatalogImpl.deleteProduct("Fettucine");
        assertEquals(true,result);
    }

    @Test
    public void deleteProductFalse(){
        boolean result= productCatalogImpl.deleteProduct(null);
        assertEquals(false,result);
    }

    @Test
    public void increaseQuantityTrue(){

        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result= productCatalogImpl.increaseQuantity("Fettucine","10");
        assertEquals(true,result);

    }

    @Test
    public void increaseQuantityFalse(){

        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result= productCatalogImpl.increaseQuantity(null,"10");
        assertEquals(false,result);

    }

    @Test
    public void increaseQuantityFalseNullQuant(){

        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result= productCatalogImpl.increaseQuantity("Fettucine",null);
        assertEquals(false,result);

    }

    @Test
    public void reduceQuantityTrue(){
        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result = productCatalogImpl.reduceQuantity("Fettucine","3");
        assertEquals(true,result);
    }

    @Test
    public void reduceQuantityFalse(){
        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result = productCatalogImpl.reduceQuantity(null,"3");
        assertEquals(false,result);
    }

    @Test
    public void reduceQuantityFalseNullQuant(){
        productCatalogImpl.createProduct("Fettucine","20","33");
        boolean result = productCatalogImpl.reduceQuantity("Fettucine",null);
        assertEquals(false,result);
    }



}
