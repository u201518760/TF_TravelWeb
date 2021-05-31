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

	public Turista(int idTurista, String nombreTurista, String dniTurista, String tlfTurista,String userTurista,String passTurista) {
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
	
	public int getDniTurista() {
		return dniTurista;
	}

	public void setDniTurista(String dniTurista) {
		this.dniTurista = dniTurista;
	}
	
	public int getTlfTurista() {
		return tlfTurista;
	}

	public void setTlfTurista(String tlfTurista) {
		this.tlfTurista = tlfTurista;
	}
	
	public int getUserTurista() {
		return dniTurista;
	}

	public void setUserTurista(String userTurista) {
		this.userTurista = userTurista;
	}
	
	public int getPassTurista() {
		return dniTurista;
	}

	public void setPassTurista(String passTurista) {
		this.passTurista = passTurista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreTurista == null) ? 0 : nombreTurista.hashCode());
		result = prime * result + idTurista;
		result = prime * result + tlfTurista;
		result = prime * result + userTurista;
		result = prime * result + passTurista;
		result = prime * result + ((dniTurista == null) ? 0 : dniTurista.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turista other = (Turista) obj;
		if (nombreTurista == null) {
			if (other.nombreTurista != null)
				return false;
		} else if (!nombreTurista.equals(other.nombreTurista))
			return false;
		if (idTurista != other.idTurista)
			return false;
		if (tlfTurista != other.tlfTurista)
			return false;
		if (userTurista != other.userTurista)
			return false;
		if (passTurista != other.passTurista)
			return false;
		if (dniTurista == null) {
			if (other.dniTurista != null)
				return false;
		} else if (!dniTurista.equals(other.dniTurista))
			return false;
		return true;
	}
	
	
}
