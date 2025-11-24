package br.com.springproject.movie_catalog.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosEpsodios(@JsonAlias("Title") String titulo,

                            @JsonAlias("Episode") Integer nuemro,

                            @JsonAlias("imdbRating") String avaliacao,

                            @JsonAlias("Released") String dataLancamento) {

}
