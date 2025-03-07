package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conecaojdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	public UserPosDAO()	{
		connection = SingleConnection.getConnection();
	}
	
	public void salvar (Userposjava userposjava) {
		
		try {
			String sql = "insert into userposjava (id, nome, email) values (?, ?,?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1,userposjava.getId());
			insert.setString(2, userposjava.getNome());
			insert.setString(3, userposjava.getEmail());
		    insert.execute();
			connection.commit();
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
