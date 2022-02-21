package com.dbc.listas.lista_2;

import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] valores = new int[3];
        int aux=0;
        int posicao = 0;
        int contadorIguais=0;

        for (int i=0; i< 3; i++){
            System.out.printf("Digite o %dº numero:%n",i+1);
            valores[i] = sc.nextInt();
            //Inserção na variável auxiliar para comparação depois;
            if (i==0){
                aux = valores[i];
            }else{
                if (valores[i]<aux){
                    aux = valores[i];
                    posicao = i;
                }else if (valores[i]==aux){
                    //Se as duas últimas iterações passarem por aqui, todos os números são iguais;
                    ++contadorIguais;
                }
            }
        }
        if (contadorIguais==2){
            System.out.println("Todos os números são iguais");
        }else{
            System.out.println("A posição do menor número digitado no vetor é: "+posicao);
        }
    }
}
