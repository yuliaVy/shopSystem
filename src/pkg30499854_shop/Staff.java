/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

/**
 *
 * @author yulii
 */
public class Staff extends User {
    
    //attributes
    private String position;
    private double salary;
    
    //method for displaing a greeting
    public String greeting(){
        String greeting = "<html> Welcome in MR./MRS. "+ this.getFirstName() + " "+ this.getSecondName() + 
                "<br/>" + "You are logged in as Staff" + "</html>";
        return greeting;
    }
    
    //constructor
    public Staff(){
        super();
        position = "none";
        salary = 0;
    }
    
    //overloaded constructor
    public Staff (String username, String password, String firstName, String secondName, String position, double salary){
        super(username, password, firstName, secondName);
        this.position = position;
        this.salary = salary;
    }
    
    //getter
    public String getposition(){
        return position;
    }
    
    public double getsalary(){
        return salary;
    }
    
    
    
    //setter
    
    public void setposition(String position){
        this.position = position;
    }
    public void setsalary (double salary){
        this.salary = salary;
    }

    
}
