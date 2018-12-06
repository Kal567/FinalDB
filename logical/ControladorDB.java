package logical;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
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

  Statement stmt = null;
  ResultSet rs = null;
  Connection conn = getConnection();
  ControladorDB.misTemas = new ArrayList<>();
  

  try {
      stmt = (Statement) conn.createStatement();
//      createTableIfNotExists(stmt);
     // Temas tema = new Temas("6", "la cosa", "musical", "4.20", 3, null, null);

      //insertTema(tema);
//      insertMusic(stmt, misTemas);
      rs = stmt.executeQuery("SELECT * FROM temas");
      
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
 
 public static Connection getConnection() {
  String URL = "jdbc:mysql://10.0.0.19:3306/music_stream";
  String user = "puto";
  String contra
= "puto";
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
//     stmt.execute("DROP TABLE root1.bar");
 }
 
 public void insertPersona(String id, String p_nombre, String s_nombre, String p_apellido, String s_apellido, String ciudad, String fecha, char sexo){
  Persona persona = new Persona(id, p_nombre, s_nombre, p_apellido, s_apellido, ciudad, fecha, sexo);
 }
 
 public void insertUsuario(String id_usuario, String p_nombre, String s_nombre, String p_apellido, String s_apellido, String ciudad, String fecha, char sexo, 
   String id_persona, String contrasena, String fechaDeUltimoAcceso, String fechaDeRegistro, String email){
   Usuario usuario = new Usuario(id_usuario, p_nombre, s_nombre, p_apellido, s_apellido, ciudad, fecha, sexo, id_persona, contrasena, 
     fechaDeUltimoAcceso, fechaDeRegistro, email);
 }
 
 public void insertArtista(String id, String p_nombre, String s_nombre, String p_apellido, String s_apellido, String ciudad, String fecha, char sexo, String id_artista, String id_persona, String nombreArtistico){
  Artista artista = new Artista(id, p_nombre, s_nombre, p_apellido, s_apellido, ciudad, fecha, sexo, id_artista, id_persona, nombreArtistico);
 }
 
 public void insertGrupo(String id_grupo, ArrayList<Artista> integrantes, String fechaDeFormacion, ArrayList<String> rol, String lugarDeProcedencia){
 // Grupo grupo = new Grupo(id_grupo, integrantes, fechaDeFormacion, rol, lugarDeProcedencia);
 }
 
 public static void insertMusic(Statement stmt, ArrayList<Temas> allMusic) throws SQLException {
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
  }
 }
 
 public static void insertPersonaBD(Statement stmt, ArrayList<Persona> Everyone) throws SQLException {
  try {
   
   for (Persona person: Everyone) {
       stmt.execute("INSERT INTO persona set "+
         "ID_Persona='"+person.getId()+"', "+
         "P_nombre='"+person.getP_nombre()+"', "+
         "S_nombre='"+person.getS_nombre()+"', "+
         "P_apellido='"+person.getP_apellido()+"', "+
         "S_apellido='"+person.getS_apellido()+"', "+
         "Ciudad_Nacimiento='"+person.getLugarDeNacimiento()+"', "+
         "Fecha_Nacimiento='"+person.getFechaDeNacimiento()+"', "+
         "Sexo='"+person.getSexo()+"'"+
         ";");
   }
   
  } catch (Exception e) {
   System.out.println(e);
  }
 }
 
 public static void deletePersonaBD(Statement stmt, Persona id_person) throws SQLException {
  stmt.execute("DELETE FROM persona where "+
       "ID_Persona='"+id_person+"', "+
       ";");
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

 
}