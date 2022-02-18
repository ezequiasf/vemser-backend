package com.dbc;

import java.util.Random;

public class Exercicio7 {

    public static void main(String[] args) {

        int [][] matriz = new int [4][4];
        Random rd = new Random();
        int total = 0;

        for (int i = 0; i< matriz.length ; i++){
            for (int x=0; x< matriz.length;x++){
                //Inserção de colunas
                matriz[i][x] = rd.nextInt(25);
                System.out.print(matriz[i][x]+"\t");
                if (matriz[i][x]>10){
                    ++total;
                }
            }
            System.out.println();
        }
        System.out.printf("Existem %d números maiores que 10.", total);
    }
}
