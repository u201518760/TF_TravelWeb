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

import pe.edu.upc.spring.model.AlquilerAuto;
import pe.edu.upc.spring.service.IAlquilerAutoService;



@Controller
@RequestMapping("/alquilerAuto")
public class AlquilerAutoController {

	@Autowired
	private IAlquilerAutoService tService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";

	}
	
	@RequestMapping("/")
	public String irPaginaListadoAlquilerAutos(Map<String, Object> model) {
		model.put("listaAlquilerAutos", tService.listar());
		return "listAlquilerAuto";

	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("alquilerAuto", new AlquilerAuto());
		return "alquilerAuto";
		
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute AlquilerAuto objAlquilerAuto, BindingResult binRes, Model model,RedirectAttributes objRedir) 
			throws ParseException 
	{
		if (binRes.hasErrors())
			return "alquilerAuto";
		else {
			if(objAlquilerAuto.getModeloAlquilerAuto().length()==0) {
				model.addAttribute("mensaje","Complete todos los campos");
				
				return "alquilerAuto";
			}
			boolean flag = tService.insertar(objAlquilerAuto);
			if (flag) 
			{
				objRedir.addFlashAttribute("exito", "Se guardo correctamente");
				return "redirect:/alquilerAuto/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/alquilerAuto/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<AlquilerAuto> objAlquilerAuto = tService.listarId(id);
		if (objAlquilerAuto == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/alquilerAuto/listar";
		}
		else {
			model.addAttribute("alquilerAuto", objAlquilerAuto);
			return "alquilerAuto";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				tService.eliminar(id);
				model.put("listaAlquilerAutos", tService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaAlquilerAutos", tService.listar());
		}
		return "listAlquilerAuto";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaAlquilerAutos", tService.listar());
		return "listAlquilerAuto";
	}
	
	
}


