package com.rohit.InventoryService;

import com.rohit.Models.Product;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rohit on 1/24/2018.
 */
public class InventoryService {
//    to store the products and print them in sorted order
    static Set<Product> productset=new TreeSet<Product>();

    private int noOfProducts;

//    To add product

    public boolean createProduct(String productName,String costPrice,String sellingPrice) {

        if (productName == null)
            return false;
        else {
            Product product = new Product(productName, Double.parseDouble(costPrice),Double.parseDouble(sellingPrice), getNoOfProducts());
            productset.add(product);
            return true;
        }
    }


//   To delete product
    public boolean deleteProduct(String productName)
    {
        Product matchproduct=null;
        for(Product product:productset){
            if(product.getProductName().equals(productName)){
                matchproduct=product;
            }
        }
        productset.remove(matchproduct);
        return true;
    }
    public boolean updateQuantity(String productName,String quantity){
        Product matchproduct=null;
        setNoOfProducts(Integer.parseInt(quantity));
        for(Product product:productset){
            if(product.getProductName().equals(productName)){
                matchproduct=product;
            }
        }
        deleteProduct(matchproduct.getProductName());
        setNoOfProducts(getNoOfProducts()+matchproduct.getQuantity());
        createProduct(matchproduct.getProductName(),String.valueOf(matchproduct.getCostPrice()),String.valueOf(matchproduct.getSellingPrice()));
        return true;
    }


    public void report()
        {
         Set<Product> printReport=getProductset();

         for(Product product:printReport){
             System.out.println(product.getProductName()+" "+product.getCostPrice()+" "+product.getSellingPrice()+" "+product.getQuantity());
         }

        }
    public Set<Product> getProductset() {
        return productset;
    }

    public static void setProductset(Set<Product> productset) {
        InventoryService.productset = productset;
    }
    public int getNoOfProducts() {
        return noOfProducts;
    }

    public void setNoOfProducts(int noOfProducts) {
        this.noOfProducts = noOfProducts;
    }
}
