package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Turista;



public interface ITuristaService {

	public boolean insertar(Turista turista);
	public boolean modificar(Turista turista);
	public void eliminar (int idTurista);
	public 	Optional<Turista> listarId(int idTurista);
	List<Turista> listar();
}
