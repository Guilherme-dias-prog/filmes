package br.com.alura.screenmatch.Principal;

import br.com.alura.screenmatch.modelos.Filme;
import br.com.alura.screenmatch.modelos.Serie;
import br.com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class ListasPrincipal {
    public static void main(String[] args) {

        Filme meuFilme = new Filme("o poderoso chefão",1970);
        meuFilme.avalia(9);
        var filmeDoPaulo = new Filme("Dogville",2003);
        filmeDoPaulo.avalia(8);
        Filme outroFilme = new Filme("Avatar",2023);
        outroFilme.avalia(6);
        Serie lost = new Serie("Lost",2000);


        List<Titulo> ListaFilme = new LinkedList<>();
        ListaFilme.add(meuFilme);
        ListaFilme.add(outroFilme);
        ListaFilme.add(filmeDoPaulo);
        ListaFilme.add(lost);

        for (Titulo item: ListaFilme){
            System.out.println(item.getNome());
            if (item instanceof Filme filme){
                System.out.println("calssificação: "+filme.getClassificacao());
            }


        }
        Collections.sort(ListaFilme);
        System.out.println("lista arrumada;"+ListaFilme);
        ListaFilme.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println("ordem por ano" + ListaFilme);


    }
}
