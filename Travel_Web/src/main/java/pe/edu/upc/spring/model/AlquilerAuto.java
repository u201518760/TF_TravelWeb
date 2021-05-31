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
	
	
	
}

