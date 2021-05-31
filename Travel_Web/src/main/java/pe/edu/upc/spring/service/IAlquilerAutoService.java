package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.AlquilerAuto;



public interface IAlquilerAutoService {

	public boolean insertar(AlquilerAuto alquilerAuto);
	public boolean modificar(AlquilerAuto alquilerAuto);
	public void eliminar (int idAlquilerAuto);
	public 	Optional<AlquilerAuto> listarId(int idAlquilerAuto);
	List<AlquilerAuto> listar();
}
