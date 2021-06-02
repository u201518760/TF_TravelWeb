package pe.edu.upc.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="reservaviaje")
public class ReservaViaje implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idReservaViaje;
	
	@ManyToOne
	@JoinColumn(name="idTurista",nullable=false)
	private Turista idTurista ; 
	@ManyToOne
	@JoinColumn(name="idAdministrador",nullable=false)
	private Turista idAdministrador ; 
	@ManyToOne
	@JoinColumn(name="idTransporte",nullable=false)
	private Transporte transporte; 
	
	@ManyToOne
	@JoinColumn(name="idAlojamiento",nullable=false)
	private Alojamiento alojamiento;
	
	@ManyToOne
	@JoinColumn(name="idAlquilerAuto",nullable=false)
	private AlquilerAuto auto;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaInicio")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fechaFin")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date fechaFin;
	
	@Transient
	@Column(name="precio", nullable = false)
	private int precioReserva;

	public ReservaViaje() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservaViaje(int idReservaViaje, Turista idTurista, Turista idAdministrador, Transporte transporte,
			Alojamiento alojamiento, AlquilerAuto auto, Date fechaInicio, Date fechaFin, int precioReserva) {
		super();
		this.idReservaViaje = idReservaViaje;
		this.idTurista = idTurista;
		this.idAdministrador = idAdministrador;
		this.transporte = transporte;
		this.alojamiento = alojamiento;
		this.auto = auto;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.precioReserva = precioReserva;
	}

	public int getIdReservaViaje() {
		return idReservaViaje;
	}

	public void setIdReservaViaje(int idReservaViaje) {
		this.idReservaViaje = idReservaViaje;
	}

	public Turista getIdTurista() {
		return idTurista;
	}

	public void setIdTurista(Turista idTurista) {
		this.idTurista = idTurista;
	}

	public Turista getIdAdministrador() {
		return idAdministrador;
	}

	public void setIdAdministrador(Turista idAdministrador) {
		this.idAdministrador = idAdministrador;
	}

	public Transporte getTransporte() {
		return transporte;
	}

	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}

	public Alojamiento getAlojamiento() {
		return alojamiento;
	}

	public void setAlojamiento(Alojamiento alojamiento) {
		this.alojamiento = alojamiento;
	}

	public AlquilerAuto getAuto() {
		return auto;
	}

	public void setAuto(AlquilerAuto auto) {
		this.auto = auto;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public int getPrecioReserva() {
		return precioReserva;
	}

	public void setPrecioReserva(int precioReserva) {
		this.precioReserva = precioReserva;
	}
	

}
