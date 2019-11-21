package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.Reserva;
import service.ServiceReservas;

@CrossOrigin(origins = "*")
@RestController
public class ReservaController {

	@Autowired
	ServiceReservas sReservas;	
	
	@Value("${client.url.inventada}")
	String url;
	
	@Autowired
	RestTemplate template;
	
	@PostMapping(value = "/reservar/{idVuelo}/{idHotel}/{dni}/{nombre}/{plazas}")
	void reservar(@PathVariable("idVuelo") int idVuelo,
				  @PathVariable("idHotel") int idHotel,
				  @PathVariable("dni") String dni,
				  @PathVariable("nombre") String nombre,
				  @PathVariable("plazas") int plazas) {
		Reserva reserva= new Reserva();
		reserva.setVuelo(idVuelo);
		reserva.setHotel(idHotel);
		reserva.setDni(dni);
		reserva.setNombre(nombre);
		sReservas.reservar(reserva);
	}
}
