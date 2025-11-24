package br.com.springproject.movie_catalog.prinpal;
import br.com.springproject.movie_catalog.model.DadosSerie;
import br.com.springproject.movie_catalog.model.DadosTemporada;
import br.com.springproject.movie_catalog.service.ConsumoApi;
import br.com.springproject.movie_catalog.service.ConverterDados;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    Scanner scanner = new Scanner(System.in);
    ConsumoApi pesquisa = new ConsumoApi();
    ConverterDados conversor = new ConverterDados();

    public void Menu(){
        System.out.println("digite o filme ou serie desejado: ");
        String nome = scanner.nextLine();
        String nomeFomatado = nome.replace(" ", "+");
        String  url = "http://www.omdbapi.com/?apikey= sua chave aqui =" + nomeFomatado+"&Season=" ;

        var json = pesquisa.obterDados(url);
        DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
        System.out.println("Dados da serie:");
        System.out.println(dados);

        List<DadosTemporada> temporada = new ArrayList<>();
        System.out.println("\n---------------dados-temporada--------------");
        ///this for iteration add all totalSeasons in the list temporada.
        ///  and after use ForEach to prints all objets temporada interacted.
        for (int i = 1; i <= dados.totalTemporadas(); i++) {
            json = pesquisa.obterDados(
                    url + i
            );
            DadosTemporada temp = conversor.obterDados(json, DadosTemporada.class);
            temporada.add(temp);
        }
        temporada.forEach(System.out::println);
        temporada.forEach(t -> t.epsodios().forEach(e -> System.out.println(e.titulo())));


    }
}
