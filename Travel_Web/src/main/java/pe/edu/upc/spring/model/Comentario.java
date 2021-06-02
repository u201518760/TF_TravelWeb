package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="Comentario")
public class Comentario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComentario;
	
	@Column(name="Comentario", nullable=false, length=30)
	private String Comentario;
	
	@ManyToOne
	@JoinColumn(name="idTurista",nullable=false)
	private Turista turista;

	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comentario(int idComentario, String comentario, Turista turista) {
		super();
		this.idComentario = idComentario;
		Comentario = comentario;
		this.turista = turista;
	}

	public int getIdComentario() {
		return idComentario;
	}

	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	public String getComentario() {
		return Comentario;
	}

	public void setComentario(String comentario) {
		Comentario = comentario;
	}

	public Turista getTurista() {
		return turista;
	}

	public void setTurista(Turista turista) {
		this.turista = turista;
	}



	
	
	
}
