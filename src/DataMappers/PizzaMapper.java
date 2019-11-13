
package DataMappers;

import Util.DBConnector;
import java.util.ArrayList;
import Model.Pizza;
import java.sql.*;
import java.util.Scanner;
import Model.Order;


public class PizzaMapper {
    DBConnector myConnector = new DBConnector();
        public ArrayList<Pizza> pizzaList() throws SQLException, ClassNotFoundException{
        ArrayList<Pizza> returnList = new ArrayList<Pizza>();
        /*
            `Nr` int(11) DEFAULT NULL,
            `Name` varchar(255) DEFAULT NULL,
            `Ingrediens` varchar(255) DEFAULT NULL,
            `Price` int(11) DEFAULT NULL
        
        int nr, String navn, String ingredienser, int pris
        */
               
        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;
        
        myConnector.getConnector();
        String query = "SELECT * FROM menu";
            statement = myConnector.getConnector().createStatement();
            // ResultSet sender dataen over i programmet
            resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            String name = resultSet.getString("Name");
            String ingrediens = resultSet.getString("Ingrediens");
            int nr = resultSet.getInt("PizzaNr");
            int price = resultSet.getInt("Price");
            Pizza tmpPizza = new Pizza(nr, name, ingrediens, price);
            returnList.add(tmpPizza);
        }
            
     // Lukker efter mig:
        resultSet.close();
        statement.close();
        myConnector.getConnector().close();
        
        return returnList; 
    }
    
    public Pizza getPizzaFromDBById(int pizza_nr) throws ClassNotFoundException, SQLException {
        Pizza retValPizza = null;
     // TODO: Get movie from DB
        String query = "Select * from menu where Nr = ?";
        DBConnector myConnector = new DBConnector();  
        myConnector = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        
        myConnector.getConnector();
        pstmt = myConnector.getConnector().prepareStatement(query);
        pstmt.setInt(1, pizza_nr);
     // Så burde der være kommet et resultSet tilbage:
        resultSet = pstmt.executeQuery();
        while(resultSet.next()){
            String name = resultSet.getString("Name");
            String ingrediens = resultSet.getString("Ingrediens");
            int nr = resultSet.getInt("PizzaNr");
            int price = resultSet.getInt("Price");
            retValPizza = new Pizza(nr, name, ingrediens, price);
        }
     
     // Lukker efter mig:
        resultSet.close();
        pstmt.close();
        myConnector.getConnector().close();
        
        return retValPizza;
    }
    
    public ArrayList<Order> orderList() throws SQLException, ClassNotFoundException{
         ArrayList<Order> returnList = new ArrayList<Order>();
		PreparedStatement myStmt = null;

		Scanner scanner = null;

		try {
			// 0. read user input from command line: last name, first name and email
			scanner = new Scanner(System.in);

			System.out.print("Enter your last name: ");
			String lastName = scanner.nextLine();

			System.out.print("Enter your first name: ");
			String firstName = scanner.nextLine();

			System.out.print("Enter your email: ");
			String email = scanner.nextLine();

			// 1. Get a connection to database
                        
                        myConnector.getConnector();

			// 2. Create a statement
			String sql = "insert into employees "
				+ " (last_name, first_name, email)" + " values (?, ?, ?)";

			myStmt = myConnector.getConnector().prepareStatement(sql);
                        
                        
			// set param values
			myStmt.setString(1, lastName);
			myStmt.setString(2, firstName);
			myStmt.setString(3, email);

			// 3. Execute SQL query
			myStmt.executeUpdate();

			System.out.println("Insert complete.");
		} catch (Exception exc) {
			exc.printStackTrace();
		} finally {
			if (myStmt != null) {
				myStmt.close();
			}

			if (myConnector != null) {
				myConnector.getConnector().close();
			}

			if (scanner != null) {
				scanner.close();
			}
		}
        return returnList;
	}

        
        /*
            `OrderID` int(11) DEFAULT NULL,
            `PizzaNr` int(11) DEFAULT NULL,
            `Name` varchar(255) DEFAULT NULL,
            `Quantity` int(11) DEFAULT NULL,
            `Price` int(11) DEFAULT NULL
            `TotalPrice` int(11) DEFAULT NULL
        
        // 1. Create a statement
	String sql = "insert into employees "
            + " (last_name, first_name, email)" 
            + " values (?, ?, ?)";

	myStmt = myConn.prepareStatement(sql);

	// 2. set param values
	myStmt.setString(1, lastName);
	myStmt.setString(2, firstName);
	myStmt.setString(3, email);

	// 3. Execute SQL query
	myStmt.executeUpdate();
        
        
        DBConnector myConnector = new DBConnector();        
        // TODO: hent fra databasen
        Statement statement = null;
        ResultSet resultSet = null;
        
        myConnector.getConnector();
        String query = "SELECT * FROM orders";
            statement = myConnector.getConnector().createStatement();
            // ResultSet sender dataen over i programmet
            resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            int orderID = resultSet.getInt("OrderID");
            String name = resultSet.getString("Name");
            int quantity = resultSet.getInt("Quantity");
            int pizzaNr = resultSet.getInt("PizzaNr");
            int price = resultSet.getInt("Price");
            int totalPrice = resultSet.getInt("TotalPrice");
            Order tmpOrder = new Order(List<pizza>, 0);
            returnList.add(tmpOrder);
        }
            
     // Lukker efter mig:
        resultSet.close();
        statement.close();
        myConnector.getConnector().close();
        
        return returnList; 
    }
    
    */
    public Order setOrderToDBById(int orderID) throws ClassNotFoundException, SQLException {
        Order retValOrder = null;
        PreparedStatement myStmt = null;
        Scanner scanner = null;
        try {
	// 0. read user input from command line: last name, first name and email
	scanner = new Scanner(System.in);

	System.out.print("Pick order by ID: ");
	String orderId = scanner.nextLine();
        
	

	// 1. Get a connection to database
	myConnector.getConnector();

	// 2. Create a statement
	String sql = "insert into order list "
				+ " (order_ID)" + " values (?)";

	myStmt = myConnector.getConnector().prepareStatement(sql);
                        

	// set param values
	myStmt.setInt(1, orderID);
	

	// 3. Execute SQL query
	myStmt.executeUpdate();
        
	System.out.println("Insert complete.");
	} catch (Exception exc) {
		exc.printStackTrace();
	} finally {
	if (myStmt != null) {
		myStmt.close();
		}

	if (myConnector != null) {
		myConnector.getConnector().close();
	}

	if (scanner != null) {
		scanner.close();
	}
	}
        return retValOrder;
    }
    
    
}
