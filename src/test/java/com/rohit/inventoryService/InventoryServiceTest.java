package com.rohit.inventoryService;

import com.rohit.models.Product;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by rohit on 1/25/2018.
 */
public class InventoryServiceTest {
    InventoryService inventoryService=new InventoryService();

    @Test
    public void createProductTrue(){
        boolean result=inventoryService.createProduct("Fettucine","20","32");
        assertEquals(true,result);
    }
    @Test
    public void createProductFalse(){
        boolean result=inventoryService.createProduct(null,"20","32");
        assertEquals(false,result);
    }

    @Test
    public void deleteProductTrue(){
        inventoryService.createProduct("Fettucine","20","33");
        boolean result=inventoryService.deleteProduct("Fettucine");
        assertEquals(true,result);
    }

    @Test
    public void deleteProductFalse(){
        boolean result=inventoryService.deleteProduct(null);
        assertEquals(false,result);
    }

    @Test
    public void increaseQuantityTrue(){

        inventoryService.createProduct("Fettucine","20","33");
        boolean result=inventoryService.increaseQuantity("Fettucine","10");
        assertEquals(true,result);

    }

    @Test
    public void increaseQuantityFalse(){

        inventoryService.createProduct("Fettucine","20","33");
        boolean result=inventoryService.increaseQuantity(null,"10");
        assertEquals(false,result);

    }

    @Test
    public void increaseQuantityFalseNullQuant(){

        inventoryService.createProduct("Fettucine","20","33");
        boolean result=inventoryService.increaseQuantity("Fettucine",null);
        assertEquals(false,result);

    }

    @Test
    public void reduceQuantityTrue(){
        inventoryService.createProduct("Fettucine","20","33");
        boolean result =inventoryService.reduceQuantity("Fettucine","3");
        assertEquals(true,result);
    }

    @Test
    public void reduceQuantityFalse(){
        inventoryService.createProduct("Fettucine","20","33");
        boolean result =inventoryService.reduceQuantity(null,"3");
        assertEquals(false,result);
    }

    @Test
    public void reduceQuantityFalseNullQuant(){
        inventoryService.createProduct("Fettucine","20","33");
        boolean result =inventoryService.reduceQuantity("Fettucine",null);
        assertEquals(false,result);
    }



}
