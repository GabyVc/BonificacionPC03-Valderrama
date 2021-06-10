package entidad;

import java.sql.Date;

public class Cliente {
	
	private int idCliente;
	private String nombres;
	private String apellidos;
	private String DNI;
	private Date fechNac;
	private TipoCliente TipoCliente;
	private String nombre;
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDNI() {
		return DNI;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	public Date getFechNac() {
		return fechNac;
	}
	public void setFechNac(Date fechNac) {
		this.fechNac = fechNac;
	}
	public TipoCliente getTipoCliente() {
		return TipoCliente;
	}
	public void setTipoCliente(TipoCliente tipoCliente) {
		TipoCliente = tipoCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
