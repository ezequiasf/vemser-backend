package com.dbc.modulo_1.aulas.aula5;

import com.dbc.modulo_1.aulas.aula5.exercicioSobrescricao.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //exercicioSobrecarga();
        exercicioLista();
    }

    public static void exercicioSobrecarga (){
        //Exercício de sobrecarga
        System.out.println("Operações com 3 e 2.");

        OperacaoMatematica operacao = new Soma();
        System.out.println("Soma:"+operacao.calcula(3,2));

        OperacaoMatematica operacao2 = new Subtracao();
        System.out.println("Subtracao:"+operacao2.calcula(3,2));

        OperacaoMatematica operacao3 = new Divisao();
        System.out.println("Divisao:"+operacao3.calcula(3,2));

        OperacaoMatematica operacao4 = new Multiplicacao();
        System.out.println("Multiplicacao:"+operacao4.calcula(3,2));
    }

    public static void exercicioLista (){
        Scanner sc = new Scanner(System.in);
        ArrayList<String> nomes = new ArrayList<>();
        String resposta = "";
        do {
            System.out.println("Digite um nome para adicionar a lista ou SAIR:");
            resposta = sc.nextLine();
            if (!resposta.equalsIgnoreCase("sair")){
                nomes.add(resposta);
            }
        }while (!resposta.equalsIgnoreCase("sair"));

        System.out.println("Penúltimo nome da lista: "+nomes.get(nomes.size()-2));
        System.out.println("Primeiro nome da lista: "+nomes.get(0));
        System.out.println("Removendo o último nome que é... "+ nomes.remove(nomes.size()-1));
        System.out.println("Lista: "+nomes +" ===== Tamanho: "+nomes.size());
    }

}
