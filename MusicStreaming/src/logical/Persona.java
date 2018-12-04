package logical;

public class Persona {
	
	private String id;
	private String nombre;
	private String lugarDeNacimiento;
	private String fechaDeNacimiento;
	private char sexo;
	
	public Persona(String id, String nombre, String lugarDeNacimiento, String fechaDeNacimiento, char sexo) {
		super();
		this.id = "P-" + ControladorDB.getInstance().getMisPersonas().size();
		this.nombre = nombre;
		this.lugarDeNacimiento = lugarDeNacimiento;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.sexo = sexo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLugarDeNacimiento() {
		return lugarDeNacimiento;
	}

	public void setLugarDeNacimiento(String lugarDeNacimiento) {
		this.lugarDeNacimiento = lugarDeNacimiento;
	}

	public String getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(String fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getId() {
		return id;
	} 
	
	
	
}
