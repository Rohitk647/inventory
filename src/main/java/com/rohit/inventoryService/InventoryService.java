package com.rohit.inventoryService;

import com.rohit.models.Product;

import java.util.Set;
import java.util.TreeSet;

/**
 *This class implements the Crud operations and report generation
 * Created by rohit on 1/24/2018.
 */

public class InventoryService {



    static Set<Product> productset=new TreeSet<Product>();
    private long noOfProducts;
    private double profit=0;

    /**
     *   Adds products to the set
     */

    public boolean createProduct(String productName,String costPrice,String sellingPrice) {

        if (productName == null)
            return false;
        else {
            Product product = new Product(productName, Double.parseDouble(costPrice),Double.parseDouble(sellingPrice),getNoOfProducts());
            productset.add(product);
            return true;
        }
    }

    /**
     *  Deletes products from the set
     */

    public boolean deleteProduct(String productName)
    {
        Product matchproduct=getProductByName(productName);
        productset.remove(matchproduct);
        return true;
    }

    /**
     *  Increases the quantity of the products
     */

    public boolean increaseQuantity(String productName,String quantity){

        Product matchproduct=getProductByName(productName);
        setNoOfProducts(Integer.parseInt(quantity));
        deleteProduct(matchproduct.getProductName());
        setNoOfProducts(getNoOfProducts()+matchproduct.getQuantity());
        createProduct(matchproduct.getProductName(),String.valueOf(matchproduct.getCostPrice()),String.valueOf(matchproduct.getSellingPrice()));
        return true;
    }

    /**
     *  Reduces the quantity of the products
     */

    public boolean reduceQuantity(String productName,String quantity){
        Product matchproduct=getProductByName(productName);
        setNoOfProducts(Integer.parseInt(quantity));
        deleteProduct(matchproduct.getProductName());
        setNoOfProducts(matchproduct.getQuantity()- getNoOfProducts());
        createProduct(matchproduct.getProductName(),String.valueOf(matchproduct.getCostPrice()),String.valueOf(matchproduct.getSellingPrice()));
        return true;
    }

    /**
     *  Generating report and calculating profit
     */

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
            a=a+(((long)product.getSellingPrice())-(long) product.getCostPrice())*product.getQuantity();
            b=b+(long)getProfit();
            System.out.println(b);
        }
        System.out.println("profit"+(a-b));
        System.out.println("Total Value of Products "+i);
        i=0;a=0;b=0;setProfit(0);
    }

    /**
     *  To get the required product by given name
     */

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

    /**
     *  This method calculates the cost price of the deleted products
     */

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
