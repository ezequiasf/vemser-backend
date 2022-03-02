package com.dbc.modulo_1.listas.lista_2;

import java.util.Scanner;

public class Exercicio3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int contador = 0;
        int idadeMaisVelho = 0;
        float pesoMaisPesado = 0f;
        float maiorAltura = 0f;
        float totalAltura = 0f;
        int auxInt;
        float auxFloat;
        String nome = "";
        String jogadorMaisVelho ="";
        String jogadorMaisPesado="";

        while (!nome.equalsIgnoreCase("sair")){
            System.out.println("Deseja cadastrar um jogador [Digite o nome] ou Sair[Digite sair]?");
            nome = sc.nextLine();

            if (!(nome.equalsIgnoreCase("sair"))){
                //Contando número de iterações que é igual ao número de jogadores;
                ++contador;

                System.out.println("Altura:");
                auxFloat = sc.nextFloat();
                if (contador==1){
                    maiorAltura = auxFloat;
                }else if(auxFloat>maiorAltura){
                    maiorAltura = auxFloat;
                }
                totalAltura +=auxFloat;
                sc.nextLine();

                System.out.println("Idade:");
                auxInt = sc.nextInt();

                System.out.println("Peso:");
                auxFloat = sc.nextFloat();
                sc.nextLine();

                if (contador==1){
                    jogadorMaisPesado = nome;
                    jogadorMaisVelho = nome;
                    idadeMaisVelho = auxInt;
                    pesoMaisPesado = auxFloat;
                }else{
                    if (auxInt > idadeMaisVelho){
                        idadeMaisVelho = auxInt;
                        jogadorMaisVelho = nome;
                    }
                    if (auxFloat > pesoMaisPesado){
                        pesoMaisPesado = auxFloat;
                        jogadorMaisPesado = nome;
                    }
                }
            }

        }
        if (contador!=0)
        System.out.printf("Quantidade de jogadores: %d%nMaior Altura: %.2f%n" +
                "Jogador mais velho:%s%n" +
                "Jogador mais pesado:%s%n" +
                "Média das Alturas:%.2f", contador, maiorAltura,jogadorMaisVelho,jogadorMaisPesado,totalAltura/contador);
    }
}
