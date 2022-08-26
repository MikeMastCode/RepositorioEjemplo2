package Ejemplo2.Ejemplo2;

import Entidades.Ejemplo2.Empresa;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication (exclude ={SecurityAutoConfiguration.class})
public class Ejemplo2Application {

	@GetMapping("/hello")
	public String hello(){
		return "hola amigo 3... Ahi vamos";

	}
	@GetMapping("/test")
	public String test(){
		Empresa emp = new Empresa("Postobon","Calle 2","3213213211", "8001212-2");
       emp.getNombre();

		System.out.println("Paso por aqui");

		return emp.getNombre();
	}


	public static void main(String[] args) {
		SpringApplication.run(Ejemplo2Application.class, args);
		System.out.println("Hola Mundo");
	}

}
