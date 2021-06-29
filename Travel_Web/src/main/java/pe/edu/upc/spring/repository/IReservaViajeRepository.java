package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.spring.model.ReservaViaje;

@Repository
public interface IReservaViajeRepository extends JpaRepository<ReservaViaje, Integer>{
	@Query("Select r from ReservaViaje r")
	List<ReservaViaje> listaDatos();
}
