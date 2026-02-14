/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

/**
 *
 * @author yulii
 */
public class Clothing extends Product {
    
    //attributes
    private String measurment; 
    
    //Constuctors
    public Clothing (){
        super();
        measurment = "0";
    } 
    
    //exept productID
    public Clothing (String productName, double price, int stockLevel, String measurment){
        super(productName, price,stockLevel);
        this.measurment = measurment;
    }
    
    //constructor everything
    
    public Clothing (int productId, String productName, double price, int stockLevel, String measurment){
        super(productId, productName, price,stockLevel);
        this.measurment = measurment;
    }
    
    //getter
    public String getmeasurment (){
        return measurment;
    }
    
    
    //setter
    public void setmeasurment(String measurment){
        this.measurment = measurment;
    }
}
