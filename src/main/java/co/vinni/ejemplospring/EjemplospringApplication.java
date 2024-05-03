package co.vinni.ejemplospring;

import co.vinni.ejemplospring.repositorio.RepositorioPropietario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EjemplospringApplication  {

	public static void main(String[] args) {
		SpringApplication.run(EjemplospringApplication.class, args);
	}

}
