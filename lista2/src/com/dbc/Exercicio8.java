package com.dbc;

import java.util.Random;

public class Exercicio8 {


    public static void main(String[] args) {

        Object [][] tabelaAlunos = new Object[5][4];
        //Iteração Randomica
        Random rd = new Random();
        //Colocado no tipo Object, pois queria colocar double e integer;
        Object matriculaMaiorNota = null; 
        double totalMediaFinal = 0;
        double maiorNota = 0;

        System.out.println("[Matricula]\t\t[MProvas]\t\t[Mtrabalhos]\t[Nfinal]");
        for (int i = 0; i< tabelaAlunos.length;i++){
            for (int x = 0; x < tabelaAlunos.length-1;x++){
                //Inserção da matrícula e impressão;
                if (x == 0){
                    tabelaAlunos[i][x] = rd.nextInt(1000,10000);
                    System.out.print("\t"+tabelaAlunos[i][x]+"\t");
                }
                //Inserção da prova, trabalho e impressão;
                else if(x<3){
                    tabelaAlunos[i][x] = rd.nextDouble(2.0,10.01);
                    System.out.printf("\t\t%.2f\t",(double)tabelaAlunos[i][x]);
                }

                else{
                    //Cálculo da média final;
                    tabelaAlunos [i][3] = (double)tabelaAlunos[i][1]*0.6+(double)tabelaAlunos[i][2]*0.4;
                    //Lógica para reconhecimento da matrícula de maior nota;
                    if ((double)tabelaAlunos[i][3] > maiorNota){
                        maiorNota = (double) tabelaAlunos[i][3];
                        matriculaMaiorNota = tabelaAlunos[i][0];
                    }
                    totalMediaFinal += (double)tabelaAlunos[i][3];
                    System.out.printf("\t\t%.2f\t",(double)tabelaAlunos[i][3]);
                }
            }
            System.out.println();
        }
        System.out.printf("%n%nMatrícula de maior nota:\t%d%n" +
                "Média das notas finais:\t%.2f%n",(Integer) matriculaMaiorNota,totalMediaFinal/5);
    }
}
