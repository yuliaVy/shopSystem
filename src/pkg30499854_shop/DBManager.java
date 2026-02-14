package pkg30499854_shop;


import java.util.HashMap;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author yulii
 */
public class DBManager {
    
    private final String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    private final String connectionString = "jdbc:ucanaccess://data\\AssessmentShopDB.accdb";
    
    //methood for reading data from database
    //returns customers using username (string) attribute 
    
    public HashMap<String,Customer> loadCustomers() {
        HashMap<String,Customer> loadedCustomers = new HashMap();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Customers");
            while (rs.next()){
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String address1 = rs.getString("AddressLine1");
                String address2 = rs.getString("AddressLine2");
                String town = rs.getString("Town");
                String postcode = rs.getString("Postcode");
                
                //create new Customer object
                Customer customer = new Customer(username, password, firstName, lastName, address1, address2, town, postcode);
                //load customer into a hashmap
                loadedCustomers.put(username, customer);
            }
        } catch (Exception ex)
        {
            System.out.println("Error loading customers"  + ex.getMessage());
        }
        finally
        {
            loadedCustomers = loadCustomersOrders(loadedCustomers);
            return loadedCustomers;
        }
    }
    
    //create load staff method
    public HashMap<String,Staff> loadStaff() {
        HashMap<String,Staff> loadedStaff = new HashMap();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Staff");
            while (rs.next()){
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String position = rs.getString("Position");
                double salary = rs.getDouble("Salary");
                
                //create new Customer object
                Staff staffPerson = new Staff(username, password, firstName, lastName, position, salary);
                //load customer into a hashmap
                loadedStaff.put(username, staffPerson);
            }
        } catch (Exception ex)
        {
            System.out.println("Error loading customers"  + ex.getMessage());
        }
        finally
        {
            return loadedStaff;
        }
    }
    
    //Log In Method for Customers
    public Customer validatingCustomer (String username, String password){
        HashMap <String, Customer> allCustomers = loadCustomers();
        
        if (allCustomers.containsKey(username)){
            Customer existedCustomer = allCustomers.get(username);
            if(existedCustomer.getPassword().equals(password))
            {
                return existedCustomer;
            } else
            {
                return null;
            }
            
        } else
        {
            return null;
        }
    }
    
    //Log In Method for Staff
    public Staff validatingStaff (String username, String password){
        HashMap <String, Staff> allStaff = loadStaff();
        
        if (allStaff.containsKey(username)){
            Staff existedStaff = allStaff.get(username);
            if(existedStaff.getPassword().equals(password))
            {
                return existedStaff;
            } else
            {
                return null;
            }
            
        } else
        {
            return null;
        }
    }
    
    
    //method to load product from database
    public HashMap<Integer, Product> loadProducts()
    {
        HashMap<Integer, Product> allProducts = new HashMap();
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Products");
            while (rs.next()){
                int productId = rs.getInt("ProductId");
                String productName = rs.getString("ProductName");
                double price = rs.getDouble("Price");
                int stockLevel = rs.getInt("StockLevel");
                String measurment = rs.getString("Measurement");
                int size = rs.getInt("Size");
                
                //check if that's top or bottom
                if(measurment == null || measurment.equals(""))
                {
                    Footwear b = new Footwear (productId, productName, price, stockLevel, size);
                    allProducts.put(productId, b);
                }
                else
                {
                    Clothing t = new Clothing (productId, productName, price, stockLevel, measurment);
                    allProducts.put(productId, t);
                }
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error loading Products" + ex.getMessage());
        }
        finally
        {
            return allProducts;
        }
    }
    
    //write orders method
    public int writeOrder(Order o, String userName)
    {
        int orderId = 0;
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO Orders (OrderDate, Username, OrderTotal, Status)" + "VALUES ("
                    + "'" + new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(o.getOrderDate()) +  "'," + 
                            "'" + userName + "'," + 
                                    "'" + o.calculateOrderTotal()+"',"+ 
                                            "'" + o.getStatus()+"')");
            
            ResultSet rs = stmt.getGeneratedKeys();
            
            if(rs.next())
            {
                orderId = rs.getInt(1);
                o.setOrderId(orderId);
            }
                 
        }catch(Exception ex)
        {
            System.out.println("Error Writing Order: " + ex.getMessage());
        }
        finally
        {
            return orderId;
        }
    }
    
    //write OrderLines
    public void writeOrderLines (OrderLine ol, int orderId)
    {
        try 
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("INSERT INTO OrderLines (ProductId, Quantity, LineTotal, OrderId)" + 
                    "VALUES ("
                    + "'" + ol.getProduct().getProductId() +  "'," + 
                            "'" + ol.getquantity() +"'," +
                                    "'" + ol.getLineTotal()+"',"+ 
                                            "'" + orderId+"')");
        
        }catch(Exception ex)
        {
            System.out.println("Error Writing OrderLines: " + ex.getMessage());
        }
    }
    
    //update availability of the product when it was bought
    public void updateProductAvailability (OrderLine ol)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //this bit changes stockLevel in DB
            stmt.executeUpdate(
                "UPDATE Products " +
                "SET StockLevel = StockLevel - " + ol.getquantity() + 
                " WHERE ProductId = " + ol.getProduct().getProductId());
        }
        catch (Exception ex)
        {
            //print out the error
            System.out.println("Error update availability " + ex.getMessage());
        }
    }
    
    //method for deleting animals from database
    public void deleteProduct (Product product) //could use product instead
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            stmt.executeUpdate("DELETE FROM Products WHERE ProductId = " + product.getProductId());
            
        }
        catch (Exception ex)
        {
            //print out the error
            System.out.println("Error update availability " + ex.getMessage());
        }
    }
    
    //method for updating information about a product
    public void editProduct(Product p)
    {
        String additionalSQL ="";
        //cheking for a category to update specific to this type things
        if(p.getClass().getName().equals("pkg30499854_shop.Footwear"))
        {
            Footwear f = (Footwear) p;//casting product to a footwear
            additionalSQL = "Size = '" + f.getSize() + "',";
        }
        else if(p.getClass().getName().equals("pkg30499854_shop.Clothing"))
        {
            Clothing c = (Clothing) p;//casting product to a clothing
            additionalSQL = "Measurement = '" + c.getmeasurment() + "',";
        }
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //sql statment for updating data
            stmt.executeUpdate("UPDATE Products SET "
                + "ProductName ='" + p.getProductName() +"',"
                + "Price = '" + p.getPrice() + "',"
                + additionalSQL
                + "StockLevel = '" + p.getStockLevel() + "'"
                + "WHERE ProductId = '" + p.getProductId() + "'");
        }
        catch (Exception ex)
        {
            System.out.println("Error update Product:" + ex.getMessage());
        }
    }
    
    //method which updates information about a user
   
    public void editDetails(Customer c)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //sql statment for updating data
            stmt.executeUpdate("UPDATE Customers SET "
                + "FirstName = '" + c.getFirstName() + "',"
                + "LastName = '" + c.getSecondName()+ "'"
                + "WHERE Username = '" + c.getUsername()+ "'");
        }
        catch (Exception ex)
        {
            System.out.println("Error edit Product:" + ex.getMessage());
        }
    }
    
    
    //method which deletes customer's account
    public void deleteAccount(Customer c)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //sql statment for updating data
            stmt.executeUpdate("DELETE FROM Customers WHERE Username = '" + c.getUsername()+ "'");
        }
        catch (Exception ex)
        {
            System.out.println("Error deleting account:" + ex.getMessage());
        }
    }
    
    //method which loads all the orders within database
    public HashMap<String,Customer> loadCustomersOrders(HashMap<String,Customer> customers)
    {
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //sql statment for selecting all data from orders
            ResultSet rs = stmt.executeQuery("SELECT * FROM Orders");
            //looping through every order
            while (rs.next())
            {
                //get values from database
                int orderId = rs.getInt("OrderId");
                String stringOrderDate =rs.getString("OrderDate");
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date orderDate = format.parse(stringOrderDate);
                String username = rs.getString("Username").trim();
                double orderTotal = rs.getDouble("OrderTotal");
                String status = rs.getString("Status");
                //get current customer
                Customer customerWithOrder = customers.get(username);
                //basec error detaction for missing customers from db
                if (customerWithOrder == null) {
                    System.out.println("Skipping order " + orderId + 
                                       " – customer not found: " + username);
                    continue;
                }
                //create a new order object
                Order loadedOrder = new Order(orderId, orderDate, orderTotal, status);
                //add order to orders hashMap
                customerWithOrder.getorders().put(orderId, loadedOrder);
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error:" + ex.getMessage());
        }
        finally
        {
            return customers;
        }
        
    }
    //method which responsible for regestering a customer
    public boolean registerCustomer(Customer c)
    {
        boolean canRegister = true;
        try
        {
            Class.forName(driver);
            Connection conn = DriverManager.getConnection(connectionString);
            Statement stmt = conn.createStatement();
            //sql statment to update a database
            stmt.executeUpdate("INSERT INTO Customers (Username, Password, FirstName, LastName, AddressLine1, AddressLine2, Town, Postcode)" + 
                    "VALUES ("
                    + "'" + c.getUsername() +  "'," + 
                            "'" + c.getPassword() +"'," +
                                    "'" + c.getFirstName() +"',"+ 
                                            "'" + c.getSecondName() +"',"+
                                                "'" + c.getaddressLine1() +"',"+
                                                    "'" + c.getaddressLine2() +"',"+
                                                        "'" + c.gettown() +"',"+
                                                            "'" + c.getpostcode()+"')");
        }
        catch(Exception ex)
        {
            canRegister = false; // means username is already in use
        }
        finally
        {
            return canRegister; //returns true if new customer is created and false if failed
        } 
    }
} //end of the class
