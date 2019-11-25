package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoVuelos;
import model.Vuelo;

@Service
public class ServiceVuelosImpl implements ServiceVuelos {
	@Autowired
	DaoVuelos daoVuelos;
	
	@Override
	public List<Vuelo> getVuelos() {
		return daoVuelos.findAll();
	}
	
	@Override
	public List<Vuelo> getVuelosDisponibles(int plazas) {
		List<Vuelo> vuelos = daoVuelos.findAll();
		List<Vuelo> vuelosDisponibles = new ArrayList<Vuelo>();
		for (Vuelo vuelo : vuelos) {
			if (vuelo.getPlazas()>=plazas) {
				vuelosDisponibles.add(vuelo);
			}
		}
		return vuelosDisponibles;
	}

	@Override
	public void actualizarPlazas(int idVuelo, int plazas) {
		Vuelo vuelo = daoVuelos.getOne(idVuelo);
		if (vuelo != null) {
			vuelo.setPlazas(vuelo.getPlazas()-plazas);
			daoVuelos.save(vuelo);
		}
	}
}
