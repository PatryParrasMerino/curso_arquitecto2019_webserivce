package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.DaoBolsa;
import model.Accione;
import reactor.core.publisher.Flux;

@CrossOrigin(origins = "*")
@RestController
public class BolsaController {

	@Autowired
	DaoBolsa daoBolsa;
	
	@CrossOrigin(origins="*")
	@GetMapping(value = "/bolsa", produces = "text/event-stream")
	public Flux<Accione> bolsa(){
		List<Accione> acciones=daoBolsa.findAll();
		acciones.add(new Accione(0, "EOF", 0));
		return Flux.fromIterable(acciones);
	}
	
	@CrossOrigin(origins="*")
	@GetMapping(value="/continuo",produces="text/event-stream")
	public Flux<List<Accione>> getAcciones(){
		return Flux.create(fs->{
			List<Accione> anterior=null;
			while(true) {
				List<Accione> lista=daoBolsa.findAll();
				if(cambio(anterior,lista)) {
					fs.next(lista);
				}
				anterior=lista;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	private boolean cambio(List<Accione> anterior,List<Accione> actual ) {
		
		if(anterior==null) {
			return true;
		}else {
			for(int i=0;i<actual.size();i++) {
				if(anterior.get(i).getValor()!=actual.get(i).getValor()){
					return true;
				}
			}
		}
		return false;
	}
	
}
