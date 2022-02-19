package com.dbc.listas.lista1.src.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leitor {

    public static List<String[]> leitorArquivos (String caminho){
        ArrayList<String[]> palavras = new ArrayList<>();
        try {
            Scanner leitorArquivo = new Scanner(new FileReader(caminho));
            while (leitorArquivo.hasNextLine()){
                String linha = leitorArquivo.nextLine();
                palavras.add(linha.split(","));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return palavras;
    }

}
