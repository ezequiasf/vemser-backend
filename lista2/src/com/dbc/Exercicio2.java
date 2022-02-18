package com.dbc;

import java.util.Random;
import java.util.Scanner;

public class Exercicio2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int valorTeste = rd.nextInt(11);
        System.out.println("Tente adivinhar o número entre 0-10");
        int resposta = sc.nextInt();

        while (!(resposta==valorTeste)){
            System.out.println( (resposta > valorTeste) ? "O número a ser " +
                    "encontrado é menor":"O número a ser encontrado é maior");
            resposta = sc.nextInt();
        }
        System.out.println("Você acertou!");
    }
}
