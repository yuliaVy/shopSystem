
package pkg30499854_shop;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yulii
 */
public class Order {
    
    private int orderId;
    private Date orderDate;
    private String status;
    private double orderTotal;
    
    //Integer : KEY
    //OrderLine - collection of orderLines :  VALUE
    private HashMap<Integer, OrderLine> orderLines;
    
    public boolean isInBasket(int productId)
    {
        //start from assuming the product is not in the basket
        boolean isAlreadyInBasket = false;
        //we loop through every item in the order
        for(Map.Entry<Integer, OrderLine> olMapEntry : orderLines.entrySet())
        {
            //get the orderline obj from the map entry
            OrderLine actualOrderLine = olMapEntry.getValue();
            //get the product stored inside the orderline
            Product productFromOrderLine = actualOrderLine.getProduct();
            //compare the ID we're searching for with current animal id
            if(productId == productFromOrderLine.getProductId())
            {
                //if they match, mark that we've found it
                isAlreadyInBasket = true;
            }   
        }
        //after checking everything, return whether we foung a match
        return isAlreadyInBasket;
    }
    
    
    //method which removes OrderLines from current Orders
    public void romoveOrderLine (int productId)
    {
        Iterator <Map.Entry<Integer, OrderLine>> iter = orderLines.entrySet().iterator();
        //loop through hash map to find selected productId
        while (iter.hasNext())
        {
            //gets the order
            Map.Entry<Integer, OrderLine> olEntry = iter.next();
            //gets the orderline
            OrderLine actualOrderLine = olEntry.getValue();
            //if matches - removes it from order and updates the total
            if (actualOrderLine.getProduct().getProductId() == productId)
            {
                //removes orderline from order
                iter.remove();
                //recounts total
                orderTotal = orderTotal - actualOrderLine.getLineTotal();
            }
            
        }
    }
    
    
    //method that adds orderLines to an order
    public void addOrderLine (OrderLine ol)
    {
        int orderLineId = 0;
        while(orderLines.containsKey(orderLineId))
        {
            orderLineId++;
        }
        
        ol.setorderLineId(orderLineId);
        orderLines.put(ol.getorderLineId(), ol);
    }
    
    //method which calculates order total by adding up all orderLines
    public double calculateOrderTotal()
    {
        orderTotal = 0;
        for(Map.Entry<Integer, OrderLine> olMapEntry : orderLines.entrySet())
        {
            OrderLine actualOrderLine = olMapEntry.getValue();
            orderTotal = orderTotal + actualOrderLine.getLineTotal();
        }
        return orderTotal;
    }
    
    // Getters and Setters  
    public HashMap<Integer, OrderLine> getOrderLines()
    {   return orderLines;  }
    
    public void setOrderLines(HashMap<Integer, OrderLine> olIn)
    {   orderLines = olIn;  }
    
    public void setOrderDate (Date orderdatein)
    {
        orderDate = orderdatein;
    }
    
    public void setStatus(String statusin)
    {
        status = statusin;
    }
    
    public void setOrderId (int ID)
    {
        orderId = ID;
    }        
        
    
    public Date getOrderDate ()
    {
        return orderDate ;
    }
    public double getOrderTotal()
    {
        return orderTotal;
    }
    
    public String getStatus()
    {
        return status;
    }
    
    
    //0
    public Order(){
        orderId = 0;
        orderDate = new Date();
        status = "new Order";
        orderTotal = 0;
        orderLines = new HashMap();
    }
    
    
    //all 4
    public Order(int orderId, Date orderDate,double orderTotal , String status){
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.status = status;
        this.orderTotal = orderTotal;
        orderLines = new HashMap();
    }
    
    
    
    
    public int getorderId (){
        return orderId;
    }
    public Date getorderDate (){
        return orderDate;
    }
    public String getstatus (){
        return status;
    }
    public double getorderTotal (){
        return orderTotal;
    }
    public HashMap<Integer, OrderLine> getorderLines (){
        return orderLines;
    }
    
    //setters
    public void setorderId (int orderId){
        this.orderId = orderId;
    }
    public void setorderDate (Date orderDate){
        this.orderDate = orderDate;
    }
    public void setstatus (String status){
        this.status = status;
    }
    public void setorderTotal (double orderTotal){
        this.orderTotal = orderTotal;
    }
    public void setorderLines (HashMap<Integer, OrderLine> orderLines){
        this.orderLines = orderLines;
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

