package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="turista")
public class Turista implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTurista;
	
	@Column(name="nombreTurista",nullable=false,length=20)
	private String nombreTurista;
	
	@Column(name="dniTurista", nullable=false, length=30)
	private String dniTurista;
	
	@Column(name="tlfTurista", nullable=false, length=30)
	private String tlfTurista;
	
	@Column(name="userTurista", nullable=false, length=30)
	private String userTurista;
	
	@Column(name="passTurista", nullable=false, length=30)
	private String passTurista;

	public Turista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turista(int idTurista, String nombreTurista, String dniTurista, String tlfTurista, String userTurista,
			String passTurista) {
		super();
		this.idTurista = idTurista;
		this.nombreTurista = nombreTurista;
		this.dniTurista = dniTurista;
		this.tlfTurista = tlfTurista;
		this.userTurista = userTurista;
		this.passTurista = passTurista;
	}

	public int getIdTurista() {
		return idTurista;
	}

	public void setIdTurista(int idTurista) {
		this.idTurista = idTurista;
	}

	public String getNombreTurista() {
		return nombreTurista;
	}

	public void setNombreTurista(String nombreTurista) {
		this.nombreTurista = nombreTurista;
	}

	public String getDniTurista() {
		return dniTurista;
	}

	public void setDniTurista(String dniTurista) {
		this.dniTurista = dniTurista;
	}

	public String getTlfTurista() {
		return tlfTurista;
	}

	public void setTlfTurista(String tlfTurista) {
		this.tlfTurista = tlfTurista;
	}

	public String getUserTurista() {
		return userTurista;
	}

	public void setUserTurista(String userTurista) {
		this.userTurista = userTurista;
	}

	public String getPassTurista() {
		return passTurista;
	}

	public void setPassTurista(String passTurista) {
		this.passTurista = passTurista;
	}
	
	
	
}
