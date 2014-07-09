import java.sql.*;
public class SqlTest {
public static void main (String []args){
	try
	{
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		Connection con = DriverManager.getConnection
				("jdbc:odbc:test_dsn");
		Statement st = con.createStatement();
		
		st.executeUpdate("insert into login values ('summit', '94334' )");
		con.commit();
		
		ResultSet rs = st.executeQuery ("select * from login");
		String usr = "", pass = "";
		while(rs.next()){
			usr = rs.getString(1);
			pass = rs.getString(2);
			System.out.println("ID: "+ usr +" Pass: "+ pass);
		}
	}
	catch (Exception e){
		e.printStackTrace();
	}
}
}
