package entidad;

import java.sql.Date;

public class Cliente {
	private int idCliente;
	private String nomCliente;
	private String apeCLiente;
	private String dni;
	private Date fecNacimiento;
	private Tipo_Cliente tipo;
	private int idTipoCliente;
	private String nomTipo;
	
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public String getNomCliente() {
		return nomCliente;
	}
	public void setNomCliente(String nomCliente) {
		this.nomCliente = nomCliente;
	}
	public String getApeCLiente() {
		return apeCLiente;
	}
	public void setApeCLiente(String apeCLiente) {
		this.apeCLiente = apeCLiente;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public Date getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public Tipo_Cliente getTipo() {
		return tipo;
	}
	public void setTipo(Tipo_Cliente tipo) {
		this.tipo = tipo;
	}
	public int getIdTipoCliente() {
		return idTipoCliente;
	}
	public void setIdTipoCliente(int idTipoCliente) {
		this.idTipoCliente = idTipoCliente;
	}
	public String getNomTipo() {
		
		nomTipo = tipo.getNombre();
		return nomTipo;
	}
	public void setNomTipo(String nomTipo) {
		this.nomTipo = nomTipo;
	}
	

	
	
	
	
}
