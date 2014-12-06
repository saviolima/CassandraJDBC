import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class CqlJdbcTest {
	public static void main(String args[]) throws Exception{
		Connection con = null;
		long cont=0,inicial = 0;
		try {
			
			Class.forName("org.apache.cassandra.cql.jdbc.CassandraDriver");
			Scanner s = new Scanner(System.in);
			String host = s.nextLine();
			con = DriverManager.getConnection("jdbc:cassandra://"+ host + ":9160/usertable");
		    String query = s.nextLine();
			System.out.println(query);
			inicial = System.currentTimeMillis();
			Statement statement = con.createStatement();
			
			ResultSet result = statement.executeQuery(query);
			statement.close();
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally{
			if(con!=null){
				try {
					con.close();
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
				con = null;
			}
			cont = System.currentTimeMillis();
			System.out.println(cont-inicial);
		}
	}
}
