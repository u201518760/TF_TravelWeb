package pe.edu.upc.spring.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.spring.model.Alojamiento;

public interface IAlojamientoService {
	public boolean insertar(Alojamiento alojamiento);
	public boolean modificar(Alojamiento alojamiento);
	public void eliminar(int idAlojamiento);
	public Optional<Alojamiento> listarId(int idAlojamiento);
	public List<Alojamiento> listar();
	public List<Alojamiento> buscarHotel(String nombreHotel);
	public List<Alojamiento> buscarRestaurante(String nombreRestaurante);

}
