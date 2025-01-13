package LiterAlura;

import LiterAlura.principal.PrincipalBDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApplicationBDD implements CommandLineRunner {

	private final PrincipalBDD principal;

	@Autowired
	public ApplicationBDD(PrincipalBDD principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(ApplicationBDD.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Llamar al método interfaz de Principal
		principal.interfaz();
	}
}