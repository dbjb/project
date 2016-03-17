// DBConnection.java  name: DBConnection Class
// Writen by Nikolay Kravchuk.
// Date: 05/15/2014

import java.sql.*;
import java.util.Vector;


// Connection class that handels DB connection.
public class DBConnection {
	private Connection Conn ; 
	// Initialize connection 
	 DBConnection( String theConnectionURL, String theUserName, String theUserPassword)
	 {
	  // try connect 
	       try {
	          //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	          Class.forName("com.mysql.jdbc.Driver");
	          Conn = DriverManager.getConnection(theConnectionURL, theUserName, theUserPassword);
	          // debug to console
	          System.out.println("connected");        
	       } catch (Exception e) {
	        // show error
	          e.printStackTrace();
	       }
	 } // end Initialization
	
	// run query
//	public String SelectQuery(String query){
//	    Statement statement;
//	    String result = "";
//		try {
//			statement = Conn.createStatement();
//	        String queryString; 
//	        if (query == ""){
//	        	queryString = "select * from sysobjects where type='u'";
//	        } else {
//	        	queryString = query;
//	        }
//	        ResultSet rset = statement.executeQuery(queryString);
//	        while (rset.next()) {
//	           result = rset.getString(1);
//	        }
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return result;
//	}
//	
//	// update query
//	public int UpdateQuery(String query){
//		Statement stm;
//		int result = 0;
//		try {
//			stm = Conn.createStatement();
//			stm.executeUpdate(query); 
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	 return result;
//	}
//	
//	public Product getProductDetail(int prod_id) throws SQLException
//	{
//		Statement statement = Conn.createStatement();
//		String queryString = " select p.ProductID, p.ProductCode,p.ProductName, p.Description, p.ListPrice, " +
//				" p.DiscountPercent, p.DateAdded, p.OnHand, isNull( (SELECT Reviews = " +
//				" Stuff((SELECT concat(' ; ', description) AS [text()] " +
//				" FROM  " +
//				" (SELECT  description FROM ProductReview" +
//				" where productid = p.productid" +
//				" ) x" +
//				" For XML PATH ('')),2,1,'')), '')  as reviews from products p " +
//				" where p.productid = '" + prod_id + "'";
//				//"select * from products where productId = '" + prod_id + "'";
//		ResultSet rset = statement.executeQuery(queryString);
//		while (rset.next()) {	         
//	        Product p = new Product();
//	        p.Description = rset.getString("Description");
//			p.Name = rset.getString("ProductName");		
//			p.InStock = rset.getInt("OnHand");
//			//p.Relavance = 0.2; // default value
//			p.Price = rset.getDouble("ListPrice");
//			p.ProductID = rset.getInt("ProductID");
//			// NEEDS TO DO / SPLIT THIS COMMECT AND ADD IT TO MY TABLE
//			p.UserComments = rset.getString("Reviews").split(";");
//					//new String [] { "I bought this product last year and it's still the best monitor I've had.", "After 6 months the color started going out, not sure if it was just mine or all of them" };
//			return p;
//        }
//		return null;
//	}
//	// Returns OrderDetail
//	public Order getOrderDetail(int order_id) throws SQLException
//	{	
//		Statement statement = Conn.createStatement();
//		String  queryString = "SELECT o.OrderID, " +
//				 "c.CustomerID, " +
//				 "c.FirstName + ', ' + c.LastName as Name, " +
//				 "c.emailAddress, " +
//				 "o.OrderDate, " +
//				 "(select StatusDescription from OrderStatus where StatusID = o.StatusID) as \"Status\", " +
//				 "sum((oi.ItemPrice - oi.DiscountAmount) * oi.Quantity) as TotalCost, " +
//				 "(select  CONCAT(Line1, ' ',  City, ', ', State,', ', ZipCode) from Addresses where AddressID = o.BillingAddressID) as BillingAddress, " +
//				 "(select  line2 from Addresses where AddressID = o.BillingAddressID ) as BillingInfo, " +
//				 "(select  concat(Line1, ' ', City, ', ', State, ', ', ZipCode) from Addresses where AddressID = o.ShipAddressID ) as ShippingAddress " +
//				 "FROM Customers c " +
//				 "JOIN Orders o " +
//				 "	on o.CustomerID = c.CustomerID " +
//				 "JOIN OrderItems oi " +
//				 "	on oi.OrderID = o.OrderID " +
//				 " WHERE o.orderid = '" + order_id  + "' " + 
//				 "GROUP BY o.OrderID, c.CustomerID, c.FirstName, c.LastName, c.emailaddress, o.OrderDate, o.StatusID, o.BillingAddressID, o.ShipAddressID;";
//		ResultSet rset = statement.executeQuery(queryString);
//		while (rset.next()) {	         
//			Order o = new Order();
//			o.OrderID = rset.getInt("OrderId");
//			o.Customer = new Customer();
//			o.Customer.CustomerID = rset.getInt("customerid");
//			o.Customer.Name = rset.getString("name");
//			o.Customer.Email = rset.getString("emailAddress");
//			o.OrderDate = rset.getDate("OrderDate");
//			o.Status = rset.getString("Status");
//			o.TotalCost = rset.getDouble("TotalCost");
//			o.BillingAddress = rset.getString("billingaddress");
//			o.BillingInfo	 = rset.getString("billinginfo");
//			o.ShippingAddress= rset.getString("shippingAddress");
//			o.LineItems = getLineItems(o);
//			return o;
//        }
//		return null;
//	}
//	
//// returns array of products all
//	public Product[] SelectProducts(){
//
//	 Product prod[];
//	 Vector<Product> vProduct = new Vector<Product>();
//	 
//	    Statement statement;
//		try {
//			statement = Conn.createStatement();
//
//	        String queryString;
//	        ResultSet rset;
//	        queryString = "select * from products";
//	        rset = statement.executeQuery(queryString);
//	        
//	        while (rset.next()) {	         
//		        Product p = new Product();
//				p.Description = rset.getString("Description"); //"A great monitor";
//				p.Name = rset.getString("ProductName"); //"Monitor, 19 in";
//				p.InStock = rset.getInt("OnHand"); //10;
//				p.Price = rset.getDouble("ListPrice"); // 196;
//				p.ProductID = rset.getInt("ProductID");
//				vProduct.add(p);
//	        }
//	        prod = new Product[vProduct.size()];
//	   	vProduct.toArray(prod);
//		 return prod;
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
// 
// // return Array of Customers
// public Customer[] getAllCustomers() throws SQLException{
//	 Customer custArr[];
//	 Vector<Customer> vCustomer = new Vector<Customer>();
//	 
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//	 queryString = "select * from customers;";
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 Customer c = new Customer();
//		 c.CustomerID = rset.getInt("CustomerID");
//		 c.Email = rset.getString("emailAddress");
//		 c.Name = rset.getString("firstname") +  ", " + rset.getString("LastName");
//		 vCustomer.add(c);
//	 }
//	 custArr = new Customer[vCustomer.size()];
//	 vCustomer.toArray(custArr);
//	 return custArr;	  	 
// }
// 
// // get LineItems for order
// private LineItem[] getLineItems(Order order) throws SQLException{
//	 LineItem lItem[];
//	 Vector<LineItem> vLineItem = new Vector<LineItem>();
//
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//	 // new query string 
//	 queryString = "select (ItemPrice - DiscountAmount) PricePaid, " + 
//"p.Description, " + 
//"p.ProductName as Name, " +
//"p.ProductID, " +
//"oi.Quantity " + 
//" from OrderItems oi " + 
//"JOIN Products p " + 
//"on p.ProductID = oi.ProductID " + 
//"where oi.OrderID = '" + order.OrderID + "';";
//	 
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 LineItem li = new LineItem();
//			li.Order = order;
//			li.PricePaid = rset.getDouble("PricePaid");
//			li.Product = getProductDetail(rset.getInt("ProductID")); 
//			li.Product.Description = rset.getString("Description");
//			li.Product.Name = rset.getString("Name");
//			li.Quantity = rset.getInt("Quantity");
//			vLineItem.add(li);
//	 }
//	 lItem = new LineItem[vLineItem.size()];
//	 vLineItem.toArray(lItem);
//	 return lItem;	  
// }
//
// public Order[] GetPendingOrders() throws SQLException{
//	 Order ordArr[];
//	 Vector<Order> vOrder = new Vector<Order>();
//
//	 
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//	 queryString = "SELECT o.OrderID, " +
//	 "c.CustomerID, " +
//	 "c.FirstName + ', ' + c.LastName as Name, " +
//	 "c.emailAddress, " +
//	 "o.OrderDate, " +
//	 "(select StatusDescription from OrderStatus where StatusID = o.StatusID) as \"Status\", " +
//	 "sum((oi.ItemPrice - oi.DiscountAmount) * oi.Quantity) as TotalCost, " +
//	 "(select  CONCAT(Line1, ' ',  City, ', ', State,', ', ZipCode) from Addresses where AddressID = o.BillingAddressID) as BillingAddress, " +
//	 "(select  line2 from Addresses where AddressID = o.BillingAddressID ) as BillingInfo, " +
//	 "(select  concat(Line1, ' ', City, ', ', State, ', ', ZipCode) from Addresses where AddressID = o.ShipAddressID ) as ShippingAddress " +
//	 "FROM Customers c " +
//	 "JOIN Orders o " +
//	 "	on o.CustomerID = c.CustomerID " +
//	 " and o.shipDate is null " +
//	 "JOIN OrderItems oi " +
//	 "	on oi.OrderID = o.OrderID " +
//	 "GROUP BY o.OrderID, c.CustomerID, c.FirstName, c.LastName, c.emailaddress, o.OrderDate, o.StatusID, o.BillingAddressID, o.ShipAddressID;";
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 	Order o = new Order();
//			o.OrderID = rset.getInt("OrderId");
//			o.Customer = new Customer();
//			o.Customer.CustomerID = rset.getInt("customerid");
//			o.Customer.Name = rset.getString("name");
//			o.Customer.Email = rset.getString("emailAddress");
//			o.OrderDate = rset.getDate("OrderDate");
//			o.Status = rset.getString("Status");
//			o.TotalCost = rset.getDouble("TotalCost");
//			o.BillingAddress = rset.getString("billingaddress");
//			o.BillingInfo	 = rset.getString("billinginfo");
//			o.ShippingAddress= rset.getString("shippingAddress");
//			vOrder.add(o);
//	 }
//	 ordArr = new Order[vOrder.size()];
//	 vOrder.toArray(ordArr);
//	 return ordArr;	 
// }
//
// public Product[] SearchProdReview(String searchStr ) throws SQLException{
//		 Product prodArr[];
//		 Vector<Product> vProduct = new Vector<Product>();
//		 
//		 String queryString;
//		 Statement statment = Conn.createStatement();
//		 ResultSet rset ;// = statment.executeQuery(queryString);
//		 queryString = "select pr.Description, " +
//		 		" p.ProductName as Name, " +
//		 		" p.OnHand as InStock, " +
//		 		" p.ListPrice as Price, " +
//		 		" p.ProductID, " +
//		 		" pr.Rating as Relavance " +
//		 		" from Products p " +
//		 		" left join ProductReview pr " +
//		 		" 	on pr.ProductID = p.ProductID " +
//		 		//" where  contains(pr.Description, '%"+ searchStr +"%') or " +
//		 		"where FREETEXT(pr.Description, '%"+ searchStr +"%');";
//		 rset = statment.executeQuery(queryString);
//		 while(rset.next()){
//			 	Product p = new Product();
//				p.Description = rset.getString("Description");
//				p.Name = rset.getString("Name");
//				p.InStock = rset.getInt("InStock");
//				p.Price = rset.getDouble("Price");
//				p.ProductID = rset.getInt("ProductID");
//				p.Relavance = rset.getDouble("Relavance");
//				vProduct.add(p);
//		 }
//		 	prodArr = new Product[vProduct.size()];
//		 	vProduct.toArray(prodArr);
//		 return  prodArr;
//	}
//
// 
// public Order[] getCustomerOrders(Customer cust) throws SQLException{
//	 Order ordArr[];
//	 Vector<Order> vOrder = new Vector<Order>();
//	 
//	 Statement statment = Conn.createStatement();
//	 String queryString;
//	 ResultSet rset;
//
//	 queryString = "SELECT o.OrderID, " +
//	 "c.CustomerID, " +
//	 "c.FirstName + ', ' + c.LastName as Name, " +
//	 "c.emailAddress, " +
//	 "o.OrderDate, " +
//	 "(select StatusDescription from OrderStatus where StatusID = o.StatusID) as \"Status\", " +
//	 "sum((oi.ItemPrice - oi.DiscountAmount) * oi.Quantity) as TotalCost, " +
//	 "(select  CONCAT(Line1, ' ',  City, ', ', State,', ', ZipCode) from Addresses where AddressID = o.BillingAddressID) as BillingAddress, " +
//	 "(select  line2 from Addresses where AddressID = o.BillingAddressID ) as BillingInfo, " +
//	 "(select  concat(Line1, ' ', City, ', ', State, ', ', ZipCode) from Addresses where AddressID = o.ShipAddressID ) as ShippingAddress " +
//	 "FROM Customers c " +
//	 "JOIN Orders o " +
//	 "	on o.CustomerID = c.CustomerID " +
//	 "JOIN OrderItems oi " +
//	 "	on oi.OrderID = o.OrderID " +
//	 " where c.customerid = '" + cust.CustomerID + "' " +
//	 "GROUP BY o.OrderID, c.CustomerID, c.FirstName, c.LastName, c.emailaddress, o.OrderDate, o.StatusID, o.BillingAddressID, o.ShipAddressID;";
//	 rset = statment.executeQuery(queryString);
//	 while(rset.next()){
//		 	Order o = new Order();
//			o.OrderID = rset.getInt("OrderId");
//			o.Customer = new Customer();
//			o.Customer.CustomerID = rset.getInt("customerid");
//			o.Customer.Name = rset.getString("name");
//			o.Customer.Email = rset.getString("emailAddress");
//			o.OrderDate = rset.getDate("OrderDate");
//			o.Status = rset.getString("Status");
//			o.TotalCost = rset.getDouble("TotalCost");
//			o.BillingAddress = rset.getString("billingaddress");
//			o.BillingInfo	 = rset.getString("billinginfo");
//			o.ShippingAddress= rset.getString("shippingAddress");
//			vOrder.add(o);
//	 }
//	 ordArr = new Order[vOrder.size()];
//	 vOrder.toArray(ordArr);
//	 return ordArr;	 
// }
}

