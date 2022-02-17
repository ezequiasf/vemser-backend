package com.dbc;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite seu nome por favor:");
        String nome = sc.nextLine();

        System.out.println("Digite sua idade:");
        int idade = sc.nextInt();
        sc.nextLine();

        System.out.println("Digite sua cidade:");
        String cidade = sc.nextLine();

        System.out.println("Digite seu estado:");
        String estado = sc.nextLine();

        System.out.printf("Olá seu nome é %s, você tem %d anos, é da cidade de " +
                "%s, situada no estado de %s.%n", nome, idade, cidade, estado);
        sc.close();
    }
}
