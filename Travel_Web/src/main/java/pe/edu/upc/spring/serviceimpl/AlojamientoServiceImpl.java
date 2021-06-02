package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Alojamiento;
import pe.edu.upc.spring.repository.IAlojamientoRepository;
import pe.edu.upc.spring.service.IAlojamientoService;
@Service
public class AlojamientoServiceImpl implements IAlojamientoService{
	
	@Autowired
	private IAlojamientoRepository dAlojamiento;

	@Override
	@Transactional
	public boolean insertar(Alojamiento alojamiento) {
		Alojamiento objalo=dAlojamiento.save(alojamiento);
		if(objalo!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Alojamiento alojamiento) {
		boolean flag=false;
		try {
			dAlojamiento.save(alojamiento);
			flag=true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idAlojamiento) {
		dAlojamiento.deleteById(idAlojamiento);
		
	}

	@Override
	public Optional<Alojamiento> listarId(int idAlojamiento) {
		return dAlojamiento.findById(idAlojamiento);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Alojamiento> listar() {
		return dAlojamiento.findAll();
	}

	@Override
	@Transactional
	public List<Alojamiento> buscarHotel(String nombreHotel) {
		return dAlojamiento.buscarHotel(nombreHotel);
	}

	@Override
	@Transactional
	public List<Alojamiento> buscarRestaurante(String nombreRestaurante) {
		// TODO Auto-generated method stub
		return dAlojamiento.buscarRestaurante(nombreRestaurante);
	}
}
