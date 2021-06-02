package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="administrador")
public class Administrador implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAdministrador;
	
	@Column(name="userAdministrador", nullable=false, length=30)
	private String userAdministrador;
	
	@Column(name="passAdministrador", nullable=false, length=30)
	private String passAdministrador;

	public Administrador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrador(int idAdministrador, String userAdministrador, String passAdministrador) {
		super();
		this.idAdministrador = idAdministrador;
		this.userAdministrador = userAdministrador;
		this.passAdministrador = passAdministrador;
	}

	public int getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(int idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public String getUserAdministrador() {
		return userAdministrador;
	}

	public void setUserAdministrador(String userAdministrador) {
		this.userAdministrador = userAdministrador;
	}

	public String getPassAdministrador() {
		return passAdministrador;
	}

	public void setPassAdministrador(String passAdministrador) {
		this.passAdministrador = passAdministrador;
	}
	
	
}
