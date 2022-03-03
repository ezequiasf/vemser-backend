package com.dbc.listas.lista_5.exercicios_collections;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class Exercicio3 {

    static Queue<String> senhas = new LinkedList<>(); //FIFO - First in First out

    public static void main(String[] args) {
        novoCliente(5);
        atenderCliente(2);
        atenderCliente(1);
        novoCliente(3);
        atenderCliente(3);
    }

    public static void novoCliente(int numeroClientes){
        Random rd = new Random();
        int numeroBase = rd.nextInt(1001);
        for (int i = 0; i < numeroClientes; i++) {
            System.out.println("Novo cliente: "+"#"+numeroBase);
            senhas.add("#"+numeroBase++);
        }
        statusFila();
    }

    public static void atenderCliente (int numeroClientes){
        for (int i = 0; i < numeroClientes; i++) {
            System.out.println("Atendendo senha: "+senhas.poll());
        }
        statusFila();
    }

    public static void statusFila (){
        System.out.println("Status da fila: "+senhas);
    }

}
