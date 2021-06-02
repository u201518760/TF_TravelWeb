package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.Alojamiento;

@Repository
public interface IAlojamientoRepository extends JpaRepository<Alojamiento, Integer>{
	
	@Query("from Alojamiento a where a.hotel.nombreHotel like %:nombreHotel%")
	List<Alojamiento> buscarHotel(@Param("nombreHotel") String nombreHotel);
	
	@Query("from Alojamiento a where a.restaurante.nombreRestaurante like %:nombreRestaurante%")
	List<Alojamiento> buscarRestaurante(@Param("nombreRestaurante") String nombreRestaurante);
	

}
