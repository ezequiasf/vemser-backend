package com.dbc.modulo_1.listas.lista_6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HomeworkStream {

    public static void main(String[] args) {
        List<Pessoa> lista = new ArrayList<>();
        int i = 0;
        lista.add(new Pessoa(++i, "Paulo", 6500, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Pedro", 5300, "Desenvolvedor"));
        lista.add(new Pessoa(++i, "Joel", 6000, "Arquiteto"));
        lista.add(new Pessoa(++i, "Henrique", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gabriel", 1000, "Estagiário"));
        lista.add(new Pessoa(++i, "Gustavo", 18000, "Diretor"));

//1- listar todas as pessoas
        System.out.println("========= Questão 1 - listar todas as pessoas ==============\n");
        lista.forEach(System.out::println);
        System.out.println();

//2- filtrar todas as pessoas com salario maior do que 5 mil
        System.out.println("========= Questão 2 - filtrar todas as pessoas com salario maior do que 5 mil ==============\n");
        lista.stream().filter(p-> p.getSalario()>5000)
                .map(Pessoa::getNome).forEach(System.out::println);
        System.out.println();

//3- filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente
        System.out.println("========= Questão 3 - filtrar todas as pessoas que são desenvolvedoras e organizar por salário crescente ==============\n");
        lista.stream().filter(p-> p.getCargo().equalsIgnoreCase("desenvolvedor"))
                .sorted(Comparator.comparingDouble(Pessoa::getSalario))
                .forEach(p-> {
                    System.out.printf("Desenvolvedor:%s%nSalário:%.2f%n",p.getNome(),p.getSalario());
                });
        System.out.println();

//4- fazer a média salarial de todos
        System.out.println("========= Questão 4 - fazer a média salarial de todos ==============\n");
        double media = lista.stream().mapToDouble(Pessoa::getSalario).average().getAsDouble();
        System.out.println("Média: "+media);
        System.out.println();

//5- verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil
        System.out.println("========= Questão 5 - verificar na lista (utilizando o método anyMatch) se tem alguém que ganha mais do que 20 mil ==============\n");
        boolean b = lista.stream().anyMatch(p -> p.getSalario() > 20000);
        System.out.println(b);
        System.out.println();

//6 - retornar uma lista de todos os ids das pessoas
        System.out.println("========= Questão 6 - retornar uma lista de todos os ids das pessoas ==============\n");
        List<Integer> ids = lista.stream().map(Pessoa::getId).toList();
        System.out.println(ids);
        System.out.println();

//7 - criar uma nova classe Salario com ID e Salário, utilizando a função "map" do stream, retornar uma lista desse novo objeto
        System.out.println("========= Questão 7 - criar uma nova classe Salario com ID e Salário, utilizando a função \"map\" do stream, retornar uma lista desse novo objeto ==============\n");
        List<Salario> salarios = lista.stream().map(p -> new Salario(p.getId(), p.getSalario())).toList();
        System.out.println(salarios);
        System.out.println();

//8- retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores
        System.out.println("========= Questão 8 - retornar um Map (HashMap) contendo os ids e os nomes dos colaboradores");
        Map<Integer, String> idsNomes = lista.stream().collect(Collectors.toMap(Pessoa::getId, Pessoa::getNome));
        System.out.println(idsNomes);
        System.out.println();

//9- com o mapa da questão 8, retornar o nome com o id=2
        System.out.println("========= Questão 9 - com o mapa da questão 8, retornar o nome com o id=2");
        String nome1 = idsNomes.keySet().stream().filter(x->x==2)
                .map(chave -> idsNomes.get(chave))
                .reduce("", (chave1, chave2) -> chave1+chave2);
        //Jeito fácil
        String nome = idsNomes.get(2);
        System.out.println(nome1);
    }

    static class Salario {

        private final int id;
        private final double salario;

        public Salario(int id, double salario) {
            this.id = id;
            this.salario = salario;
        }

        @Override
        public String toString() {
            return "Salario{" +
                    "id=" + id +
                    ", salario=" + salario +
                    '}';
        }
    }

    static class Pessoa {
        private final int id;
        private String nome;
        private final double salario;
        private final String cargo;

        public Pessoa(int id, String nome, double salario, String cargo) {
            this.id = id;
            this.nome = nome;
            this.salario = salario;
            this.cargo = cargo;
        }

        public int getId() {
            return id;
        }

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public double getSalario() {
            return salario;
        }

        public String getCargo() {
            return cargo;
        }

        @Override
        public String toString() {
            return "Pessoa{" +
                    "id=" + id +
                    ", nome='" + nome + '\'' +
                    ", salario=" + salario +
                    ", cargo='" + cargo + '\'' +
                    '}';
        }
    }
}
