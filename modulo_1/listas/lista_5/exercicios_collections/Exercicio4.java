package com.dbc.modulo_1.listas.lista_5.exercicios_collections;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class Exercicio4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>(); //LIFO

        for (int i=0; i<15; i++){
            System.out.println("Digite o "+(i+1)+"º número:");
            int numero = sc.nextInt();
            if (numero%2==0){
                pilha.add(numero);
                System.out.println("Número "+numero+" adicionado. === "+pilha);
            }else{
                if(pilha.size()!=0){
                    System.out.println("Número "+pilha.pop()+" retirado. === "+pilha);
                }
            }
        }

        if (pilha.size() != 0){
            Iterator<Integer> it = pilha.iterator();
            while (it.hasNext()){
                System.out.println("Retirando: "+pilha.pop());
            }
            System.out.println("Esvaziada ==> "+ pilha);
        }else{
            System.out.println("A lista não contém elementos.");
        }
    }
}
