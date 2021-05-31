package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="alquilerAuto")
public class AlquilerAuto implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idAlquilerAuto;
	
	@Column(name="modeloAlquilerAuto",nullable=false,length=20)
	private String modeloAlquilerAuto;
	
	@Column(name="precioAlquilerAuto", nullable=false)
	private int precioAlquilerAuto;
	
	public AlquilerAuto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlquilerAuto(int idAlquilerAuto, String modeloAlquilerAuto, int precioAlquilerAuto) {
		super();
		this.idAlquilerAuto = idAlquilerAuto;
		this.modeloAlquilerAuto = modeloAlquilerAuto;
		this.precioAlquilerAuto = precioAlquilerAuto;
	}	
	
	public int getIdAlquilerAuto() {
		return idAlquilerAuto;
	}

	public void setIdAlquilerAuto(int idAlquilerAuto) {
		this.idAlquilerAuto = idAlquilerAuto;
	}

	public String getModeloAlquilerAuto() {
		return modeloAlquilerAuto;
	}

	public void setModeloAlquilerAuto(String modeloAlquilerAuto) {
		this.modeloAlquilerAuto = modeloAlquilerAuto;
	}

	public int getPrecioAlquilerAuto() {
		return precioAlquilerAuto;
	}

	public void setPrecioAlquilerAuto(int precioAlquilerAuto) {
		this.precioAlquilerAuto = precioAlquilerAuto;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((modeloAlquilerAuto == null) ? 0 : modeloAlquilerAuto.hashCode());
		result = prime * result + idAlquilerAuto;
		result = prime * result + ((precioAlquilerAuto == null) ? 0 : precioAlquilerAuto.hashCode());
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
		AlquilerAuto other = (AlquilerAuto) obj;
		if (modeloAlquilerAuto == null) {
			if (other.modeloAlquilerAuto != null)
				return false;
		} else if (!modeloAlquilerAuto.equals(other.modeloAlquilerAuto))
			return false;
		if (idAlquilerAuto != other.idAlquilerAuto)
			return false;
		if (precioAlquilerAuto == null) {
			if (other.precioAlquilerAuto != null)
				return false;
		} else if (!precioAlquilerAuto.equals(other.precioAlquilerAuto))
			return false;
		return true;
	}
	
	
}

