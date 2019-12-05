package ejbs;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.ejb.Timeout;
import javax.ejb.Timer;

import org.springframework.web.context.support.SpringBeanAutowiringSupport;

/**
 * Session Bean implementation class TemporizadorEjb
 */
@Stateless
@LocalBean
public class TemporizadorEjb /*extends SpringBeanAutowiringSupport // para que un ejb funcione con spring */ implements TemporizadorEjbLocal{
	@Resource
	SessionContext sc;	
	Timer tm;
	
		@Timeout
		void imprimirMensaje(Timer t) {
			System.out.println("Imprimiendo el mensaje periódico "+t.getInfo());
		}
	
		@Override
		public void iniciarTemporizador(long periodo) {         //no se indica el método porque el que se va a ejecutar es el de la anotación @timeout
			tm=sc.getTimerService().createTimer(3000, periodo, "mensaje de temporizador"); // objeto timer (tiempo de retardo, periodo, "metodo")
		}
		@Override
		public void detenerTemporizador() {
			tm.cancel();
			
		}
}
