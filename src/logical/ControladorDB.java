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
	private static ArrayList<Temas> misTemas;
	private static ControladorDB control = null;
	
	private ControladorDB() {
		super();
		this.misPersonas = new ArrayList<>();
		this.misUsuarios = new ArrayList<>();
		this.misArtistas = new ArrayList<>();
		this.misAlbumes = new ArrayList<>();
		this.misAgrupaciones = new ArrayList<>();
		ControladorDB.misTemas = new ArrayList<>();
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

		Statement stmt = null;
		ResultSet rs = null;
		Connection conn = getConnection();
		ControladorDB.misTemas = new ArrayList<>();
		

		try {
		    stmt = (Statement) conn.createStatement();
//		    createTableIfNotExists(stmt);
		    Temas tema = new Temas(6, "la cosa", "musical", "4.20", 3, null, null);

<<<<<<< HEAD
		    rs = stmt.executeQuery("SELECT * FROM tema");
		    insertTema(new Temas("0000", "la cosa", "musical", "10:20", 2, null, null));
=======
		    insertTema(tema);
//		    insertMusic(stmt, misTemas);
		    rs = stmt.executeQuery("SELECT * FROM temas");
>>>>>>> branch 'feature' of https://github.com/Kal567/FinalDB.git
		    
		    while (!rs.isLast()) {
			    rs.next();
			    System.out.println(rs.getObject(1)+", "+rs.getObject(2));
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
	
	public static Connection getConnection() {
<<<<<<< HEAD
		String URL = "jdbc:mysql://10.128.137.19:3306/music_stream";
=======
		String URL = "jdbc:mysql://10.0.0.6:3306/music_stream";
>>>>>>> branch 'feature' of https://github.com/Kal567/FinalDB.git
		String user = "puto";
		String contra = "puto";
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL, user, contra);
			System.out.println("Noerror");
		} catch (Exception e) {
			System.out.println(e);
		}
		return conn;
	}
	
	public static void createTableIfNotExists(Statement stmt) throws SQLException {
		
		try {
		    stmt.execute("Create table Persona(ID_Persona int primary key not null, Primer_Nombre varchar2(50) not null, Primer_Apellido varchar2(50), Ciudad_Nacimiento varchar2(30) not null, Pais_Nacimiento varchar2(30) not null, Fecha_Nacimiento date not null, Sexo char(1) not null check (Sexo IN ('F', 'M',));");			
		} catch (Exception e) {
			System.out.println(e);
		}
//	    stmt.execute("DROP TABLE root1.bar");
	}
	
	public static void insertMusic(Statement stmt, ArrayList<Temas> allMusic) throws SQLException {
<<<<<<< HEAD
		for (Temas music: allMusic) {
		    stmt.execute("INSERT INTO temas VALUES("+
		    		"ID_Tema="+music.getId_tema()+", "+
		    		"Titulo_tema="+music.getTitulo()+", "+
		    		"Genero_Tema="+music.getGenero()+", "+
		    		"duracion="+music.getDuracion()+", "+
		    		"orden_tema="+music.getPosicionDentroDeLaReproduccion()+
		    		")");
=======
		try {
			for (Temas music: allMusic) {
			    stmt.execute("INSERT INTO temas set "+
			    		"ID_Tema="+music.getId_tema()+", "+
			    		"titulo_tema='"+music.getTitulo()+"', "+
			    		"Genero_Tema='"+music.getGenero()+"', "+
			    		"duracion="+music.getDuracion()+", "+
			    		"orden_tema="+music.getPosicionDentroDeLaReproduccion()+", "+
			    		"fk_artista="+null+", "+
			    		"fk_grupo="+null+", "+
			    		"fk_album="+null+
			    		";");
			}
			
		} catch (Exception e) {
			System.out.println(e);
>>>>>>> branch 'feature' of https://github.com/Kal567/FinalDB.git
		}
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
	
	public static void insertTema(Temas tema) {
		misTemas.add(tema);		
	}
	
}

