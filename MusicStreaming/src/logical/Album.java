package logical;

import java.util.ArrayList;

public class Album {
	
	private String id_album;
	private ArrayList<Temas> temasDelAlbum;
	private String titulo;
	private String fechaDeLanzamiento;
	private String genero;
	private float precio;
	
	public Album(String id_album, String titulo, String fechaDeLanzamiento, String genero, float precio) {
		super();
		this.id_album = "Al-" + ControladorDB.getInstance().getMisAlbumes().size();
		this.titulo = titulo;
		this.fechaDeLanzamiento = fechaDeLanzamiento;
		this.genero = genero;
		this.precio = precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getFechaDeLanzamiento() {
		return fechaDeLanzamiento;
	}

	public void setFechaDeLanzamiento(String fechaDeLanzamiento) {
		this.fechaDeLanzamiento = fechaDeLanzamiento;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public String getId_album() {
		return id_album;
	}
	
}
