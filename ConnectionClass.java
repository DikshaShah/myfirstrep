package student_opts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.xdevapi.Statement;
@SuppressWarnings("unused")

public class ConnectionClass {

	public static void main(String[] args)  {
		Connection con = doConnect();
		/*
		 * Statement st = (Statement) con.createStatement(); ResultSet rs =
		 * ((java.sql.Statement) st).executeQuery("select* from student_info");
		 * while(rs.next()) {
		 * System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)); }
		 */
	}
	public static Connection doConnect() 
	{
		Connection conn = null;
		try
		{
		   String driver = "com.mysql.cj.jdbc.Driver";
		   String url  = "jdbc:mysql://localhost:3306/org";
		   String username = "root";
		   String password = "4689";
		   Class.forName(driver); //class not found
		   conn = DriverManager.getConnection(url,username,password);//No suitable driver found
		   System.out.println("Connected...");
		   return conn;
		}
		catch(SQLException e)
		{
			System.out.println("No suitable driver found");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("class not found");
		}
			return conn;
	}
}