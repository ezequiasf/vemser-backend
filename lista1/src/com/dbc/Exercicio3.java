package com.dbc;

import java.util.Scanner;

public class Exercicio3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Calculadora de troco");
        System.out.println("Digite o valor total consumido:");
        double valorConsumido = sc.nextDouble();

        System.out.println("Digite o valor pago pelo cliente:");
        double valorPago = sc.nextDouble();

        if (valorConsumido>valorPago){
            System.out.println("o valor pago" +
                    " deve ser maior ou igual ao valor consumido.");
        }else{
            System.out.printf("O valor do troco é:%.2f", valorPago-valorConsumido);
        }
    }
}
