package br.com.springproject.movie_catalog;

import br.com.springproject.movie_catalog.model.DadosSerie;
import br.com.springproject.movie_catalog.service.ConsumoApi;
import br.com.springproject.movie_catalog.service.ConverterDados;
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
        ConsumoApi pesquisa = new ConsumoApi();
        var json = pesquisa.obterDados("http://www.omdbapi.com/?t=the+punisher&apikey=f6e4380d");
        ConverterDados conversor= new ConverterDados();
        DadosSerie dados = conversor.obterDados(json, DadosSerie.class);
        System.out.println("\n"+dados);
    }
}
