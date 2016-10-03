import java.sql.*;

public class connectionBD {

	public static void main(String[] args) {

		String driver = "org.postgresql.Driver";
		String connectString = "jdbc:postgresql://localhost:5432/pBD";
		String user = "jlbocanegra";
		String password = "jl";

		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {

			System.out.println("****ATENCION**--->DRIVER LOADER  "+e.getMessage());
			e.printStackTrace();
		}

		try {
			Connection con = DriverManager.getConnection(connectString,user,password);
			System.out.println("******Parece que la conexión ha sido realizada con exito******");

			Statement stmt = con.createStatement();

			ResultSet rs = stmt.executeQuery("SELECT * from Departamento");

			while(rs.next()) {
				System.out.println(rs.getString("cod_dep")+"-"+rs.getString("nombre")+"-"+rs.getString("Director")+"-"+rs.getString("telefono"));
			}

			stmt.close();
			con.close(); 
			
		}
		catch (Exception e) {
			System.out.println("***ATENCION----PROBANDO***"+e.getMessage());
		}

	}
}
