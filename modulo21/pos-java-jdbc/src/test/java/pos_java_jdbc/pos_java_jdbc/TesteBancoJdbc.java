package pos_java_jdbc.pos_java_jdbc;

import org.junit.jupiter.api.Test;

import conecaojdbc.SingleConnection;
import junit.framework.TestCase;

public class TesteBancoJdbc extends TestCase	 {
	
	@Test	
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
