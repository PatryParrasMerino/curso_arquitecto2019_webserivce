package service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoHoteles;
import model.Hotel;

@Service
public class ServiceHotelesImpl implements ServiceHoteles {
	@Autowired
	DaoHoteles daoHoteles;
	
	@Override
	public List<Hotel> getHotelesDisponibles() {
		List<Hotel> hoteles = daoHoteles.findAll();
		List<Hotel> hotelesDisponibles = new ArrayList<Hotel>();
		for (Hotel hotel : hoteles) {
			if (hotel.getDisponible()==1) {
				hotelesDisponibles.add(hotel);
			}
		}
		return hotelesDisponibles;
	}
}
