package com.rohit.dao;

import com.rohit.models.Product;

import java.util.Set;
import java.util.TreeSet;

public class InventoryDAO {


    public Set<Product> getProductset() {
        return productset;
    }

    public void setProductset(Set<Product> productset) {
        this.productset = productset;
    }

    private  Set<Product> productset=new TreeSet<Product>();
}
