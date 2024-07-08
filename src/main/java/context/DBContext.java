package context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
	
	public static void main(String[] args) {
	 try {
		 System.out.println(new DBContext().getConnection());
	 }catch(Exception e) {
		 System.out.println("Not Connect");
		 System.out.println(e);
	 }	 	
}
	String url = "jdbc:mysql://localhost:3306/wish?useSSL=false";
	String user = "root";
	String pass = "123456";
	public Connection getConnection() throws Exception {
		 Class.forName("com.mysql.cj.jdbc.Driver");
		return  DriverManager.getConnection(url,user,pass);
	}
	


}
