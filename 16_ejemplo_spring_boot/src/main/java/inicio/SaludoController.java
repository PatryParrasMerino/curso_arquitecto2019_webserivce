package inicio;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
	
	@GetMapping(value = "/saludo", produces = MediaType.TEXT_PLAIN_VALUE) //Para probar correr en application(run->spring boot app) y 
	public String saludar() {											  //poner esto en navegador http://localhost:8080/saludo			
		return "Bienvenido a Spring Boot";
	}
}
