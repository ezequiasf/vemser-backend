package com.dbc.modulo_1.listas.lista_1.exercises;

import com.dbc.modulo_1.listas.lista_1.utils.Leitor;

import java.util.List;
import java.util.Scanner;

public class Exercicio6 {

    static List<String[]> palavraLista = Leitor.leitorArquivos("src/com/dbc/modulo_1/listas/lista_1/resources/palavras.txt");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String palavra;

        System.out.println("Bem vindo ao tradutor");
        System.out.println("Como você deseja traduzir? (1) por -> ing / (2) ing -> por");
        int traducao = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite a palavra:");
        palavra = sc.nextLine();

        if (traducao == 1) {
            tradutor(palavra,0);
        }else if(traducao==2){
            tradutor(palavra, 1);
        }else{
            System.out.println("Resposta inválida.");
        }
        sc.close();
    }

    private static void tradutor(String palavra, int index) {
        int sentinela = (index ==0) ? 1:-1;
        boolean existe = false;
        for (String[] arr:palavraLista){
            if(arr[index].equalsIgnoreCase(palavra)) {
                System.out.println(arr[index + sentinela]);
                existe = true;
                break;
            }
        }
        if (!existe){
            System.out.println("Essa palavra não é válida.");
        }
    }

}
