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
import pe.edu.upc.spring.model.AlquilerAuto;
import pe.edu.upc.spring.model.ReservaViaje;
import pe.edu.upc.spring.model.Transporte;
import pe.edu.upc.spring.model.Turista;
import pe.edu.upc.spring.service.IAlojamientoService;
import pe.edu.upc.spring.service.IAlquilerAutoService;
import pe.edu.upc.spring.service.IReservaViajeService;
import pe.edu.upc.spring.service.ITransporteService;
import pe.edu.upc.spring.service.ITuristaService;

@Controller
@RequestMapping("/reservaviaje")
public class ReservaViajeController {
	@Autowired
	private ITuristaService tuService;
	@Autowired
	private IReservaViajeService rvService;
	@Autowired
	private IAlojamientoService aService;
	@Autowired
	private ITransporteService trService;
	@Autowired
	private IAlquilerAutoService auService;
	@RequestMapping("/bienvenido")
	public String irPaginaBienvenida() {
		return "bienvenido";
	}
	@RequestMapping("/")
	public String irPaginaListadoReservas(Map<String,Object> model) {
		model.put("listaReservaViajes", rvService.listar());
		return "listReservaViaje";
	}
	@RequestMapping("/irRegistrar")
	public String irPaginaRegistroReservaViaje(Model model) {
		model.addAttribute("listaTuristas", tuService.listar());
		model.addAttribute("listaAlojamientos", aService.listar());
		model.addAttribute("listaTransportes", trService.listar());
		model.addAttribute("listaAlquilerAutos", auService.listar());
		
		model.addAttribute("turista", new Turista());
		model.addAttribute("alojamiento", new Alojamiento());
		model.addAttribute("transporte", new Transporte());
		model.addAttribute("alquilerAuto", new AlquilerAuto());
		model.addAttribute("reservaviaje", new ReservaViaje());
		return "reservaviaje";
	}
	@RequestMapping("/registrar")
	public String registrar(@ModelAttribute ReservaViaje objReservaViaje,BindingResult binRes, Model model) throws ParseException{
		if(binRes.hasErrors()) {
			model.addAttribute("listaTuristas", tuService.listar());
			model.addAttribute("listaAlojamientos", aService.listar());
			model.addAttribute("listaTransportes", trService.listar());
			model.addAttribute("listaAlquilerAutos", auService.listar());
			return "reservaviaje";
		}
		else
		{
			boolean flag=rvService.insertar(objReservaViaje);
			if(flag)
				return "redirect:/reservaviaje/listar";
			else {
				model.addAttribute("mensaje", "Ocurrio un error");
				return "redirect:/reservaviaje/irRegistrar";
			}
		}
	}
	@RequestMapping("/modificar/{id}")
	public String modificar(@PathVariable int id,Model model, RedirectAttributes objRedir) throws ParseException{
		Optional<ReservaViaje> objRV=rvService.buscarId(id);
		if(objRV==null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/reservaviaje/listar";
			
		}
		else {
			model.addAttribute("listaTuristas", tuService.listar());
			model.addAttribute("listaAlojamientos", aService.listar());
			model.addAttribute("listaTransportes", trService.listar());
			model.addAttribute("listaAlquilerAutos", auService.listar());
			if(objRV.isPresent())
				objRV.ifPresent(o->model.addAttribute("reservaviaje", o));
			return "reservaviaje";
		}
	}
	@RequestMapping("/eliminar")
	public String eliminar(Map<String,Object> model,@RequestParam(value="id") Integer id) {
		try {
			if(id!=null && id>0) {
				rvService.eliminar(id);
				model.put("listaReservaViajes", rvService.listar());
			}
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
			model.put("mensaje", "Ocurrio un error");
			model.put("listaReservaViajes", rvService.listar());
		}
		return "listReservaViaje";
	}
	
	@RequestMapping("/listar")
	public String listar(Map<String, Object> model) {
		model.put("listaReservaViajes", rvService.listar());
		return "listReservaViaje";
	}
	@RequestMapping("/listarId")
	public String listarId(Map<String, Object> model,@ModelAttribute ReservaViaje reservaViaje)  throws ParseException{
		rvService.listarId(reservaViaje.getIdReservaViaje());
		return "listReservaViaje";
	}

}
