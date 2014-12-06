package br.ufc.si.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String host = "localhost";
	private static final String url = "jdbc:cassandra://"+ host + ":9160/usertable";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
		return DriverManager.getConnection(url);
	}

}
