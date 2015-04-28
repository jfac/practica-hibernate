package bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class BeanUser {
	private String Nombre, ApellidoMaterno,ApellidoPaterno, RFC, CorreoElectronico;
	private int Id;
	
	@Column(name="NOMBRE", length=45)
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
	@Column(name="APELLIDOPATERNO", length=45)
	public String getApellidoPaterno() {
		return ApellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		ApellidoPaterno = apellidoPaterno;
	}
	
	@Column(name="APELLIDOMATERNO", length=45)
	public String getApellidoMaterno() {
		return ApellidoMaterno;
	}
	public void setApellidoMaterno(String apellidoMaterno) {
		ApellidoMaterno = apellidoMaterno;
	}
	
	@Column(name="RFC", length=13)
	public String getRFC() {
		return RFC;
	}
	public void setRFC(String rFC) {
		RFC = rFC;
	}
	
	@Column(name="CORREOELECTRONICO", length=45)
	public String getCorreoElectronico() {
		return CorreoElectronico;
	}
	public void setCorreoElectronico(String correoElectronico) {
		CorreoElectronico = correoElectronico;
	}
	@Id 
    @Column(name="ID", unique=true, nullable=false)
    @GeneratedValue(strategy=GenerationType.AUTO)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
}
