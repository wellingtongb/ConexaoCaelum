package jdbc.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
//import java.util.Date;
import java.sql.ResultSet;

import com.mysql.jdbc.PreparedStatement;

import jdbc.ConectionFactory;
import modelo.Contato;

public class ContatoDao {
	
	private Connection connection;
	
	public ContatoDao()
	{
		this.connection = new ConectionFactory().GetConection();
	}
	
	public void Adiciona (Contato contato)
	{
		String sql = "insert into contatos " +
				"(nome,email,endereco,dataNascimento)" +
				" values (?,?,?,?)";
		
		try
		{
			// prepared statement para inserção
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			//seta os valores
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			
			//executa o comando sql
			stmt.execute();
			stmt.close();			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//lista os contatos
	public ArrayList<Contato> GetLista()
	{
		try
		{
			//criando lista para salvar os contatos localizados
			ArrayList<Contato> contatoList = new ArrayList<Contato>();
			//preparestatement que recebe o comando sql
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from contatos");
			//rodando o comando sql
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next())
			{
				//criando objeto contato
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setEmail(rs.getString("email"));
				contato.setEndereco(rs.getString("endereco"));
				
				//montando a data atravez do calendar
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataNascimento"));
				contato.setDataNascimento(data);
				
				//adicionando o objeto preenchido a lista
				contatoList.add(contato);
				
			}
			rs.close();
			stmt.close();
			return contatoList;
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}


	//altera os contatos no banco
	public void Altera(Contato contato)
	{
		String sql = "update contatos set nome=?, email=?, endereco=?, dataNascimento=?"
				+ "where id =?";
		
		try
		{
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));			
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

}

