package com.dbc.listas.lista_2;

import java.util.Scanner;

public class Exercicio5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] valores = new int [20];
        final int contador = 20;

        for (int i=19; i>=0;i--){
            System.out.printf("Digite o %dº numero:%n", contador-i);
            valores[i] = sc.nextInt();
        }
        String resultado = "";
        for (int valor :valores){
            resultado += valor+" ";
        }
        System.out.println(resultado);
    }
}
