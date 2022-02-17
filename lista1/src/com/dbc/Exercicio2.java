package com.dbc;

import java.util.Scanner;

public class Exercicio2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float total =0;
        float media;
        System.out.println("Bem vindo ao calculador de média ;)");

        for (int i=1; i<=4; i++){
            System.out.printf("Insira a nota %d:%n", i);
            total += sc.nextFloat();
        }
        media = total/4;
        System.out.printf("Sua média foi:%.2f%n",media);
        if (media<5){
            System.out.println("Reprovado.");
        }else if (media>=5.1f && media<=6.9f){
            System.out.println("Em exame.");
        }else{
            System.out.println("Aprovado.");
        }
        sc.close();
    }
}
