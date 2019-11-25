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

@CrossOrigin(origins="*")
@RestController
public class VueloController {
	@Autowired
	ServiceVuelos serviceVuelos;
	
	@GetMapping(value="/disponibilidadVuelos/{plazas}",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Vuelo> listarVuelosDisponibles(@PathVariable("plazas") int plazas) {
		return serviceVuelos.getVuelosDisponibles(plazas);
	}
	
	@PutMapping(value="/actualizarPlazas/{idvuelo}/{plazas}")
	void actualizarPlazas(@PathVariable("idvuelo") int idVuelo,
						  @PathVariable("plazas") int plazas) {
		serviceVuelos.actualizarPlazas(idVuelo, plazas);
	}
}
