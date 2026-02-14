# 🛍️ ShopSystem - Clothing Store Management

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![NetBeans](https://img.shields.io/badge/NetBeans-1B6AC6?style=for-the-badge&logo=apache-netbeans&logoColor=white)
![MS Access](https://img.shields.io/badge/Database-MS_Access-A4373A?style=for-the-badge&logo=microsoft-access&logoColor=white)

## 📖 Overview
**ShopSystem** is a desktop application built in Java designed to simulate a complete retail management experience for a clothing store. It provides a dual-interface system: a user-friendly shopping experience for customers and a robust backend dashboard for staff to manage inventory and orders.

This project demonstrates **Object-Oriented Programming (OOP)** principles in Java, utilizing **Swing** for the Graphical User Interface (GUI) and **UCanAccess (JDBC)** for reliable database connectivity without legacy ODBC dependencies.

## ✨ Key Features

### Customer Interface
* **Secure Access:** Registration and Login functionality.
* **Smart Browsing:** View products filtered by specific categories (e.g., Men, Women, Accessories).
* **Shopping Cart:** Add items, adjust quantities, and preview the basket before purchase.
* **Checkout System:** Simulates a transaction that updates stock levels in the database in real-time.

### Admin / Staff Interface
* **Staff Authentication:** Dedicated login portal for employees.
* **Order Management:** View a history of all customer orders.
* **Inventory Control (CRUD):**
    * Add new clothing items.
    * Modify existing product details (price, stock, description).
    * Remove discontinued items.

## Technology Stack
* **Language:** Java (JDK 8+)
* **IDE:** Apache NetBeans
* **GUI Framework:** Java Swing / AWT
* **Database:** Microsoft Access (`.accdb`)
* **Connectivity:** UCanAccess JDBC Driver

## How to Run Locally

### Prerequisites
* **Java Development Kit (JDK)** installed.
* **NetBeans IDE**.
* **UCanAccess Libraries:** (Ensure `ucanaccess`, `hsqldb`, `jackcess`, `commons-lang`, and `commons-logging` JARs are in your build path).

### Installation Steps
1.  **Clone the Repository**
    ```bash
    git clone [https://github.com/yuliaVy/shopSystem.git](https://github.com/yuliaVy/shopSystem.git)
    ```

2.  **Open in NetBeans**
    * Launch NetBeans.
    * Go to **File > Open Project**.
    * Select the folder `30499854_Shop` (or the cloned folder name).

3.  **Verify Database Connection**
    * Ensure the database file (e.g., `AssessmentShopDB.accdb`) is located in the root project folder.
    * *Troubleshooting:* If you get a "Driver not found" error, right-click the **Libraries** folder in NetBeans, select **Add JAR/Folder**, and re-add the UCanAccess JAR files.

4.  **Run the Application**
    * Locate the main entry file: `src/views/MainMenu.java`.
    * Right-click the file and select **Run File**.

## Database Structure
The system uses a relational Microsoft Access database with the following key tables:
* **Users:** Stores customer and staff credentials.
* **Products:** Stores clothing details, prices, and current stock.
* **Orders:** Logs completed transactions.
* **OrderLines:** Stores all order lines for every order.

## 🧪 Testing
This application was rigorously tested to ensure data integrity and user experience quality.

* **[View Test Log](./docs/TestLog.pdf)** - Detailed test log where all main function are tested.
* **[View Screenshots](./docs/Apendix.pdf)** - Appendix stores screenshots for every test log.

**Key Scenarios Tested:**
1.  **User Registration:** Verified valid/invalid email formats.
2.  **Stock Updates:** Confirmed database stock decreases immediately after purchase.
3.  **Admin Security:** Verified that non-staff users cannot access the Admin Dashboard.

## Learning Outcomes
* integrating Java applications with **SQL databases** using JDBC.
* Designing responsive **GUI forms** using NetBeans GUI Builder.
* Implementing **Session Management** (tracking the logged-in user).
* Handling **Data Consistency** (updating stock levels immediately after a purchase).

## License
This project is for educational purposes.
