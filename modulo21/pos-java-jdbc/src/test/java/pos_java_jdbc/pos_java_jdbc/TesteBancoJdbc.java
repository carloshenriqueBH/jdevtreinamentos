package pos_java_jdbc.pos_java_jdbc;

import java.sql.SQLException;
import java.util.List;

import org.junit.Test;

import dao.UserPosDAO;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class TesteBancoJdbc {

	@org.junit.jupiter.api.Test

	public void initBanco() {
		// SingleConnection.getConnection();

		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		// userposjava.setId(5L); =-> não é mais necessário setar o ID após a criação de
		// SEQUENCE no BD - 06/03/2025
		userposjava.setNome("usuario 7");
		userposjava.setEmail("sete_da_silva@gmail.com");
		userPosDAO.salvar(userposjava);
	}

	@org.junit.jupiter.api.Test
	public void initListar() {

		UserPosDAO dao = new UserPosDAO();
		try {
			List<Userposjava> list = dao.listar();
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("--------------------------------------------------------------");
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@org.junit.jupiter.api.Test
	public void initBuscar() {

		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava userposjava = dao.buscar(3L);
			System.out.println(userposjava);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@org.junit.jupiter.api.Test
	public void initAtualizar() {

		UserPosDAO dao = new UserPosDAO();

		try {
			Userposjava objetoBanco = dao.buscar(2L);
			objetoBanco.setNome("Novo nome com método atualizar em 05/03/2025 também");
			dao.atualizar(objetoBanco);
			System.out.println(objetoBanco);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	@org.junit.jupiter.api.Test
	public void initDeletar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(7L);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@org.junit.jupiter.api.Test
	public void testeInserirTelefone() {

		Telefone telefone = new Telefone();
		UserPosDAO dao = new UserPosDAO();

		telefone.setNumero("(31) 4422-4456");
		telefone.setTipo("casa");
		telefone.setUsuario(5L);
		dao.salvarTelefone(telefone);
	}

	@org.junit.jupiter.api.Test
	public void testaCarregaFonesUser() throws SQLException {

		UserPosDAO dao = new UserPosDAO();
		List<BeanUserFone> beanUserFones = dao.listaUserFone(3L);
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("==============================================");

		}

	}
	
	@org.junit.jupiter.api.Test
	public void testeDeleteUserFone(){
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deleteTelefonesPorUser(1L);	
			
		} catch (Exception e) {
			
			e.printStackTrace();			
		}
		
	}
}
