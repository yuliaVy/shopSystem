/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

/**
 *
 * @author yulii
 */
public class Product {
    
    //Attibutes
    private int productId;
    private String productName;
    private double price;
    private int stockLevel;
    
    
    //Getter methods
    public int getProductId(){
        return productId;
    }
    public String getProductName(){
        return productName;
    }
    public double getPrice(){
        return price;
    }
    public int getStockLevel(){
        return stockLevel;
    }
    
    //Setter methods
    public void setProductId(int productId){
        this.productId = productId;
    }
    public void setProductName(String productName){
        this.productName = productName;
    }
    public void setPrice(double price){
        this.price = price;
    }
    public void setStockLevel(int stockLevel){
        this.stockLevel = stockLevel;
    }
    
    //conctructor
    public Product(){
        productId = 0;
        productName = "none";
        price = 0;
        stockLevel = 0;
    }
    
    //overloaded constructor
    public Product( String productName, double price, int stockLevel){
        productId = 0;
        this.productName = productName;
        this.price = price;
        this.stockLevel = stockLevel;
    }
    
    // overloaded conctructor
    public Product(int productId, String productName, double price, int stockLevel){
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.stockLevel = stockLevel;
    }
    
    @Override
    public String toString()
    {
        String productText = productName + " for " + price + " pounds.";
        return productText;
    }
}
