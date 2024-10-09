package hotel.managnment.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conn {
	 Connection c ;
		Statement stmt;

	Conn() throws ClassNotFoundException, SQLException{
		
		// connecting to database 
		
		// load driver class 
	
	 Class.forName("com.mysql.cj.jdbc.Driver");
		
	 // make connection 
	 
	 c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagnmentsystem","root","9876@zyxA");
		
		// create statement 
	 
	 stmt= c.createStatement();
	
	
	 
	 
	}

	public static void main(String[] args) {
		

	}

}
