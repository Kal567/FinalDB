package logical;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

public class ControladorDB {
	
	private ArrayList<Persona> misPersonas;
	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Artista> misArtistas;
	private ArrayList<Album> misAlbumes;
	private ArrayList<Grupo> misAgrupaciones;
	private ArrayList<Temas> misTemas;
	private static ControladorDB control = null;
	
	private ControladorDB() {
		super();
		this.misPersonas = new ArrayList<>();
		this.misUsuarios = new ArrayList<>();
		this.misArtistas = new ArrayList<>();
		this.misAlbumes = new ArrayList<>();
		this.misAgrupaciones = new ArrayList<>();
		this.misTemas = new ArrayList<>();
	}
	
	public static ControladorDB getInstance()
	{
		if(control == null)
		{
			control = new ControladorDB();
		}
		
		return control;
	}
	
	public static void main(String[] args) throws SQLException {			
		String URL = "jdbc:mysql://localhost:3306/root2";
		String user = "root2";
		String contra = "root";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, contra);
			System.out.println("Noerror");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
		    stmt = (Statement) conn.createStatement();
//		    stmt.execute("CREATE TABLE root2.bar(id int, id2 int)");
//		    stmt.execute("DROP TABLE root1.bar");
//		    return;
//		    for (int i = 0; i < 6; i++) {
//			    stmt.execute("INSERT INTO root2.bar VALUES("+i+","+i+2+")");
//			}
		    rs = stmt.executeQuery("SELECT id FROM bar");

		    // or alternatively, if you don't know ahead of time that
		    // the query will be a SELECT...
		    
		    
		    if (stmt.execute("SELECT id, id2 FROM root2.bar")) {
		        rs = stmt.getResultSet();
		    }
		    for (int i = 0; i < 6; i++) {
			    rs.next();
			    System.out.println(rs.getObject(1)+", "+rs.getObject("id2"));
			}

		    // Now do something with the ResultSet ....
		}
		catch (SQLException ex){
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally {
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
		
		
		conn.close();
		System.out.println(conn.isClosed());
		
	}

	public ArrayList<Persona> getMisPersonas() {
		return misPersonas;
	}

	public ArrayList<Usuario> getMisUsuarios() {
		return misUsuarios;
	}

	public ArrayList<Artista> getMisArtistas() {
		return misArtistas;
	}

	public ArrayList<Album> getMisAlbumes() {
		return misAlbumes;
	}

	public ArrayList<Grupo> getMisAgrupaciones() {
		return misAgrupaciones;
	}

	public ArrayList<Temas> getMisTemas() {
		return misTemas;
	}
	
}

