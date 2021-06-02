package pe.edu.upc.spring.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.spring.model.Comentario;
import pe.edu.upc.spring.repository.IComentarioRepository;
import pe.edu.upc.spring.service.IComentarioService;

@Service
public class ComentarioServiceImpl implements IComentarioService {
	
	@Autowired
	private IComentarioRepository cComentario;
	
	@Override
	@Transactional
	public boolean insertar(Comentario comentario) {
		Comentario objComentario = cComentario.save(comentario);
		if(objComentario!=null) return true;
		return false;
	}

	@Override
	@Transactional
	public boolean modificar(Comentario comentario) {
		boolean flag=false;
		try {
			cComentario.save(comentario);
			flag =true;
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return flag;
	}

	@Override
	@Transactional
	public void eliminar(int idComentario) {
		cComentario.deleteById(idComentario);
		
	}
	
	
	@Override
	public Optional<Comentario> listarId(int idComentario) {
		return cComentario.findById(idComentario);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comentario> listar() {
		return cComentario.findAll();
	}
	
	
}
