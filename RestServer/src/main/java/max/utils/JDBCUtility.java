package max.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtility {
	private JDBCUtility() {
		// Private constructor to prevent instantiation
	}

	private static Connection con;

	static {
		try {
			// Load MySQL JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establish connection to MySQL database
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/coaching", "root", "1234");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found. Include the JDBC jar in your project.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Failed to establish a database connection.");
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		return con;
	}
}
