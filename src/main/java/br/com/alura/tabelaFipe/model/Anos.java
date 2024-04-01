package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Anos(
        @JsonAlias("codigo") String codigo,
        @JsonAlias("nome") String nome){
    @Override
    public String toString() {
        return  " Código: " + codigo +
                " Ano/Modelo: " + nome;
    }
}