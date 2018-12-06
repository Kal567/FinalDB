package logical;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.mysql.jdbc.Statement;

public class ControladorDB {
	
	private static ControladorDB ControladorDB;
	private ArrayList<Persona> misPersonas;
	private ArrayList<Usuario> misUsuarios;
	private ArrayList<Artista> misArtistas;
	private ArrayList<Album> misAlbumes;
	private ArrayList<Grupo> misAgrupaciones;
	private static ArrayList<Temas> misTemas;
	private static ControladorDB control = null;
	public static String usuario ="";
	private static Statement stmt = null;
	private static ResultSet rs = null;
	
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
	
	public boolean login(String cedula, String clave)
	{
		int i=0;
		boolean correcto = false, encontrado = false;
		//Antes vamos a validar si fue el administrador que entró
		if((cedula.equalsIgnoreCase("saul") && clave.equalsIgnoreCase("123")) || (cedula.equalsIgnoreCase("kiana") && clave.equalsIgnoreCase("123")) || (cedula.equalsIgnoreCase("jorgelin") && clave.equalsIgnoreCase("123")));
		{
			encontrado = true;
			correcto = true;
		}
		try
		{
		while(i<misUsuarios.size() || !encontrado) {
			if(misUsuarios.get(i).getId_usuario().equalsIgnoreCase(cedula))
			{
				//Si encontramos al usuario con la contraseña...
				if(misUsuarios.get(i).getContrasena().equals(clave))
				{
					correcto = true;
				}
				encontrado = true;
				
			}
			i++;
		}
		}
		catch(Exception e)
		{
			
		}
		i=0;
		return correcto;
	}
	
	
	
