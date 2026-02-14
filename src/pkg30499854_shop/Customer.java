/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

import java.util.HashMap;

/**
 *
 * @author yulii
 */
public class Customer extends User {
    
    //attributes
    private String addressLine1;
    private String addressLine2;
    private String town;
    private String postcode;
    private boolean isRegistered;
    private HashMap<Integer, Order> orders;
    
    //method for displaing a greeting
    public String greeting(){
        String greeting = "<html>Welcome in MR./MRS. "+ this.getFirstName() + " "+ this.getSecondName() 
                + "<br/>" + "Enjoy Shopping" + "</html>";
        return greeting;
    }
    
    //constuctors
    public Customer(){
        super();
        addressLine1 = "none";
        addressLine2 = "none" ;
        town = "none";
        postcode = "none";
        isRegistered = false;
        orders = new HashMap();
    }
    
    //overloaded constructor
    public Customer(String username, String password, String firstName, String secondName, String addressLine1, String addressLine2,String town, String postcode){
        super(username, password, firstName, secondName);
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.town = town; 
        this.postcode = postcode;
        isRegistered = false;
        orders = new HashMap();
    }
    
    

    
    //getters
    public String getaddressLine1 (){
        return addressLine1; 
    }
    
    public String getaddressLine2 (){
        return addressLine2; 
    }
    public String gettown (){
        return town; 
    }
    public String getpostcode(){
        return postcode; 
    }
    public boolean getisRegistered (){
        return isRegistered; 
    }
    public HashMap<Integer, Order> getorders (){
        return orders;
    }
    
    //setters
    public void setaddressLine1 (String addressLine1){
        this.addressLine1 = addressLine1;
    }
    public void setaddressLine2 (String addressLine2){
        this.addressLine2 = addressLine2;
    }
    public void settown (String town){
        this.town = town;
    }
    public void setpostcode (String postcode){
        this.postcode = postcode;
    }
    public void setisRegistered (boolean isRegistered ){
        this.isRegistered = isRegistered;
    }
    public void setorders (HashMap<Integer, Order> orders){
        this.orders = orders;
    }
    
    
   
    
}
