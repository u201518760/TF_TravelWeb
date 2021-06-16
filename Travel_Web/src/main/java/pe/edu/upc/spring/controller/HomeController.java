package pe.edu.upc.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {
	@RequestMapping("/login")
	public String irPaginaLogin() {
		return "login";
	}
	@RequestMapping("/inicio")
	public String irPaginaInicio() {
		return "bienvenido3";
	}
	


}
