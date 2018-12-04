package logical;

import java.util.ArrayList;

public class Grupo {
	
	private String id_grupo;
	private ArrayList<Artista> integrantes;
	private String fechaDeFormacion;
	private ArrayList<String> rol;
	private String lugarDeProcedencia;
	private ArrayList<Album> albumesAgrupacion;
	
	public Grupo(String id_grupo, ArrayList<Artista> integrantes, String fechaDeFormacion, ArrayList<String> rol,
			String lugarDeProcedencia) {
		super();
		this.id_grupo = "G-" + ControladorDB.getInstance().getMisAgrupaciones().size();
		this.integrantes = integrantes;
		this.fechaDeFormacion = fechaDeFormacion;
		this.rol = rol;
		this.lugarDeProcedencia = lugarDeProcedencia;
	}
	
	public String getId_grupo() {
		return id_grupo;
	}

	public ArrayList<Artista> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<Artista> integrantes) {
		this.integrantes = integrantes;
	}

	public String getFechaDeFormacion() {
		return fechaDeFormacion;
	}

	public void setFechaDeFormacion(String fechaDeFormacion) {
		this.fechaDeFormacion = fechaDeFormacion;
	}

	public ArrayList<String> getRol() {
		return rol;
	}

	public void setRol(ArrayList<String> rol) {
		this.rol = rol;
	}

	public String getLugarDeProcedencia() {
		return lugarDeProcedencia;
	}

	public void setLugarDeProcedencia(String lugarDeProcedencia) {
		this.lugarDeProcedencia = lugarDeProcedencia;
	}

	public ArrayList<Album> getAlbumesAgrupacion() {
		return albumesAgrupacion;
	}
	
}
