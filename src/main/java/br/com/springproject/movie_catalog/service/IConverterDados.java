package br.com.springproject.movie_catalog.service;

public interface IConverterDados {
    <T> T obterDados(String json, Class<T> classe);
}
