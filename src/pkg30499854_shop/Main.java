/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pkg30499854_shop;

import java.util.HashMap;

/**
 *
 * @author yulii
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        DBManager db = new DBManager();
        HashMap<String, Customer> customers  = db.loadCustomers();
        HashMap<String, Staff> staff = db.loadStaff();     
    }
    
}
