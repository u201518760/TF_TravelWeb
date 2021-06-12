package pe.edu.upc.spring.controller;

import java.text.ParseException;
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

import pe.edu.upc.spring.model.Alojamiento;
import pe.edu.upc.spring.model.Hotel;
import pe.edu.upc.spring.model.Provincia;
import pe.edu.upc.spring.model.Restaurante;
import pe.edu.upc.spring.service.IAlojamientoService;
import pe.edu.upc.spring.service.IHotelService;
import pe.edu.upc.spring.service.IProvinciaService;
import pe.edu.upc.spring.service.IRestauranteService;

@Controller
@RequestMapping("/alojamiento")
public class AlojamientoController {
	@Autowired
	private IAlojamientoService aService;
	@Autowired
	private IProvinciaService pService;
	@Autowired
	private IHotelService hService;
	@Autowired
	private IRestauranteService rService;
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	@RequestMapping("/")
	public String irPaginaListadoAlojamientos(Map<String,Object> model) {
		model.put("listaAlojamientos", aService.listar());
		return "listAlojamiento";
	}
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroAlojamientos(Model model) {
		model.addAttribute("listaProvincias", pService.listar());
		model.addAttribute("listaRestaurantes", rService.listar());
		model.addAttribute("listaHoteles", hService.listar());
		
		model.addAttribute("provincia", new Provincia());
		model.addAttribute("alojamiento", new Alojamiento());
		model.addAttribute("restaurante", new Restaurante());
		model.addAttribute("hotel", new Hotel());
		return "alojamiento";
	}
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Alojamiento objAlojamiento,BindingResult binRes, Model model,RedirectAttributes objRedir) throws ParseException{
		if(binRes.hasErrors()) {
			model.addAttribute("listaRestaurantes", rService.listar());
			model.addAttribute("listaHoteles", hService.listar());
			model.addAttribute("listaProvincias", pService.listar());
			return "alojamiento";
		}
		else
		{
			boolean flag=aService.insertar(objAlojamiento);
			if(flag) {
				objRedir.addFlashAttribute("exito", "Se guardo correctamente");
			
				return "redirect:/alojamiento/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/alojamiento/irRegistrar";
			}
		}
	}
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id,Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<Alojamiento> objAlojamiento=aService.listarId(id);
		if(objAlojamiento==null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/alojamiento/listar";
			
		}
		else {
			model.addAttribute("listaRestaurantes", rService.listar());
			model.addAttribute("listaHoteles", hService.listar());
			model.addAttribute("listaProvincias", pService.listar());
			if(objAlojamiento.isPresent())
				objAlojamiento.ifPresent(o->model.addAttribute("alojamiento", o));
			return "alojamiento";
		}
	}
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object> model,@RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				aService.eliminar(id);
				model.put("listaAlojamientos", aService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaAlojamientos", aService.listar());
		}
		return "listAlojamiento";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaAlojamientos", aService.listar());
		return "listAlojamiento";
	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model,@ModelAttribute Alojamiento alojamiento)  throws ParseException{
		aService.listarId(alojamiento.getIdAlojamiento());
		return "listAlojamiento";
	}
	
}
