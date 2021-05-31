package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Turista;
import pe.edu.upc.spring.repository.ITuristaRepository;
import pe.edu.upc.spring.service.ITuristaService;

@Service
public class TuristaServiceImpl implements ITuristaService{

	@Autowired
	private ITuristaRepository dTurista;
	
	
	@Override
	@Transactional
	public boolean insertar(Turista alquilerAuto) {
		Turista objTurista = dTurista.save(alquilerAuto);
		if(objTurista ==null)
			return false;
		else
		return true;
	}
	
	
	@Override
	@Transactional
	public boolean modificar(Turista alquilerAuto) {
		boolean flag = false;
		try {
			dTurista.save(alquilerAuto);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idTurista) {
		dTurista.deleteById(idTurista);
		
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Optional<Turista> listarId(int idTurista) {
		return dTurista.findById(idTurista);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<Turista> listar() {
		
		return dTurista.findAll();
	}
}

