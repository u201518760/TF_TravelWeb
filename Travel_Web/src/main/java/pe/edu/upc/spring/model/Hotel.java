package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Table(name="hotel")
public class Hotel implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idHotel;
	
	@Column(name="nombreHotel", nullable=false, length=20)
	private String nombreHotel;
	
	@Column(name="categoria",nullable=false,length=30)
	private String categoria;
	
	@Column(name="precioHotel",nullable=false)
	private int precioHotel;

	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Hotel(int idHotel, String nombreHotel, String categoria, int precioHotel) {
		super();
		this.idHotel = idHotel;
		this.nombreHotel = nombreHotel;
		this.categoria = categoria;
		this.precioHotel = precioHotel;
	}



	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombreHotel() {
		return nombreHotel;
	}

	public void setNombreHotel(String nombreHotel) {
		this.nombreHotel = nombreHotel;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public int getPrecioHotel() {
		return precioHotel;
	}



	public void setPrecioHotel(int precioHotel) {
		this.precioHotel = precioHotel;
	}



	
	
	
	
}
