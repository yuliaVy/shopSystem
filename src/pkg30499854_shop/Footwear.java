/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

/**
 *
 * @author yulii
 */
public class Footwear extends Product {
    //attributes
    private int size;
    
    //constuctors
    public Footwear (){
        super();
        size = 0;
    } 
    
    //constructor exept productId
    public Footwear (String productName, double price, int stockLevel, int size){
        super(productName, price,stockLevel);
        this.size = size;
    }
    
    //constructor everything
    
    public Footwear (int productId, String productName, double price, int stockLevel, int size){
        super(productId, productName, price,stockLevel);
        this.size = size;
    }
    
    
    
    
    //getter
    public int getSize(){
        return size;
    }
    
    
    //setter
    public void setSize (int size){
        this.size = size;
    }
    
    
}
