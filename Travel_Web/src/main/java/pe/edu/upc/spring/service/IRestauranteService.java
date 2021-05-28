package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Restaurante;

public interface IRestauranteService {
	public boolean insertar(Restaurante restaurante);
	public boolean modificar(Restaurante restaurante);
	public void eliminar(int idRestaurante);
	public Optional<Restaurante> listarId(int idRestaurante);
	List<Restaurante> listar();

}
