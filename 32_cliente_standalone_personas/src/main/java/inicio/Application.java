package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//Para que funciona arrancar 22 y 23

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(Application.class, args); //la llamada al metodo run crea contexto de aplicacion y podemos pedirle objetos spring
		AccesoServicio acceso= ctx.getBean(AccesoServicio.class);              //sin inyeccion
		acceso.imprimirPersonas();
	}
	
	@LoadBalanced
	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
	
}
