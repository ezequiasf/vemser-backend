package com.dbc.modulo_1.aulas.aula1;

import java.util.Scanner;

public class ExercicioCalculadora {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Digite a operação que vai utilizar:");
        String operacao = sc.nextLine();

        System.out.println("Digite a operação que vai utilizar:");
        int var1 = sc.nextInt();

        System.out.println("Digite a operação que vai utilizar:");
        int var2 = sc.nextInt();

        int resultado = 0;

        switch(operacao){
            case "soma":
                resultado = var1+var2;
                break;
            case "subtracao":
                resultado = var1-var2;
                break;
            case "multiplicacao":
                resultado = var1*var2;
                break;
            case "divisao":
                resultado = var1/var2;
                break;
        }
        System.out.println("O resultado é:"+resultado);
    }
}
