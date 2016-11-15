package testes;

import java.util.Calendar;

import jdbc.dao.ContatoDao;
import modelo.Contato;

public class TestaInsere {

	public static void main(String[] args) {
		//este comentarioa eh apenas para testar um commit
		//contato para gravar no banco
		Contato contato = new Contato();
		
		contato.setNome("Roberto");
		contato.setEmail("roberto@gmail.com");
		contato.setEndereco("Rua Farao 567");
		contato.setDataNascimento(Calendar.getInstance());
		
		ContatoDao contatoDao = new ContatoDao();
		contatoDao.Adiciona(contato);
		System.out.println("Gravado no banco saporra");
	}

}
