package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Reserva;
import service.ServiceReservas;

@CrossOrigin(origins="*")
@RestController
public class ReservaController {
	@Autowired
	ServiceReservas serviceReservas;
	@Autowired
	RestTemplate template;
	
	@Value("${url.servicio.vuelos}")
	String url;
	
	@PostMapping(value="/reservar", consumes = MediaType.APPLICATION_JSON_VALUE)
	void reservar(@RequestBody Reserva reserva) {
		serviceReservas.reservar(reserva);
		template.put(url+"/"+reserva.getVuelo()+"/"+reserva.getPlazas(), null);
	}
	
	@GetMapping(value="/lista",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> listarReservas() {
		return serviceReservas.listar();
	}
}
