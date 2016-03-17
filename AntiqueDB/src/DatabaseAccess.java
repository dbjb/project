import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class DatabaseAccess {
	static String connectionUrl = "jdbc:mysql://cpanel-06.worldispnetwork.com:3306/inochi_AntiqueDB";
	static String connectionUser = "inochi_bun";
	static String connectionPassword = "123456";
	// static DBConnection db = new DBConnection(""
	//   + "jdbc:sqlserver://<MySQLServer:Port>;"
	//   + "databaseName=ClassicOnlineStore;"
	//   + "user=root;" //  DB Username
	//   + "password=<password>;" // DB password
	//   ); 
	static DBConnection db = new DBConnection(connectionUrl, connectionUser, connectionPassword);

	public static void getALL(){
		db.getALL();
	}

	//	public static Order [] GetPendingOrders()
	//	{
	//		// TODO:  Query the database and retrieve the information.
	//		// resultset.findcolumn(string col)
	//		
	//		try {
	//			return db.GetPendingOrders();
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}
	//	
	//	public static Product[] GetProducts() 
	//	{
	//		// TODO:  Retrieve all the information about the products.
	//		
	//		return  db.SelectProducts() ;
	//	}
	//
	//	public static Order GetOrderDetails(int OrderID)
	//	{
	//		// TODO:  Query the database to get the flight information as well as all 
	//		// the reservations.
	//		try {
	//			return db.getOrderDetail(OrderID);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}
	//
	//	public static Product GetProductDetails (int ProductID)
	//	{
	//		try {
	//			return db.getProductDetail(ProductID);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;	
	//	}
	//	
	//	public static Customer [] GetCustomers ()
	//	{
	//		// TODO:  Query the database to retrieve a list of customers.
	//
	//		try {
	//			return db.getAllCustomers();
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}
	//	
	//	public static Order [] GetCustomerOrders (Customer c)
	//	{
	//		try {
	//			return db.getCustomerOrders(c);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}
	//	
	//	public static Product [] SearchProductReviews(String query)
	//	{
	//		try {
	//			return db.SearchProdReview(query);
	//		} catch (SQLException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//		return null;
	//	}
	//	              
	//	public static void MakeOrder(Customer c, LineItem [] LineItems)
	//	{
	//		// TODO: Insert data into your database.
	//		// Show an error message if you can not make the reservation.
	//		String newOrderId = "";
	//		boolean isGood = false; // order validation.
	//		// create reserved orderID in a table for our order
	//		//newOrderId = db.SelectQuery("INSERT INTO Orders Values(1,GETDATE(),0.00,0.00, null, 11, 11, 1) " +
	//		//		" select @@IDENTITY;");
	//	  
	//		// for each line item add records
	//		
	//		for(LineItem li :  LineItems) {
	//		
	//			// check if we have enough product on hand
	//			if (li.Product.InStock >= li.Quantity){
	//			  isGood = true;
	//			} else // if not enough quantety available display message
	//			{
	//			// insufician quantity message.	
	//			JOptionPane.showMessageDialog(null, "Not enough items on hand. Try selecting less items.");
	//			}
	//		}
	//		 if (isGood){
	//			 // create new order 
	//			  db.UpdateQuery("insert into Orders ("
	//						+ "CustomerID, OrderDate, ShipAmount, "
	//						+ "TaxAmount, ShipDate, ShipAddressID, "
	//						+ "BillingAddressID, StatusID) "
	//						 +" VALUES(" // values for columns
	//						 + c.CustomerID
	//						 + ",GETDATE()"
	//						 + ",5.00"
	//						 + ", 0.00"
	//						 + ", null"
	//						 + ", (select ShippingAddressID  from Customers where CustomerID = '" + c.CustomerID + "')"
	//						 + ", (select BillingAddressID  from Customers where CustomerID = '" + c.CustomerID + "')"
	//						 + ",1"
	//						 + ") " );
	//				    // get our orderID
	//			  newOrderId = db.SelectQuery( " select max(orderid) from Orders where customerid = '" + c.CustomerID + "';");
	//			  for(LineItem li :  LineItems) {
	//					db.UpdateQuery(""
	//							+ "insert into OrderItems Values( "
	//							+ newOrderId
	//							+ ", " + li.Product.ProductID
	//							+ ", " + li.Product.Price
	//							+ ", " + Math.abs(li.Product.Price - li.PricePaid)
	//							+ ", " + li.Quantity
	//							+ " )");
	//					// update product table
	//					db.UpdateQuery(" update Products "
	//							+ " set OnHand  = OnHand - " + li.Quantity
	//							+ " where ProductID = '" + li.Product.ProductID + "';");
	//			  }
	//			  // succsesfull creation of order message.
	//				JOptionPane.showMessageDialog(null, "Order Created for " + c.Name + " for " + Integer.toString(LineItems.length) + " items.");
	//		 }
	//		
	//	} 
}
