package pachet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConector 
{

static {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.print("ClassNotFoundException: " + e);
		}
		
	}
	
	public static Connection getConnection()
	{
		Connection con = null;
		try 
		{
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda", "root", "");
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
	
}
