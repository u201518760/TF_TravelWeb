package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.ReservaViaje;
import pe.edu.upc.spring.repository.IReservaViajeRepository;
import pe.edu.upc.spring.service.IReservaViajeService;

@Service
public class ReservaViajeServiceImpl implements IReservaViajeService{
	@Autowired
	private IReservaViajeRepository dReserva;

	@Override
	@Transactional
	public boolean insertar(ReservaViaje reservaViaje) {
		ReservaViaje objreserva=dReserva.save(reservaViaje);
		if(objreserva!=null) return true;
		return false;
	
	}

	@Override
	@Transactional
	public boolean modificar(ReservaViaje reservaViaje) {
		boolean flag=false;
		try {
			dReserva.save(reservaViaje);
			flag=true;
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idReservaViaje) {
		// TODO Auto-generated method stub
		dReserva.deleteById(idReservaViaje);
	}

	@Override
	public Optional<ReservaViaje> buscarId(int idReservaViaje) {
		// TODO Auto-generated method stub
		return dReserva.findById(idReservaViaje);
	}

	@Override
	public Optional<ReservaViaje> listarId(int idReservaViaje) {
		// TODO Auto-generated method stub
		return dReserva.findById(idReservaViaje);
	}

	@SuppressWarnings("deprecation")
	@Override
	@Transactional(readOnly=true)
	public List<ReservaViaje> listar() {
		List<ReservaViaje> lista=dReserva.listaDatos();
		for(ReservaViaje r:lista) {
			r.setDiasReserva(r.getFechaFin().getDate()-r.getFechaInicio().getDate());
		}
		return lista;
	}

}
