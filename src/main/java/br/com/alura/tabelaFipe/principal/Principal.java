package br.com.alura.tabelaFipe.principal;
import br.com.alura.tabelaFipe.model.*;
import br.com.alura.tabelaFipe.service.ConsumoAPI;
import br.com.alura.tabelaFipe.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private ConsumoAPI consumo = new ConsumoAPI();
    private ConverteDados conversor = new ConverteDados();
    private Scanner leitor = new Scanner(System.in);
    private final String URL_BASE = "https://parallelum.com.br/fipe/api/v1/";

    public void exibeMenu() {

        System.out.println("ESCOLHA UMA OPÇÃO:");
        System.out.println("******************");
        System.out.println("Carro");
        System.out.println("Moto");
        System.out.println("Caminhão");
        System.out.println("******************");

        var escolha = leitor.nextLine();
        String endereco;

        if (escolha.toLowerCase().contains("carr")){
            endereco = URL_BASE + "carros/marcas";
        } else if (escolha.toLowerCase().contains("mot")){
            endereco = URL_BASE + "motos/marcas";
        } else {
            endereco = URL_BASE + "caminhoes/marcas";
        }

        var json = consumo.obterDados(endereco);
        var marcas = conversor.obterListaDeDados(json, Marca.class);
        marcas.stream()
                .sorted(Comparator.comparing(Marca::codigo))
                .forEach(System.out::println);

        System.out.println("Digite o código da marca desejada");
        var marcaSelecionada = leitor.nextInt();

        endereco = endereco +"/" + marcaSelecionada+ "/modelos";
        json = consumo.obterDados(endereco);

        var modeloLista = conversor.obterDados(json, Modelo.class);
        System.out.println("*******LISTA DE MODELOS*******");
        modeloLista.modelos().stream()
                .sorted(Comparator.comparing((Marca::codigo)))
                .forEach(System.out::println);

        System.out.println("Digite o código do modelo desejado:");
        var modeloSelecionado = leitor.nextInt();

        endereco = endereco +"/" + modeloSelecionado +"/anos";
        json = consumo.obterDados(endereco);
        var anosModelo = conversor.obterListaDeDados(json, Anos.class);

        System.out.println("********LISTA DE ANOS*********");
        anosModelo.stream()
                .sorted(Comparator.comparing(Anos::codigo))
                .forEach(System.out::println);

        System.out.println("Digite o código do ano desejado:");
        var anoSelecionado = leitor.next();

        endereco = endereco +"/"+ anoSelecionado;
        json = consumo.obterDados(endereco);

        var carroSelecionado = conversor.obterDados(json, Carro.class);
        System.out.println(carroSelecionado);
    }
}
