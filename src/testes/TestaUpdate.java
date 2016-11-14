package testes;

import java.util.Calendar;

import jdbc.dao.ContatoDao;
import modelo.Contato;

public class TestaUpdate {

	public static void main(String[] args) {
		
		Contato contato = new Contato();
		
		contato.setNome("Rafael");
		contato.setEmail("rafael_bozo@gmail.com");
		contato.setEndereco("Rua dos catadores 862");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setId((long) 2);	//necessário passar aqui o ID que queria alterar
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.Altera(contato);
		System.out.println("alterado no banco saporra");
		contatoDao.GetLista();

	}

}
