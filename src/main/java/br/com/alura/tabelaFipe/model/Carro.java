package br.com.alura.tabelaFipe.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Carro(@JsonAlias("Valor") String valor,
                    @JsonAlias("Marca") String marca,
                    @JsonAlias("Modelo") String modelo,
                    @JsonAlias("AnoModelo") Integer ano,
                    @JsonAlias("Combustivel") String combustivel,
                    @JsonAlias("CodigoFipe") String fipe,
                    @JsonAlias("MesReferencia") String referencia) {

    @Override
    public String toString() {
        return "***INFORMAÇÕES DO CARRO*** " + "\n" +
                " Valor Total: " + valor + "\n" +
                " Marca: " + marca + "\n" +
                " Modelo: " + modelo + "\n" +
                " Ano: " + ano + "\n" +
                " Combustível: " + combustivel + "\n" +
                " Código Fipe: " + fipe + "\n" +
                " Mês de Referência: " + referencia;    }
}
