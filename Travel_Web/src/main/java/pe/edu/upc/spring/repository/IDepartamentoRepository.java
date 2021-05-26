package pe.edu.upc.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.spring.model.Departamento;


@Repository
public interface IDepartamentoRepository extends JpaRepository <Departamento, Integer> {

	@Query("from Departamento d where d.nombreDepartamento like %:nombreDepartamento%")
	List<Departamento> buscarNombre(@Param("nombreDepartamento") String nombreDepartamento);
}
