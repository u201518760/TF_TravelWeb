package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.sun.el.parser.ParseException;

import pe.edu.upc.spring.model.Departamento;
import pe.edu.upc.spring.service.IDepartamentoService;



@Controller
@RequestMapping("/departamento")
public class DepartamentoController {

	@Autowired
	private IDepartamentoService dService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";

	}
	
	@RequestMapping("/")
	public String irPaginaListadoDepartamentos(Map<String, Object> model) {
		model.put("listaDepartamentos", dService.listar());
		return "listDepartamento";

	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("departamento", new Departamento());
		return "departamento";
		
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Departamento objDepartamento, BindingResult binRes, Model model, 
			RedirectAttributes objRedir) 
			throws ParseException 
	{
		if (binRes.hasErrors())
			return "departamento";
		else {
			if(objDepartamento.getNombreDepartamento().length()==0) {
				model.addAttribute("mensaje","Complete el campo");
				
				return "departamento";
			}
			boolean flag = dService.insertar(objDepartamento);
			if (flag) {
				objRedir.addFlashAttribute("exito", "Se guardo correctamente");
				return "redirect:/departamento/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/departamento/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Departamento> objDepartamento = dService.listarId(id);
		if (objDepartamento == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/departamento/listar";
		}
		else {
			model.addAttribute("departamento", objDepartamento);
			return "departamento";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id, RedirectAttributes objRedir) {
		try {
			if(id!=null && id>0) {
				dService.eliminar(id);
				model.put("listaDepartamentos", dService.listar());
				objRedir.addFlashAttribute("eliminar", "Se elimino correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaDepartamentos", dService.listar());
		}
		return "listDepartamento";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaDepartamentos", dService.listar());
		return "listDepartamento";
	}
	
	
}


