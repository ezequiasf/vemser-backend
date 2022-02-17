package com.dbc;

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Calculadora de salário");

        System.out.println("valor da hora em R$:");
        double valorHora = sc.nextDouble();

        System.out.println("número de horas normais trabalhadas:");
        int horaTrabalhada = sc.nextInt();

        System.out.println("número de horas extras 50%:");
        int horaExtraCinquenta = sc.nextInt();

        System.out.println("número de horas extras 100%:");
        double horaExtraCem = sc.nextInt();

        double salarioBruto = (valorHora*horaTrabalhada)+(horaExtraCinquenta*valorHora*1.5)
                +(horaExtraCem*valorHora*2);
        System.out.printf("O Salário bruto é:R$ %.2f",salarioBruto);
        sc.close();
    }
}
