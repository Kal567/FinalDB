package logical;

public class Usuario extends Persona {

	private String id_usuario;
	private String id_persona;
	private String contrasena;
	private String fechaDeUltimoAcceso;
	private String fechaDeRegistro;
	private String Email;
	
	public Usuario(String id, String nombre, String lugarDeNacimiento, String fechaDeNacimiento, char sexo,
			String id_persona, String contrasena, String fechaDeUltimoAcceso, String fechaDeRegistro, String email) {
		super(id, nombre, lugarDeNacimiento, fechaDeNacimiento, sexo);
		id_usuario = "U-" + ControladorDB.getInstance().getMisUsuarios().size();
		this.id_persona = id_persona;
		this.contrasena = contrasena;
		this.fechaDeUltimoAcceso = fechaDeUltimoAcceso;
		this.fechaDeRegistro = fechaDeRegistro;
		Email = email;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFechaDeUltimoAcceso() {
		return fechaDeUltimoAcceso;
	}

	public void setFechaDeUltimoAcceso(String fechaDeUltimoAcceso) {
		this.fechaDeUltimoAcceso = fechaDeUltimoAcceso;
	}

	public String getFechaDeRegistro() {
		return fechaDeRegistro;
	}

	public void setFechaDeRegistro(String fechaDeRegistro) {
		this.fechaDeRegistro = fechaDeRegistro;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public String getId_persona() {
		return id_persona;
	}
	
	

}
