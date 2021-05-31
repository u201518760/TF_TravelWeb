package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="transporte")
public class Transporte implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idTransporte;
	
	@Column(name="tipoTransporte",nullable=false,length=20)
	private String tipoTransporte;
	
	@Column(name="nombreEmpresa", nullable=false, length=30)
	private String Empresa;
	
	@Column(name="precioTransporte", nullable=false)
	private int precioTransporte;
	
	public Transporte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transporte(int idTransporte, String tipoTransporte, String empresa, int precioTransporte) {
		super();
		this.idTransporte = idTransporte;
		this.tipoTransporte = tipoTransporte;
		Empresa = empresa;
		this.precioTransporte = precioTransporte;
	}

	public int getIdTransporte() {
		return idTransporte;
	}

	public void setIdTransporte(int idTransporte) {
		this.idTransporte = idTransporte;
	}

	public String getTipoTransporte() {
		return tipoTransporte;
	}

	public void setTipoTransporte(String tipoTransporte) {
		this.tipoTransporte = tipoTransporte;
	}

	public String getEmpresa() {
		return Empresa;
	}

	public void setEmpresa(String empresa) {
		Empresa = empresa;
	}

	public int getPrecioTransporte() {
		return precioTransporte;
	}

	public void setPrecioTransporte(int precioTransporte) {
		this.precioTransporte = precioTransporte;
	}

	
	
	
}
