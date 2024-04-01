package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Marca(
        @JsonAlias("codigo") Integer codigo,
        @JsonAlias("nome") String nome){
    @Override
    public String toString() {
        return  " Código: " + codigo +
                " Nome: " + nome;
    }
}
