package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Restaurante;
import pe.edu.upc.spring.repository.IRestauranteRepository;
import pe.edu.upc.spring.service.IRestauranteService;

@Service
public class RestauranteServiceImpl implements IRestauranteService{
	@Autowired//Igual a Inject
	private IRestauranteRepository dRestaurante;

	@Override
	@Transactional
	public boolean insertar(Restaurante restaurante) {
		Restaurante objRestaurante=dRestaurante.save(restaurante);
		if(objRestaurante==null)
			return false;
		else
			return true;
	}

	@Override
	@Transactional
	public boolean modificar(Restaurante restaurante) {
		boolean flag=false;
		try {
			dRestaurante.save(restaurante);
			flag=true;
		}
		catch(Exception ex) {
			System.out.println("Sucedio un error");
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idRestaurante) {
		dRestaurante.deleteById(idRestaurante);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Optional<Restaurante> listarId(int idRestaurante) {
		// TODO Auto-generated method stub
		return dRestaurante.findById(idRestaurante);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Restaurante> listar() {
		// TODO Auto-generated method stub
		return dRestaurante.findAll();
	}


}
