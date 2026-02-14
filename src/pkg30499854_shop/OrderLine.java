/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author yulii
 */
public class OrderLine {
    private int orderLineId;
    private Product product;   //Association
    private double lineTotal;
    private int quantity;
    
    
    public OrderLine(Product product, int quantity)
    {
        this.quantity = quantity;
        orderLineId = 1;
        this.product = product;
        this.lineTotal = product.getPrice()*quantity;
    }
   
    //all 3
    public OrderLine(int orderLineId, Product product, double lineTotal, int quantity){
        this.orderLineId = orderLineId;
        this.product = product;
        this.lineTotal = lineTotal;
        this.quantity = quantity;
    }
    
    //Id + Animal + calculate lineTotal
    public OrderLine (int orderLineIn, Product product, int quantity){
        this.orderLineId = orderLineIn;
        this.product = product;
        this.quantity = quantity;
        this.lineTotal = product.getPrice()*quantity;
    }
    
    
    
    //getters
    public int getorderLineId (){
        return orderLineId;
    }
    public Product getProduct (){
        return product;
    }
    public double getLineTotal (){
        return lineTotal;
    }
    public int getquantity (){
        return quantity;
    }
    
    //setters
    public void setorderLineId (int orderLineIn){
        this.orderLineId = orderLineIn;
    }
    public void setproduct (Product product){
        this.product = product;
    }
    public void setlineTotal (double lineTotal){
        this.lineTotal = lineTotal;
    }
    public void setquantity (int quantity){
        this.quantity = quantity;
    }
}
