package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.ReservaViaje;

public interface IReservaViajeService {
	public boolean insertar(ReservaViaje reservaViaje);
	public boolean modificar(ReservaViaje reservaViaje);
	public void eliminar(int idReservaViaje);
	public Optional<ReservaViaje> buscarId(int idReservaViaje);
	public Optional<ReservaViaje> listarId(int idReservaViaje);
	public List<ReservaViaje> listar();

}
