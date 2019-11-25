package service;

import java.util.List;

import model.Vuelo;

public interface ServiceVuelos {
	List<Vuelo> getVuelos();
	List<Vuelo> getVuelosDisponibles(int plazas);
	void actualizarPlazas(int idVuelo, int plazas);
}
