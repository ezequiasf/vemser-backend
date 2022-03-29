package com.dbc.modulo_1.listas.lista_5.exercicios_collections;

import java.util.*;

public class Exercicio5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random cpf = new Random();
        Map<String, String> cadastrados = new HashMap<>();
        String[] nomes = {"João", "Maria", "Marcelo", "Lucas", "Alfredo",
                "Luís", "Carlos", "Davi", "Marcela", "Andreza"};

        for (int i = 0; i < 10; i++) {
            cadastrados.put(Integer.toString(cpf.nextInt(10000000, 1000000000)), nomes[i]);
        }

        String resposta;
        do {
            System.out.println("Cpfs cadastrados: " + cadastrados.keySet());
            System.out.println("Consulte algum dos cpfs para receber o nome ou digite SAIR: ");
            resposta = sc.nextLine();
            if (cadastrados.containsKey(resposta)){
                System.out.println("A pessoa é: "+cadastrados.remove(resposta));
                System.out.println("Removendo...");
            }else if (!resposta.equalsIgnoreCase("sair")){
                System.out.println("Cpf não existe na base de dados.");
            }
        }while(!resposta.equalsIgnoreCase("sair"));
        System.out.println("Lista final: "+cadastrados);
    }
}
