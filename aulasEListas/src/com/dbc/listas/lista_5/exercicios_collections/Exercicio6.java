package com.dbc.listas.lista_5.exercicios_collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exercicio6 {

    public static void main(String[] args) {

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(new Pessoa("Marcos", 13));
        pessoas.add(new Pessoa("Marcelo", 15));
        pessoas.add(new Pessoa("Marcelo", 19));
        pessoas.add(new Pessoa("Rafaela", 23));
        pessoas.add(new Pessoa("Rafaela", 26));
        pessoas.add(new Pessoa("Alex", 19));
        pessoas.add(new Pessoa("Alessandra", 25));
        pessoas.add(new Pessoa("Arthur", 11));
        pessoas.add(new Pessoa("Vinicius", 45));
        pessoas.add(new Pessoa("Karina", 19));

        System.out.println("============== Forma crescente por nomes ===================");
        Comparator<Pessoa> comparadorNomesCrescente = (p1,p2) -> p1.getNome().compareTo(p2.getNome());
        pessoas.sort(comparadorNomesCrescente);
        System.out.println(pessoas+"\n\n\n");

        System.out.println("=============== Por idade decrescente =======================");
        Comparator<Pessoa> comparadorIdadeDecrescente = (p1,p2) -> p2.getIdade()-p1.getIdade();
        pessoas.sort(comparadorIdadeDecrescente);
        System.out.println(pessoas+"\n\n\n");

        System.out.println("=============== Com critério =======================");
        Comparator<Pessoa> comparadorComCriterio = (p1,p2) -> {
            if (!(p1.getNome().equals(p2.getNome()))){
                return p1.getNome().compareTo(p2.getNome());
            }
            return p1.getIdade()-p2.getIdade();
        };
        pessoas.sort(comparadorComCriterio);
        System.out.println(pessoas);
    }

    static class Pessoa {

        private String nome;
        private int idade;

        public Pessoa(String nome, int idade) {
            this.nome = nome;
            this.idade = idade;
        }

        public void setIdade(int idade) {
            this.idade = idade;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public int getIdade() {
            return idade;
        }

        @Override
        public String toString() {
            return "{nome= " + nome +
                    ", idade= " + idade +
                    '}';
        }
    }
}
