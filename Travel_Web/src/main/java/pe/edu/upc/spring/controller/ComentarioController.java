package pe.edu.upc.spring.controller;

import java.util.Map;
import java.util.Optional;
import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.spring.model.Comentario;
import pe.edu.upc.spring.model.Turista;

import pe.edu.upc.spring.service.ITuristaService;
import pe.edu.upc.spring.service.IComentarioService;


@Controller
@RequestMapping("/comentario")
public class ComentarioController {
	
	@Autowired
	private ITuristaService tService;
	
	@Autowired
	private IComentarioService cService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";

	}
	
	
	@RequestMapping("/")
	public String irPaginaListadoComentarios(Map<String, Object> model) {
		model.put("listaProvincias", cService.listar());
		return "listProvincia";

	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroComentarios(Model model) {
		
		model.addAttribute("listaTuristas", tService.listar());
		
		model.addAttribute("comentario", new Comentario());
		model.addAttribute("turista", new Turista());
		
		return "comentario";
		
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Comentario objComentario, BindingResult binRes, Model model) 
			throws ParseException 

	{
		if (binRes.hasErrors())
		{
			model.addAttribute("listaTuristas", tService.listar());
			return "comentario";
		}
		else {
			boolean flag = cService.insertar(objComentario);
			if (flag) 
				return "redirect:/comentario/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/comentario/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Comentario> objComentario = cService.listarId(id);
		if (objComentario == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/comentario/listar";
		}
		else {
			model.addAttribute("listaTuristas", tService.listar());
			
			if(objComentario.isPresent())
				objComentario.ifPresent(o -> model.addAttribute("comentario",o));
			
			return "comentario";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				cService.eliminar(id);
				model.put("listaComentarios", cService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaComentarios", cService.listar());
		}
		return "listComentario";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaComentarios", cService.listar());
		return "listComentario";
	}
	
	
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object>model, @ModelAttribute Comentario comentario)
	throws ParseException
	{
		cService.listarId(comentario.getIdComentario());
		return"listComentario";
	}
	
}
