package logical;

import java.util.ArrayList;

public class Temas {
	
	private int id_tema;
	private String titulo;
	private String genero;
	private String Duracion;
	private int posicionDentroDeLaReproduccion;
	private Artista artistAutor;
	private Grupo grupoAutor;
	private ArrayList<Artista> artistasInvitados;
	private ArrayList<Grupo> gruposInvitados;
	
	public Temas(int id_tema, String titulo, String genero, String duracion, int posicionDentroDeLaReproduccion,
			ArrayList<Artista> artistasInvitados, ArrayList<Grupo> gruposInvitados, Artista artistAutor, Grupo grupoAutor) {
		super();
		this.id_tema = id_tema;
		this.titulo = titulo;
		this.genero = genero;
		Duracion = duracion;
		this.posicionDentroDeLaReproduccion = posicionDentroDeLaReproduccion;
		this.artistasInvitados = artistasInvitados;
		this.gruposInvitados = gruposInvitados;
		this.artistAutor = artistAutor;
		this.grupoAutor = grupoAutor;
		}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getDuracion() {
		return Duracion;
	}

	public void setDuracion(String duracion) {
		Duracion = duracion;
	}

	public int getPosicionDentroDeLaReproduccion() {
		return posicionDentroDeLaReproduccion;
	}

	public void setPosicionDentroDeLaReproduccion(int posicionDentroDeLaReproduccion) {
		this.posicionDentroDeLaReproduccion = posicionDentroDeLaReproduccion;
	}

	public ArrayList<Artista> getArtistasInvitados() {
		return artistasInvitados;
	}

	public void setArtistasInvitados(ArrayList<Artista> artistasInvitados) {
		this.artistasInvitados = artistasInvitados;
	}

	public ArrayList<Grupo> getGruposInvitados() {
		return gruposInvitados;
	}

	public void setGruposInvitados(ArrayList<Grupo> gruposInvitados) {
		this.gruposInvitados = gruposInvitados;
	}

	public int getId_tema() {
		return id_tema;
	}
	
	public Artista getArtistAutor() {
		return artistAutor;
	}

	public Grupo getGrupoAutor() {
		return grupoAutor;
	}
	
}