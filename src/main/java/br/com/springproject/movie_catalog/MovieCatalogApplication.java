package br.com.springproject.movie_catalog;

import br.com.springproject.movie_catalog.prinpal.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication /// define a classe princiapl
public class MovieCatalogApplication implements CommandLineRunner {
    public static void main(String[] args) {
		SpringApplication.run(MovieCatalogApplication.class, args);
	}
    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.Menu();


    }
}
