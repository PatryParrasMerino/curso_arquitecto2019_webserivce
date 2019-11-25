package service;

import java.util.List;

import model.Reserva;

public interface ServiceReservas {
	void reservar(Reserva reserva);
	List<Reserva> listar();
}