	public static void main(String[] args) throws SQLException {			

		
//		Connection conn = getConnection();
		ControladorDB.misTemas = new ArrayList<>();
		

		try {
//		    stmt = (Statement) conn.createStatement();
//		    createTableIfNotExists(stmt);
//		    Temas tema = new Temas("6", "la cosa", "musical", "4.20", 3, null, null);

//		    insertTema(tema);
//		    insertMusic(stmt, misTemas);
//		    rs = stmt.executeQuery("SELECT * FROM temas");
		    
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
		
//		
//		conn.close();
//		System.out.println(conn.isClosed());
		
	}
	
	public String getTipousuario(String cedula)//PARA ARREGLAR
	{
		String tipo ="";
		boolean encontrado = false;
		int i=0;
		
		if(cedula.equalsIgnoreCase("kiana"))
		{
			tipo = "Administrador";
			encontrado = true;
		}
		
		try
		{
		while(i<misUsuarios.size() || !encontrado)
		{
			if(misUsuarios.get(i).getId_usuario().equalsIgnoreCase(cedula))
			{
				tipo = "UsuarioNormal";
				encontrado = true;
			}
			i++;
		}
		}catch(Exception e)
		{
			
		}
		usuario = tipo;
		return tipo;
	}
	
	public static void getConnection(String host) throws SQLException {
		String URL = "jdbc:mysql://"+host+":3306/music_stream";
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
		stmt = (Statement) conn.createStatement();
	}
	
	public static void createTableIfNotExists(Statement stmt) throws SQLException {
		
		try {
		    stmt.execute("Create table Persona(ID_Persona int primary key not null, Primer_Nombre varchar2(50) not null, Primer_Apellido varchar2(50), Ciudad_Nacimiento varchar2(30) not null, Pais_Nacimiento varchar2(30) not null, Fecha_Nacimiento date not null, Sexo char(1) not null check (Sexo IN ('F', 'M',));");			
		} catch (Exception e) {
			System.out.println(e);
		}
//	    stmt.execute("DROP TABLE root1.bar");
	}
	
	public void insertPersona(String id, String p_nombre, String ciudad, String fecha, char sexo){
		Persona persona = new Persona(id, p_nombre, ciudad, fecha, sexo);
	}
	
	public void insertUsuario(String id_usuario, String p_nombre, String ciudad, String fecha, char sexo, 
			String id_persona, String contrasena, String fechaDeUltimoAcceso, String fechaDeRegistro, String email){
			Usuario usuario = new Usuario(id_usuario, p_nombre, ciudad, fecha, sexo, id_persona, contrasena, 
					fechaDeUltimoAcceso, fechaDeRegistro, email);
	}
	
	public void insertArtista(String id, String p_nombre, String ciudad, String fecha, char sexo, String id_artista, String id_persona, String nombreArtistico){
		Artista artista = new Artista(id, p_nombre, ciudad, fecha, sexo, id_artista, id_persona, nombreArtistico);
	}
	
	public void insertGrupo(String id_grupo, String nombre_grupo, String fechaDeFormacion, String lugarDeProcedencia){
		Grupo grupo = new Grupo(id_grupo,nombre_grupo, fechaDeFormacion, lugarDeProcedencia);
	}
	
	public static void insertMusic(ArrayList<Temas> allMusic) throws SQLException {
		try {
			for (Temas music: allMusic) {
				String artista;
				String grupo;
				if(music.getArtistAutor() != null) {
					artista = "fk_artista='"+music.getArtistAutor().getId_artista()+"', ";
				}else {
					artista = "fk_artista="+null+", ";
				}
				if(music.getGrupoAutor() != null) {
					grupo = "fk_grupo='"+music.getGrupoAutor().getId_grupo()+"', ";
				}else {
					grupo = "fk_grupo="+null+", ";
				}
				
				if(music.getArtistasInvitados() != null) {
					for(Artista artista1: music.getArtistasInvitados()) {
						stmt.execute("INSERT INTO artista_invitado set "+
					    		"ID_Tema='"+music.getId_tema()+"', "+
					    		"id_artista='"+artista1.getId_artista()+"', "+
					    		";");
					}
				}
				if(music.getGruposInvitados() != null) {
					for(Grupo grupo1: music.getGruposInvitados()) {
						stmt.execute("INSERT INTO artista_invitado set "+
					    		"ID_Tema='"+music.getId_tema()+"', "+
					    		"id_artista='"+grupo1.getId_grupo()+"', "+
					    		";");
					}
				}
	    		
			    stmt.execute("INSERT INTO temas set "+
			    		"ID_Tema='"+music.getId_tema()+"', "+
			    		"titulo_tema='"+music.getTitulo()+"', "+
			    		"Genero_Tema='"+music.getGenero()+"', "+
			    		"duracion="+music.getDuracion()+", "+
			    		"orden_tema="+music.getPosicionDentroDeLaReproduccion()+", "+
			    		artista + grupo +
			    		"fk_album="+null+
			    		";");
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int buscarArtista(String identifier)
	{
		int posicion = -1;
		int i=0;
		
		while(i<misArtistas.size() || posicion == -1)
		{
			if(misArtistas.get(i).getId_artista().equalsIgnoreCase(identifier))
			{
				posicion = i;
			}
			i++;
		}
		return posicion;
	}
	
	public int buscarUsuario(String identifier)
	{
		int posicion = -1;
		int i=0;
		
		while(i<misUsuarios.size() || posicion == -1)
		{
			if(misUsuarios.get(i).getId_usuario().equalsIgnoreCase(identifier))
			{
				posicion = i;
			}
			i++;
		}
		return posicion;
	}
	
	public int buscarGrupo(String nombre)
	{
		int posicion = -1;
		int i=0;
		
		while(i<misAgrupaciones.size() || posicion == -1)
		{
			if(misAgrupaciones.get(i).getNombre_grupo().equalsIgnoreCase(nombre))
			{
				posicion = i;
			}
			i++;
		}
		return posicion;
	}
	
	public int buscarAlbum(String identifier)
	{
		int posicion = -1;
		int i=0;
		
		while(i<misAlbumes.size() || posicion == -1)
		{
			if(misAlbumes.get(i).getId_album().equalsIgnoreCase(identifier))
			{
				posicion = i;
			}
			i++;
		}
		return posicion;
	}
	
	public int buscarTema(String identifier)
	{
		int posicion = -1;
		int i=0;
		
		while(i<misTemas.size() || posicion == -1)
		{
			if(misTemas.get(i).getId_tema().equalsIgnoreCase(identifier))
			{
				posicion = i;
			}
			i++;
		}
		return posicion;
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
	
	public static Boolean login(String username, String password, String host) throws SQLException {
		if(stmt == null) {
			getConnection(host);
		}
		Boolean result = false;
		rs = stmt.executeQuery("SELECT fk_id_persona, id_usuario FROM usuario WHERE "+
								"username='"+username+"' AND "+
								"contrasena='"+password+"';");
	    
	    if (!rs.isLast()) {
		    result = true;
		}
		return result;
	}
	
	public static ArrayList<Grupo> obtenerGrupos() throws SQLException {
		ArrayList<Grupo> result = new ArrayList<Grupo>();
		rs = stmt.executeQuery("SELECT id_grupo, nombre_grupo, fecha_formacion, ciudad_procedencia FROM grupo;");
		while (!rs.isLast()) {
			rs.next();
			result.add(new Grupo((String) rs.getObject(1), (String) rs.getObject(2), ((Date) rs.getObject(3)).toString(), (String) rs.getObject(4)));
		}
		return result;
	}

	public static ArrayList<String> obtenerArtistas() throws SQLException {
		ArrayList<String> result = new ArrayList<>();
		rs = stmt.executeQuery("SELECT nombre_artistico FROM artista;");
		while (!rs.isLast()) {
			rs.next();
			result.add((String) rs.getObject(1));
		}
		return result;
	}
	
	public static String[] obtenerAlbumes() throws SQLException {
		ArrayList<String> result = new ArrayList<>();
		rs = stmt.executeQuery("SELECT titulo FROM album;");
		while (!rs.isLast()) {
			rs.next();
			result.add((String) rs.getObject(1));
		}
		String[] result2 = new String[result.size()];
		for(int i=0;i<result.size();i++) {
			result2[i] = result.get(i);
		}
		return result2;
	}
	
	public static Album obtenerAlbum(String titulo_album) throws SQLException {
		Album result = null;
		rs = stmt.executeQuery("SELECT id_album, titulo, fecha_lanzamiento, genero_album, precio FROM album;");
		while (!rs.isLast()) {
			rs.next();
			if((String) rs.getObject(2) == titulo_album) {
				result = new Album((String) rs.getObject(1), (String) rs.getObject(2), (String) rs.getObject(3), (String) rs.getObject(4), (float) rs.getObject(5));
			}
		}
		return result;
	}
	
	public static String[] gruposToLista(ArrayList<Grupo> result) {
		String[] result2 = new String[result.size()];
		for(int i=0;i<result.size();i++) {
			result2[i] = result.get(i).getNombre_grupo();
		}
		return result2;
	}
	
	public static String[] artistasToLista(ArrayList<String> result) {
		String[] result2 = new String[result.size()];
		for(int i=0;i<result.size();i++) {
			result2[i] = result.get(i);
		}
		return result2;
	}
	
}
