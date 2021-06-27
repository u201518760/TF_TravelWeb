package pe.edu.upc.spring.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="Comentario")
public class Comentario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idComentario;
	
	@Column(name="Comentario", nullable=false, length=300)
	private String Comentario;

	public Comentario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Comentario(int idComentario, String comentario) {
		super();
		this.idComentario = idComentario;
		Comentario = comentario;
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

	
	
	


	
	
	
}
