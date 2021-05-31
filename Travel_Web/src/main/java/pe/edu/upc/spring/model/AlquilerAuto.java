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
	
	@Column(name="tipoAlquilerAuto",nullable=false,length=20)
	private String tipoAlquilerAuto;
	
	@Column(name="nombreEmpresa", nullable=false, length=30)
	private String Empresa;
	
	@Column(name="precioAlquilerAuto", nullable=false)
	private int precioAlquilerAuto;
	
	public AlquilerAuto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AlquilerAuto(int idAlquilerAuto, String tipoAlquilerAuto, String empresa, int precioAlquilerAuto) {
		super();
		this.idAlquilerAuto = idAlquilerAuto;
		this.tipoAlquilerAuto = tipoAlquilerAuto;
		Empresa = empresa;
		this.precioAlquilerAuto = precioAlquilerAuto;
	}

	public int getIdAlquilerAuto() {
		return idAlquilerAuto;
	}

	public void setIdAlquilerAuto(int idAlquilerAuto) {
		this.idAlquilerAuto = idAlquilerAuto;
	}

	public String getTipoAlquilerAuto() {
		return tipoAlquilerAuto;
	}

	public void setTipoAlquilerAuto(String tipoAlquilerAuto) {
		this.tipoAlquilerAuto = tipoAlquilerAuto;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
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
		result = prime * result + ((Empresa == null) ? 0 : Empresa.hashCode());
		result = prime * result + idAlquilerAuto;
		result = prime * result + precioAlquilerAuto;
		result = prime * result + ((tipoAlquilerAuto == null) ? 0 : tipoAlquilerAuto.hashCode());
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
		if (Empresa == null) {
			if (other.Empresa != null)
				return false;
		} else if (!Empresa.equals(other.Empresa))
			return false;
		if (idAlquilerAuto != other.idAlquilerAuto)
			return false;
		if (precioAlquilerAuto != other.precioAlquilerAuto)
			return false;
		if (tipoAlquilerAuto == null) {
			if (other.tipoAlquilerAuto != null)
				return false;
		} else if (!tipoAlquilerAuto.equals(other.tipoAlquilerAuto))
			return false;
		return true;
	}
	
	
}
