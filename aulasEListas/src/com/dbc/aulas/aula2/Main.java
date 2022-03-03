package com.dbc.aulas.aula2;

import java.util.Random;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        exercicio4();
    }

    public static void exercicio1 (){
        //Exercício 1
        int[] valores = {1, 2, 3};
        int total = 0;
        for (int n : valores) {
            total += n;
        }
        System.out.println("Soma:" + total);
        System.out.println("Média:" + (double) total / 3);
    }

    public static void exercicio2 (){
        //Exercicio 2
        Random rd = new Random();
        int[][] valoresRandom = {{rd.nextInt(100), rd.nextInt(100)}, {rd.nextInt(100), rd.nextInt(100)}};
        int soma =0;
        int primeiraLinha = 0;
        int segundaLInha = 0;
        for (int i=0;i<valoresRandom.length;i++){
            for (int x=0;x<2;x++){
                System.out.println("Valor:"+valoresRandom[i][x]);
                if (i==0){
                    primeiraLinha+=valoresRandom[i][x];
                }else{
                    segundaLInha+=valoresRandom[i][x];
                }
                soma +=valoresRandom[i][x];
            }
        }
        System.out.printf("Soma total:%d%nSoma primeira linha:%d%n" +
                "Soma segunda linha:%d%nDiferença:%d%n",soma, primeiraLinha,segundaLInha,segundaLInha-primeiraLinha);
    }

    public static void exercicio3 (){
        //Exercicio 3
        System.out.println("Quantos números você quer?");
        int [] numeros = new int[sc.nextInt()];
        int totalNumeros = 0;

        for (int i=0; i<numeros.length;i++){
            System.out.printf("Digite o %dº número:%n",i+1);
            numeros[i] = sc.nextInt();
            totalNumeros +=numeros[i];
        }
        System.out.printf("A média é:%.2f%n",(double)totalNumeros/numeros.length);
    }

    public static void exercicio4 (){
        //Exercício 4
        String resposta;
        do{
            System.out.println("Digite uma palavra: Para desligar digite [sair]");
            resposta = sc.nextLine();
        }while (!resposta.equalsIgnoreCase("sair"));
    }
}
