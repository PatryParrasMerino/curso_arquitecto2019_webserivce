package controller;

import java.time.Duration;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Accione;
import reactor.core.publisher.Flux;
import service.ServiceBolsa;

@CrossOrigin(origins = "*")
@RestController
public class BolsaController {

	@Autowired
	ServiceBolsa sBolsa;
	
	@GetMapping(value = "/bolsa", produces = "text/event-stream")
	public Flux<Accione> bolsa(){
		List<Accione> acciones=sBolsa.findAll();
		return Flux
				.fromIterable(acciones)
				.delayElements(Duration.ofSeconds(1));
	}
	
}
