package com.dbc.aulas.aula6;

import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
//        exercicio1(8,10);
//        exercicio2();
        System.out.println(somatorio(1));
    }

    public static void exercicio1 (int n1, int n2){
        Calculo soma = (a,b)-> a+b;
        Calculo multiplicacao = (a,b)-> a*b;

        System.out.println("Soma de "+n1+" e "+n2+": "+soma.calcular(n1,n2)+"\nMultiplicacao de "+n1+" e "+ n2+": "+
                multiplicacao.calcular(n1,n2));
    }

    public static void exercicio2 (){

       // >>> Composição de função (Realizar as duas em sequência)
        Function<Double,Double> cosseno = v1 -> Math.cos(v1);
        Function<Double, Double> raizQuadrada = v1-> Math.sqrt(v1);
        Function<Double,Double> cosThenRaiz = cosseno.andThen(raizQuadrada);

        System.out.println(cosThenRaiz.apply(1.0));
    }

    //Recursividade
    public static int somatorio (int n){
        if (n==1){
            return 1;
        }
        return n + somatorio(n-1);
    }


}
