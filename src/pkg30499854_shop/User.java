/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg30499854_shop;

/**
 *
 * @author yulii
 */
public class User {
    
    //Attibutes
    private String username;
    private String password;
    private String firstName;
    private String secondName;
    
    //Getter methods
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getSecondName(){
        return secondName;
    }
    
    
    //Setter methods
    public void setUsername(String username){
        this.username = username;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setFrirstName(String firstName){
        this.firstName = firstName;
    }
    public void setSecondName(String secondName){
        this.secondName = secondName;
    }
    
    //conctructor
    public User(){
        username = "none";
        password = "none";
        firstName = "none";
        secondName = "none";
    }
    
    // overloaded conctructor
    public User(String username, String password, String firstName, String secondName){
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.secondName = secondName;
    }
    
}
