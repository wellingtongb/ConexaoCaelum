package jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	
	public Connection GetConection()
	{
		try{
			return DriverManager.getConnection("jdbc:mysql://localhost/"
					+ "bancodadosteste?autoReconeect=true&useSSL=false", "root", "qwert1234");
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}
