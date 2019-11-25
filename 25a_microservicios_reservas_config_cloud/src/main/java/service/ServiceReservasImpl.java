package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoReservas;
import model.Reserva;

@Service
public class ServiceReservasImpl implements ServiceReservas {
	@Autowired
	DaoReservas daoReservas;
	
	@Override
	public void reservar(Reserva reserva) {
		daoReservas.save(reserva);
	}

	@Override
	public List<Reserva> listar() {
		return daoReservas.findAll();
	}
}
