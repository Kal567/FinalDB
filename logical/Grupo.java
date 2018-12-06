package logical;

import java.util.ArrayList;

public class Grupo {
	
	private String id_grupo;
	private String nombre_grupo;
	private String fechaDeFormacion;
	private String lugarDeProcedencia;
	private ArrayList<Album> albumesAgrupacion;
	
	public Grupo(String id_grupo, String nombre_grupo, String fechaDeFormacion,
			String lugarDeProcedencia) {
		super();
		this.id_grupo = "G-" + ControladorDB.getInstance().getMisAgrupaciones().size();
		this.setNombre_grupo(nombre_grupo);
		this.fechaDeFormacion = fechaDeFormacion;
		this.lugarDeProcedencia = lugarDeProcedencia;
	}
	
	public String getId_grupo() {
		return id_grupo;
	}

	public String getFechaDeFormacion() {
		return fechaDeFormacion;
	}

	public void setFechaDeFormacion(String fechaDeFormacion) {
		this.fechaDeFormacion = fechaDeFormacion;
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

	public String getNombre_grupo() {
		return nombre_grupo;
	}

	public void setNombre_grupo(String nombre_grupo) {
		this.nombre_grupo = nombre_grupo;
	}
	
}
