package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.DaoBolsa;
import model.Accione;

@Service
public class ServiceBolsaImpl implements ServiceBolsa{

	@Autowired
	DaoBolsa daoBolsa;

	@Override
	public List<Accione> findAll() {
		return daoBolsa.findAll();
	}
}
