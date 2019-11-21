package service;

import java.util.List;

import model.Vuelo;


public interface ServiceVuelos {

	public List<Vuelo> getVuelos();
	public List<Vuelo> getVuelosDisponibles(int plazas);
	public void actualizarPlazas(int idVuelo, int plazas);
}
