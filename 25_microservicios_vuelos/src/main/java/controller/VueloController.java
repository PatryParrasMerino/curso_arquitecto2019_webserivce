package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Vuelo;
import service.ServiceVuelos;

@CrossOrigin(origins = "*")
@RestController
public class VueloController {

	@Autowired
	ServiceVuelos sVuelos;	
	
	@GetMapping(value = "/disponibilidadvuelos/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> disponibilidadVuelos(@PathVariable("plazas") int plazas){
		return sVuelos.getVuelosDisponibles(plazas);
	}
	
	@PutMapping("/actualizarplazas/{idVuelo}/{plazas}")
	public void actualizarPlazas(@PathVariable("plazas") int plazas,
								 @PathVariable("idVuelo") int idVuelo) {
		sVuelos.actualizarPlazas(idVuelo, plazas);
	}
}
