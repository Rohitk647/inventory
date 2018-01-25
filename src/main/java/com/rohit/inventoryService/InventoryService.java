package com.rohit.inventoryService;

import com.rohit.models.Product;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by rohit on 1/24/2018.
 */

public class InventoryService {

//    To store the products and print them in sorted order

    static Set<Product> productset=new TreeSet<Product>();
    private long noOfProducts;
    private double profit=0;

//    To add product

    public boolean createProduct(String productName,String costPrice,String sellingPrice) {

        if (productName == null)
            return false;
        else {
            Product product = new Product(productName, Double.parseDouble(costPrice),Double.parseDouble(sellingPrice),getNoOfProducts());
            productset.add(product);
            return true;
        }
    }

//   To delete product

    public boolean deleteProduct(String productName)
    {
        Product matchproduct=getProductByName(productName);
        productset.remove(matchproduct);
        return true;
    }

//    To increase the quantity

    public boolean increaseQuantity(String productName,String quantity){

        Product matchproduct=getProductByName(productName);
        setNoOfProducts(Integer.parseInt(quantity));
        deleteProduct(matchproduct.getProductName());
        setNoOfProducts(getNoOfProducts()+matchproduct.getQuantity());
        createProduct(matchproduct.getProductName(),String.valueOf(matchproduct.getCostPrice()),String.valueOf(matchproduct.getSellingPrice()));
        return true;
    }

//    To reduce the quantity

    public boolean reduceQuantity(String productName,String quantity){
        Product matchproduct=getProductByName(productName);
        setNoOfProducts(Integer.parseInt(quantity));
        deleteProduct(matchproduct.getProductName());
        setNoOfProducts(matchproduct.getQuantity()- getNoOfProducts());
        createProduct(matchproduct.getProductName(),String.valueOf(matchproduct.getCostPrice()),String.valueOf(matchproduct.getSellingPrice()));
        return true;
    }

// Generate report

    public void report()
        {
         Set<Product> printReport=getProductset();
         double i=0;
         long a=0;
         long b=0;
         for(Product product:printReport)
         {
             System.out.println(product.getProductName()+" "+product.getCostPrice()+" "+product.getSellingPrice()+" "+product.getQuantity()+" "+((product.getCostPrice())*(product.getQuantity())));
             i=i+((product.getCostPrice())*(product.getQuantity()));
             a=a+(Math.round(product.getSellingPrice())- Math.round(product.getCostPrice())*(product.getQuantity()));
             System.out.println(a);
//             b=b+product.getQuantity();
//             System.out.println(b);
         }
//            System.out.println((b*a));


            System.out.println("Total Value of Products "+i);
            i=0;a=0;b=0;setProfit(0);
        }

// get the product by productName

    public Product getProductByName(String productName)
    {
            Product matchproduct=null;
            for(Product product:productset){
                if(product.getProductName().equals(productName)){
                    matchproduct=product;
                }
            }
            return matchproduct;
    }

//        calculating costprice of deleted products

    public double delProdCost(String productName){

        Product matchproduct=getProductByName(productName);
        if(matchproduct.getQuantity()==0)
        {
            setProfit(matchproduct.getCostPrice()+getProfit());
        }
            else
        {
            setProfit(matchproduct.getCostPrice() * matchproduct.getQuantity() + getProfit());
        }
        System.out.println(getProfit());
        return getProfit();
    }

//        getters and setters

    public Set<Product> getProductset() {
        return productset;
    }

    public static void setProductset(Set<Product> productset) {
        InventoryService.productset = productset;
    }
    public long getNoOfProducts() {
        return noOfProducts;
    }

    public void setNoOfProducts(long noOfProducts) {
        this.noOfProducts = noOfProducts;
    }
    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }
}
