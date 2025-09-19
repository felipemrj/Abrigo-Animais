package main;

import main.service.SearchPet;

import java.io.File;
import java.util.ArrayList;

public class ModifyTest01 {
    public static void main(String[] args) {
        // create all files list
        SearchPet sp = new SearchPet();
        ArrayList<File> allFilesList = sp.createPetList();
        System.out.println(allFilesList);

        System.out.println("Simple Searches:");

        //perform simple search and display results
        ArrayList<File> simpleSearchResults = sp.simplePetSearch(3, "feminino");
        sp.formatSearchResult(simpleSearchResults);

        //perform simple search but return indexes instead of info
        ArrayList<Integer> simpleSearchResultsIndexes = sp.simplePetSearchIndexes(3, "feminino");
        System.out.println(simpleSearchResultsIndexes);

        System.out.println();
        System.out.println("---###---");
        System.out.println();

        System.out.println("Detailed Searches:");

        // perform detailed search and display results
        ArrayList<File> detailedSearchResults = sp.detailedPetSearch(2, "Cachorro", 3, "feminino");
        sp.formatSearchResult(detailedSearchResults);

        // perform detailed search but return indexes instead of info
        ArrayList<Integer> detailedSearchResultsIndexes = sp.detailedPetSearchIndexes(2, "Cachorro", 3, "feminino");
        System.out.println(detailedSearchResultsIndexes);

        // now we can assign the selectedPet to the corresponding index of all files list
        int selectedPet = 3;
        int index = detailedSearchResultsIndexes.get(selectedPet - 1);
        System.out.println(index);


        // corresponding file to modify
        System.out.println(allFilesList.get(index));

        // next steps:
        // choose which type of data will be modified
        // validate input, if valid:
        // open corresponding file
        // overwrite corresponding current line with new data
    }
}
