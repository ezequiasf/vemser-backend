package com.dbc.modulo_1.aulas.aula7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Qual o tipo de comida que você deseja? Digite [1] Japonesa, [2] Fast food, [3] Tradicional.");
        int resposta = sc.nextInt();

        switch (resposta){
            case 1 -> System.out.println("O valor é: R$"+TipoComida.JAPONESA.getValor());
            case 2 -> System.out.println("O valor é: R$"+TipoComida.FAST_FOOD.getValor());
            case 3 -> System.out.println("O valor é: R$"+TipoComida.TRADICIONAL.getValor());
            default -> System.out.println("Número inválido.");
        }
    }

    enum TipoComida {

        JAPONESA(50.0), FAST_FOOD(30.0), TRADICIONAL(20.0);

        private final double valor;

        TipoComida (double valor){
            this.valor = valor;
        }

        public double getValor() {
            return valor;
        }
    }
}
