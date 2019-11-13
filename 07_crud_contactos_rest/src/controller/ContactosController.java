package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import daos.DaoContactos;
import model.Contacto;

@RestController
public class ContactosController {

	@Autowired
	DaoContactos daoContactos;
	//
	@GetMapping(value = "/contactos", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> contactos(){
		return daoContactos.recuperarContactos();
	}
	
	@GetMapping(value="/contactos/{email}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto contacto(@PathVariable("email") String email) {
		return daoContactos.recuperarContactoPorEmail(email);
	}
	
	@DeleteMapping(value="/contactos/{id}")
	public void eliminar(@PathVariable("id") int idContacto) {
		daoContactos.eliminarContacto(idContacto);
	}
	//
	@PostMapping(value = "/contactos",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void alta(@RequestBody Contacto contacto) {
		daoContactos.altaContacto(contacto);
	}
	
	@PutMapping(value="/contactos",consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizar(@RequestBody Contacto contacto) {
		daoContactos.altaContacto(contacto);
	}
	@GetMapping(value="/contactos/actualiza")
	public void actualizar(@RequestParam("idContacto") int idContacto, 
							@RequestParam("email") String email) {
		
	}
}
