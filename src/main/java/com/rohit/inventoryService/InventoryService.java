package com.rohit.inventoryService;

import com.rohit.models.Product;

import java.util.Set;
import java.util.TreeSet;

/**
 *This class implements the Crud operations and generates inventory report
 * Created by rohit on 1/24/2018.
 */

public class InventoryService {



    private static Set<Product> productset=new TreeSet<Product>();
    private long noOfProducts;
    private static double costPrice;



    private static double profit;
    private static long previousProfit=0;

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
        if(productName == null){return false;}
        else {
            Product matchproduct = getProductByName(productName);
            productset.remove(matchproduct);
            return true;
        }
    }

    /**
     *  Increases the quantity of the products
     */

    public boolean increaseQuantity(String productName,String quantity){
        if(productName == null||quantity ==null){return false;}
        else {
            Product matchproduct = getProductByName(productName);
            setNoOfProducts(Integer.parseInt(quantity));
            deleteProduct(matchproduct.getProductName());
            setNoOfProducts(getNoOfProducts() + matchproduct.getQuantity());
            createProduct(matchproduct.getProductName(), String.valueOf(matchproduct.getCostPrice()), String.valueOf(matchproduct.getSellingPrice()));
            return true;
        }
    }

    /**
     *  Reduces the quantity of the products
     */

    public boolean reduceQuantity(String productName,String quantity){
        if(productName == null||quantity ==null){return false;}
        else {
            Product matchproduct = getProductByName(productName);
            calculateProfit(productName, quantity);
            setNoOfProducts(Integer.parseInt(quantity));
            deleteProduct(matchproduct.getProductName());
            setNoOfProducts(matchproduct.getQuantity() - getNoOfProducts());
            createProduct(matchproduct.getProductName(), String.valueOf(matchproduct.getCostPrice()), String.valueOf(matchproduct.getSellingPrice()));
            return true;
        }
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

        System.out.println("           "+"INVENTORY REPORT");
        System.out.println("Item Name"+"    "+ "Bought At"+"    "+"Sold At"+"   "+"AvailableQty"+"  "+"Value");
        System.out.println("---------"+"    "+ "---------"+"    "+"-------"+"   "+"------------"+"  "+"-----");


        for(Product product:printReport)
        {
            i=i+((product.getCostPrice())*(product.getQuantity()));
//            a=a+(((long)product.getSellingPrice())-(long) product.getCostPrice())*product.getQuantity();
            System.out.println(product.getProductName()+"        " +product.getCostPrice()+"         " +product.getSellingPrice()+"          " +product.getQuantity()+"          " + ((product.getCostPrice())*(product.getQuantity())));
        }
        a=a+(long)getProfit();
        b=b+(long)getCostPrice();
        System.out.println(a+" "+b);
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Total Value                                             "+i);
        System.out.println("Profit                                                  "+(a-b));
        if(previousProfit==0)
        {
            System.out.println("Profit from previous report                             "+0.0);
        }
        else
        {
        System.out.println("Profit from previous report                             "+(previousProfit-(a-b)));
        }
        System.out.println();
        previousProfit=a-b;
        setCostPrice(0);
    }


    /**
     *  To get the required product by given name
     */

    private Product getProductByName(String productName)
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
            setCostPrice(matchproduct.getCostPrice()+getCostPrice());
        }
        else
        {
            setCostPrice(matchproduct.getCostPrice() * matchproduct.getQuantity() + getCostPrice());
        }
        return getCostPrice();
    }

    public void calculateProfit(String productName,String quantity){
        Product matchproduct=getProductByName(productName);
        setProfit(((matchproduct.getSellingPrice()- matchproduct.getCostPrice())*Integer.parseInt(quantity))+getProfit());
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
    public static double getProfit() {
        return profit;
    }

    public static void setProfit(double profit) {
        InventoryService.profit = profit;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }
}
