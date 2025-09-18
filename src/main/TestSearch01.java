package main;

import main.service.SearchPet;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSearch01 {
    public static void main(String[] args) {
        SearchPet sp = new SearchPet();

        System.out.println("Busca simples: feminino");
        ArrayList<File> simpleSearchResults = sp.simplePetSearch(3, "feminino");
        sp.formatSearchResult(simpleSearchResults);

        System.out.println("-----");

        System.out.println("Busca simples: masculino");
        ArrayList<File> simpleSearchResults2 = sp.simplePetSearch(3, "masculino");
        sp.formatSearchResult(simpleSearchResults2);

        System.out.println("-----");

        System.out.println("Busca detalhada: cachorro-feminino");
        ArrayList<File> detailedSearchResults = sp.detailedPetSearch(2, "Cachorro", 3, "feminino");
        sp.formatSearchResult(detailedSearchResults);

        System.out.println("-----");

        System.out.println("Busca detalhada: cachorro-masculino");
        ArrayList<File> detailedSearchResults2 = sp.detailedPetSearch(2, "Cachorro", 3, "masculino");
        sp.formatSearchResult(detailedSearchResults2);

        System.out.println("-----");

        System.out.println("Busca detalhada: masculino-rotweiller");
        ArrayList<File> detailedSearchResults3 = sp.detailedPetSearch(3, "masculino", 7, "rotweiller");
        sp.formatSearchResult(detailedSearchResults3);

        System.out.println("-----");

        System.out.println("Busca detalhada: vira-lata-cachorro");
        ArrayList<File> detailedSearchResults4 = sp.detailedPetSearch(7, "vira-lata", 2, "cachorro");
        sp.formatSearchResult(detailedSearchResults4);
    }
}

