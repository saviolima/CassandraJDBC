package br.ufc.si.teste;

import java.sql.ResultSet;
import java.util.Scanner;

import br.ufc.si.dao.ConsultaDAO;
import br.ufc.si.dao.impl.ConsultaJDBCDAO;

public class ExecutaConsulta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ConsultaDAO dao = new ConsultaJDBCDAO();
		
		//Digite a consulta
		String query = sc.nextLine();
		long inicio = System.currentTimeMillis();
		ResultSet result = dao.getResultSerConsulta(query);
		long fim = System.currentTimeMillis();
		if(result != null){
			long tempo = fim - inicio;
			System.out.println(tempo);
		}else{
			System.out.println("Falha ao executar a consulta!");
		}
		
	}

}
