package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restaurante")
public class Restaurante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idRestaurante;
	
	@Column(name="nameRestaurante",nullable=false,length=20)
	private String nombreRestaurante;
	
	@Column(name="direccionRestaurante",nullable=false,length=30)
	private String direccion;
	
	@Column(name="telefonoRestaurante",nullable=false, length=9)
	private int telefono;

	public Restaurante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Restaurante(int idRestaurante, String nombreRestaurante, String direccion, int telefono) {
		super();
		this.idRestaurante = idRestaurante;
		this.nombreRestaurante = nombreRestaurante;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public int getIdRestaurante() {
		return idRestaurante;
	}

	public void setIdRestaurante(int idRestaurante) {
		this.idRestaurante = idRestaurante;
	}

	public String getNombreRestaurante() {
		return nombreRestaurante;
	}

	public void setNombreRestaurante(String nombreRestaurante) {
		this.nombreRestaurante = nombreRestaurante;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	
	

	

}
