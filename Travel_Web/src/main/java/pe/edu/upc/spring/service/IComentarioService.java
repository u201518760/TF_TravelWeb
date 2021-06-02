package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Comentario;

public interface IComentarioService {

	public boolean insertar(Comentario comentario);
	public boolean modificar(Comentario comentario);
	public void eliminar(int idComentario);
	public Optional<Comentario> listarId(int Comentario);
	public List<Comentario> listar();
	
}
