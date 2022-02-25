package br.com.javastream;

import java.util.*;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Agenda> agenda = new HashMap<>() {{
            put(1, new Agenda("Gustavo", 1234));
            put(2, new Agenda("Elaine", 4321));
            put(3, new Agenda("Arthur", 5678));
        }};
//        System.out.println(agenda);
//        for (Map.Entry<Integer, Agenda> entry : agenda.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
//        }
//        System.out.println("\n");
//        Map<Integer, Agenda> agendaa = new LinkedHashMap<>() {{
//            put(1, new Agenda("Gustavo", 1234));
//            put(3, new Agenda("Elaine", 4321));
//            put(2, new Agenda("Arthur", 5678));
//        }};
//        for (Map.Entry<Integer, Agenda> entry : agendaa.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
//        }
//        System.out.println("\n");
//        Map<Integer, Agenda> agendaaa = new TreeMap<>(agenda);
//        for (Map.Entry<Integer, Agenda> entry : agendaaa.entrySet()) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().getNome());
//        }
//
//
//        System.out.println("\n");
//
//        Set<Map.Entry<Integer, Agenda>> set = new TreeSet<>(new Comparator<Map.Entry<Integer, Agenda>>() {
//            @Override
//            public int compare(Map.Entry<Integer, Agenda> o1, Map.Entry<Integer, Agenda> o2) {
//                return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
//            }
//        });
//        set.addAll(agenda.entrySet());
//        for (Map.Entry<Integer, Agenda> entry : set) {
//            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + " - " + entry.getValue().getNome());
//        }
//
//        System.out.println("\n");
        Set<Map.Entry<Integer, Agenda>> sett = new TreeSet<>(Comparator.comparing(agendaEntry ->
                agendaEntry.getValue().getNumero()));

        sett.addAll(agenda.entrySet());
        for (Map.Entry<Integer, Agenda> entry : sett) {
            System.out.println(entry.getKey() + " - " + entry.getValue().getNumero() + " - " + entry.getValue().getNome());
        }

    }

    static class Agenda {
        private String nome;
        private Integer numero;

        public Agenda(String nome, Integer numero) {
            this.nome = nome;
            this.numero = numero;
        }

        public String getNome() {
            return nome;
        }

        public Integer getNumero() {
            return numero;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Agenda agenda = (Agenda) o;
            return nome.equals(agenda.nome) && numero.equals(agenda.numero);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nome, numero);
        }

        @Override
        public String toString() {
            return "{" +
                    "nome='" + nome + '\'' +
                    ", numero=" + numero +
                    '}';
        }
    }

//    static class CompararAgenda implements Comparator<Map.Entry<Integer, Agenda>>{
//
//        @Override
//        public int compare(Map.Entry<Integer, Agenda> o1, Map.Entry<Integer, Agenda> o2) {
//            return Integer.compare(o1.getValue().getNumero(), o2.getValue().getNumero());
//        }
//    }
}
