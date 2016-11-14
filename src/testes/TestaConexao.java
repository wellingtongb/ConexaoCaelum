package testes;

import jdbc.ConectionFactory;
import java.sql.Connection;
import java.sql.SQLException;


public class TestaConexao {

	public static void main(String[] args) throws SQLException {
		Connection connection = new ConectionFactory().GetConection();
		System.out.println("Conexão aberta!");
		connection.close();
	}

}
