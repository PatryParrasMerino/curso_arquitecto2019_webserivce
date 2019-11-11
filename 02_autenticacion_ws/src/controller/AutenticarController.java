package controller;

import factories.FactoryDao;
import javabeans.Cliente;
import modelo.DaoClientes;

public class AutenticarController {

	public boolean autenticarCliente(String user, String pass) {
		DaoClientes daoClientes=FactoryDao.getDaoClientes();
		return daoClientes.autenticar(user, pass);
	}
	
	public Cliente obtenerCliente(String user, String pass) {
		DaoClientes daoClientes=FactoryDao.getDaoClientes();
		return daoClientes.getCliente(user, pass);
	}
	
}
