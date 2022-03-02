package com.dbc.listas.lista_2;

import java.util.Random;

public class Exercicio6 {

    public static void main(String[] args) {

        int [] vet = new int [10];
        Random rd = new Random();
        //A medida que o vetor é preenchido ele verifica se já existe o número dentro.
        for (int i=0; i<10;i++){
            vet[i] = rd.nextInt(21);
            if (i!=0){
                for (int x=0; x<i;x++){
                   if (vet[x]==vet[i]){
                       System.out.printf("Já existe o número %d na posição %d do vetor.%n", vet[i],x);
                   }
                }
            }
        }
        for (int n:vet){
            System.out.print(n+" | ");
        }
    }
}
