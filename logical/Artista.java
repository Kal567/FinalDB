 package logical;

import java.util.ArrayList; 

public class Artista extends Persona {
 
 private String id_artista;
 private String id_persona;
 private String nombreArtistico;
 private ArrayList<Album> albumesArtista;
 
 public Artista(String id, String p_nombre, String s_nombre, String p_apellido, String s_apellido, String lugarDeNacimiento, String fechaDeNacimiento, char sexo,
   String id_artista, String id_persona, String nombreArtistico) {
  super(id, p_nombre, s_nombre, p_apellido, s_apellido, lugarDeNacimiento, fechaDeNacimiento, sexo);
  this.id_artista = "A-" + ControladorDB.getInstance().getMisArtistas().size();
  this.id_persona = id_persona;
  this.nombreArtistico = nombreArtistico;
 }

 public String getId_artista() {
  return id_artista;
 }

 public void setId_artista(String id_artista) {
  this.id_artista = id_artista;
 }

 public String getId_persona() {
  return id_persona;
 }

 public void setId_persona(String id_persona) {
  this.id_persona = id_persona;
 }

 public String getNombreArtistico() {
  return nombreArtistico;
 }

 public void setNombreArtistico(String nombreArtistico) {
  this.nombreArtistico = nombreArtistico;
 }

}