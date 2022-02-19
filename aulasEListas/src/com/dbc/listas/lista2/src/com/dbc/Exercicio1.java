package com.dbc.listas.lista2.src.com.dbc;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        System.out.println("Nome do produto:");
        String produto = sc.nextLine();

        System.out.println("Preço original:");
        float precoOriginal = sc.nextFloat();

        float desconto = 0.05f;

        System.out.println("Promoção:\n************");
        for (int i=0; i<10; i++){
            float valorDescontado = precoOriginal-precoOriginal*desconto;
            //Valor descontado, valor final (produto)
            System.out.printf("%d X R$ %.2f = %.2f%n",i+1,valorDescontado,valorDescontado*(i+1));
            desconto += 0.05;
        }
    }
}
