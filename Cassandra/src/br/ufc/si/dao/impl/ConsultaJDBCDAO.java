package br.ufc.si.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import br.ufc.si.dao.ConsultaDAO;
import br.ufc.si.util.ConnectionFactory;

public class ConsultaJDBCDAO implements ConsultaDAO{

	@Override
	public ResultSet getResultSerConsulta(String query) {
		Connection conexao = null;
		try {
			conexao = ConnectionFactory.getConnection();
			Statement st = conexao.createStatement();
			ResultSet resultSet = st.executeQuery(query);
			st.close();
			resultSet.close();
			return resultSet;
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				conexao.close();
			} catch (SQLException e) {
				System.err.println(e.getMessage());
			}
		}
		return null;
	}

}
