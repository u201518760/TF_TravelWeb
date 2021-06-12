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

import pe.edu.upc.spring.model.Hotel;
import pe.edu.upc.spring.service.IHotelService;



@Controller
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private IHotelService hService;
	
	
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";

	}
	
	@RequestMapping("/")
	public String irPaginaListadoHoteles(Map<String, Object> model) {
		model.put("listaHoteles", hService.listar());
		return "listHotel";

	}
	
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistrar(Model model) {
		model.addAttribute("hotel", new Hotel());
		return "hotel";
		
	}
	
	
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute Hotel objHotel, BindingResult binRes, Model model,RedirectAttributes objRedir) 
			throws ParseException 
	{
		if (binRes.hasErrors())
			return "hotel";
		else {
			if(objHotel.getNombreHotel().length()==0 ||objHotel.getDireccion().length()==0||objHotel.getCategoria().length()==0 ){
				model.addAttribute("mensaje", "Complete todos los campos");
				return "hotel";
			}
			boolean flag = hService.insertar(objHotel);
			if (flag) {
				objRedir.addFlashAttribute("exito", "Se guardo correctamente");
				return "redirect:/hotel/listar";
			}
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/hotel/irRegistrar";
			}
		}
	}
	
	
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model, RedirectAttributes objRedir) 
			throws ParseException 
	{
		Optional<Hotel> objHotel = hService.listarId(id);
		if (objHotel == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/hotel/listar";
		}
		else {
			model.addAttribute("hotel", objHotel);
			return "hotel";
		}
	}
	
	
	@RequestMapping("/eliminar")
	public String eliminar(Map<String, Object> model, @RequestParam(value="id") Integer id,RedirectAttributes objRedir) {
		try {
			if(id!=null && id>0) {
				hService.eliminar(id);
				model.put("listaHoteles", hService.listar());
				objRedir.addFlashAttribute("eliminar", "Se elimino correctamente");
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaHoteles", hService.listar());
		}
		return "listHotel";
	}
	
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object>model) {
		model.put("listaHoteles", hService.listar());
		return "listHotel";
	}
	
	
}



