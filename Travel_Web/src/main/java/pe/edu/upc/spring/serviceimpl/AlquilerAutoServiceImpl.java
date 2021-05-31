package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.AlquilerAuto;
import pe.edu.upc.spring.repository.IAlquilerAutoRepository;
import pe.edu.upc.spring.service.IAlquilerAutoService;

@Service
public class AlquilerAutoServiceImpl implements IAlquilerAutoService{

	@Autowired
	private IAlquilerAutoRepository dAlquilerAuto;
	
	
	@Override
	@Transactional
	public boolean insertar(AlquilerAuto alquilerAuto) {
		AlquilerAuto objAlquilerAuto = dAlquilerAuto.save(alquilerAuto);
		if(objAlquilerAuto ==null)
			return false;
		else
		return true;
	}
	
	
	@Override
	@Transactional
	public boolean modificar(AlquilerAuto alquilerAuto) {
		boolean flag = false;
		try {
			dAlquilerAuto.save(alquilerAuto);
			flag = true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error al modificar");
		}
		return flag;
	}
	
	@Override
	@Transactional
	public void eliminar(int idAlquilerAuto) {
		dAlquilerAuto.deleteById(idAlquilerAuto);
		
	}
	
	
	@Override
	@Transactional(readOnly=true)
	public Optional<AlquilerAuto> listarId(int idAlquilerAuto) {
		return dAlquilerAuto.findById(idAlquilerAuto);
	}
	
	@Override
	@Transactional(readOnly=true)
	public List<AlquilerAuto> listar() {
		
		return dAlquilerAuto.findAll();
	}
}

