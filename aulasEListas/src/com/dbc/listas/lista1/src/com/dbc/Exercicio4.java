package com.dbc.listas.lista1.src.com.dbc;

import utils.Leitor;

import java.util.List;
import java.util.Scanner;

public class Exercicio4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int indexEstado;
        int indexPonto = 0;
        String escolhaEstado = "Escolha de qual estado você quer informações:\n";
        String escolhaCidade = "Agora escolha a cidade:\n";
        List<String[]> estadoCidade = Leitor.leitorArquivos("src/resources/estados.txt");

        System.out.println("Informação sobre estados");
        for (String[] arr: estadoCidade){
            escolhaEstado += estadoCidade.indexOf(arr) +" - "+ arr[0]+"\n";
        }
        System.out.print(escolhaEstado);
        indexEstado = sc.nextInt();

        String[] infoEstado=estadoCidade.get(indexEstado);

        for (int i=1;i<infoEstado.length;i++){
            indexPonto= infoEstado[i].indexOf(":");
            escolhaCidade += i + " - "+infoEstado[i].substring(0,indexPonto)+"\n";
        }
        System.out.print(escolhaCidade);
        int cidade = sc.nextInt();

        String infoMaisCidade = infoEstado[cidade];
        String info = infoMaisCidade.substring(indexPonto+2, infoMaisCidade.indexOf("}"));
        String[] infoExplodida = info.split("\\*");
        System.out.printf("Informações:%nPopulação=%s;%nFesta:%s;%n" +
                "PIB:%s;%n",infoExplodida[0],infoExplodida[1],infoExplodida[2]);
        sc.close();
    }
}
