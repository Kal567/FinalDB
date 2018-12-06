package logical;

public class Persona {

private String id;
private String p_nombre;
private String s_nombre;
private String p_apellido;
private String s_apellido;
private String lugarDeNacimiento;
private String fechaDeNacimiento;
private char sexo;

public Persona(String id, String p_nombre, String s_nombre, String p_apellido, String s_apellido, String lugarDeNacimiento, String fechaDeNacimiento, char sexo) {
super();
this.id = "P-" + ControladorDB.getInstance().getMisPersonas().size();
this.p_nombre = p_nombre;
this.s_nombre = s_nombre;
this.p_apellido = p_apellido;
this.s_apellido = s_apellido;
this.lugarDeNacimiento = lugarDeNacimiento;
this.fechaDeNacimiento = fechaDeNacimiento;
this.sexo = sexo;
}

public String getP_nombre() {
return p_nombre;
}



public void setP_nombre(String p_nombre) {
this.p_nombre = p_nombre;
}



public String getS_nombre() {
return s_nombre;
}



public void setS_nombre(String s_nombre) {
this.s_nombre = s_nombre;
}



public String getP_apellido() {
return p_apellido;
}



public void setP_apellido(String p_apellido) {
this.p_apellido = p_apellido;
}



public String getS_apellido() {
return s_apellido;
}



public void setS_apellido(String s_apellido) {
this.s_apellido = s_apellido;
}



public void setId(String id) {
this.id = id;
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