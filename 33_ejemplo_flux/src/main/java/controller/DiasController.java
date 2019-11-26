package controller;

import java.time.Duration;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*")
@RestController
public class DiasController {

	@GetMapping(value = "/dias",produces = "text/event-stream") //tipo devolución de datos
	public Flux<String> dias(){
		return Flux
				.just("lunes","martes","miércoles","jueves","viernes","sábado","domingo")
				.delayElements(Duration.ofSeconds(3));
	}
	
}
