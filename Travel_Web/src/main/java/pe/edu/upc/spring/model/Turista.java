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
	
	@Column(name="tipoTurista",nullable=false,length=20)
	private String tipoTurista;
	
	@Column(name="nombreEmpresa", nullable=false, length=30)
	private String Empresa;
	
	@Column(name="precioTurista", nullable=false)
	private int precioTurista;
	
	public Turista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Turista(int idTurista, String tipoTurista, String empresa, int precioTurista) {
		super();
		this.idTurista = idTurista;
		this.tipoTurista = tipoTurista;
		Empresa = empresa;
		this.precioTurista = precioTurista;
	}

	public int getIdTurista() {
		return idTurista;
	}

	public void setIdTurista(int idTurista) {
		this.idTurista = idTurista;
	}

	public String getTipoTurista() {
		return tipoTurista;
	}

	public void setTipoTurista(String tipoTurista) {
		this.tipoTurista = tipoTurista;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public int getPrecioTurista() {
		return precioTurista;
	}

	public void setPrecioTurista(int precioTurista) {
		this.precioTurista = precioTurista;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Empresa == null) ? 0 : Empresa.hashCode());
		result = prime * result + idTurista;
		result = prime * result + precioTurista;
		result = prime * result + ((tipoTurista == null) ? 0 : tipoTurista.hashCode());
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
		if (Empresa == null) {
			if (other.Empresa != null)
				return false;
		} else if (!Empresa.equals(other.Empresa))
			return false;
		if (idTurista != other.idTurista)
			return false;
		if (precioTurista != other.precioTurista)
			return false;
		if (tipoTurista == null) {
			if (other.tipoTurista != null)
				return false;
		} else if (!tipoTurista.equals(other.tipoTurista))
			return false;
		return true;
	}
	
	
}
