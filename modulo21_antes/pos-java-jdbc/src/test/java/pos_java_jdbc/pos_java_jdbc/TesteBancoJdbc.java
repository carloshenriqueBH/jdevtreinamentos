package pos_java_jdbc.pos_java_jdbc;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import conecaojdbc.SingleConnection;
import dao.UserPosDAO;
import junit.framework.TestCase;
import model.Userposjava;

public class TesteBancoJdbc extends TestCase	 {
	
	@Test	
	public void initBanco() {
	//	SingleConnection.getConnection();
		UserPosDAO userPosDAO = new UserPosDAO();
		EncheUsuarios encheUsuarios = new EncheUsuarios();
		for (int i = 10001; i <= 20000; i ++) {
			Long chave = Long.valueOf(i);
		    String nomeUsuario = encheUsuarios.retornaNome();
		    System.out.println(i + " "+nomeUsuario);
		    String[] nomeEmail = nomeUsuario.split(" ");
		    int palavras = nomeEmail.length;
		    String email = nomeEmail[0]+nomeEmail[palavras-1]+"@hotmail.com";
			Userposjava userposjava = new Userposjava();		
			userposjava.setId(chave);
			userposjava.setNome(nomeUsuario);
			userposjava.setEmail(email);
			userPosDAO.salvar(userposjava);				
		}		
	}
}
