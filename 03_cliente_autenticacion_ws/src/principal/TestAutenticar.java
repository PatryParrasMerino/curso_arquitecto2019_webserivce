package principal;

import java.rmi.RemoteException;

import controller.AutenticarController;
import controller.AutenticarControllerProxy;

public class TestAutenticar {

	public static void main(String[] args) throws RemoteException {
		String user = "test1";
		String pass = "test1";

		// se declara variable de la interfaz
		AutenticarController px;
		// instanciamos la clase que implementa el interfaz con le nombre terminado de
		// proxy
		AutenticarControllerProxy proxy = new AutenticarControllerProxy();
		// se le pide una implementación de la interfaz, y es la que hace la de proxy
		px = proxy.getAutenticarController();

		if (px.autenticarCliente(user, pass)) {
			System.out.println("El usuario existe");
		} else {
			System.out.println("El usuario no exite");
		}
	}
}
