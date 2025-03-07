package dao;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexaojdbc.SingleConnection;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;

public class UserPosDAO {

	private Connection connection;

	public UserPosDAO() {

		connection = SingleConnection.getConnection();
	}

	public void salvar(Userposjava userposjava) {

		try {
//			String sql = "insert into userposjava (id, nome, email) values (?,?,?)";
			String sql = "insert into userposjava ( nome, email) values (?,?)"; // id passa a ser autoincremento -
																				// 06/03/2025
			PreparedStatement insert = connection.prepareStatement(sql);
			// insert.setLong(1, userposjava.getId()); // na posição 1 = id, valor = 3
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}

	public void salvarTelefone(Telefone telefone) {
		try {

			String sql = "insert into telefoneuser ( numero,tipo,usuarioPessoa) values (?,?,?)"; // id passa a ser
																									// autoincremento -
																									// 06/03/2025
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, telefone.getNumero());
			insert.setString(2, telefone.getTipo());
			insert.setLong(3, telefone.getUsuario());
			insert.execute();
			connection.commit();

		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				e1.printStackTrace(pw);
				String msg = "Ocorreu um erro capturado pela segunda exceção " + sw.toString();
				System.out.println(msg);
			}
			StringWriter sw = new StringWriter();
			PrintWriter pw = new PrintWriter(sw);
			e.printStackTrace(pw);
			String msg = "Ocorreu um erro capturado pela primeira exceção " + sw.toString();
			System.out.println(msg);

			e.printStackTrace();
		}
	}

	public List<Userposjava> listar() throws Exception {

		List<Userposjava> list = new ArrayList<Userposjava>();

		String sql = "select * from userposjava";

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) {

			Userposjava userposjava = new Userposjava();

			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			list.add(userposjava);
		}
		return list;
	}

	public Userposjava buscar(Long id) throws Exception {

		Userposjava retorno = new Userposjava();

		String sql = "select * from userposjava where id=" + id;

		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();

		while (resultado.next()) { // retorna um ou nenhum usuário

			// Userposjava userposjava = new Userposjava();
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
		}
		return retorno;
	}

	public List<BeanUserFone> listaUserFone(Long idUser) throws SQLException {

		List<BeanUserFone> beanUserFones = new ArrayList<BeanUserFone>();

		String sql = " select nome, numero, email from telefoneuser as fone ";
		sql += " inner join userposjava as userp ";
		sql += " on fone.usuariopessoa = userp.id where userp.id = " + idUser;

		try {
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				BeanUserFone userFone = new BeanUserFone();
				userFone.setEmail(resultSet.getString("email"));
				userFone.setNome(resultSet.getString("nome"));
				userFone.setNumero(resultSet.getString("numero"));
				beanUserFones.add(userFone);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return beanUserFones;

	}

	public void deleteTelefonesPorUser(Long idUser) throws SQLException {
		try {

			String sqlFone = " delete from telefoneuser where usuariopessoa = " + idUser;
			String sqlUser = " delete from userposjava where id = " + idUser;
			/*
			 * Deletar primeiro os filhos do titular:
			 */
			PreparedStatement statement = connection.prepareCall(sqlFone);
			statement.executeUpdate();
			connection.commit();
			/*
			 * Então a seguir deletar o titular:
			 */
			statement = connection.prepareCall(sqlUser);
			statement.executeUpdate();
			connection.commit();
			
		} catch (Exception e) {
			connection.rollback();
			e.printStackTrace();
		}

	}

	public void atualizar(Userposjava userposjava) {

		String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
		try {

			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());
			statement.execute();
			connection.commit();

		} catch (SQLException e) {

			try {

				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();

		}

	}

	public void deletar(Long id) {
		try {

			String sql = "delete from userposjava where id = " + id;
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.execute();
			connection.commit();

		} catch (Exception e) {

			e.printStackTrace();

			try {

				connection.rollback();

			} catch (SQLException e1) {

				e1.printStackTrace();
			}
			e.printStackTrace();
		}
	}
}
