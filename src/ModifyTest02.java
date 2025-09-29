import main.service.SearchPet;

import java.io.File;
import java.util.ArrayList;

public class ModifyTest02 {
    public static void main(String[] args) {
        SearchPet sp = new SearchPet();

        // Lista todos os arquivos de pets cadastrados (cada arquivo representa um pet)
        ArrayList<File> petFilesList = sp.createPetList();

        // Executa a busca (simples ou detalhada) conforme parâmetros que o usuário informa via terminal.
        // O mét0do retorna os índices dos pets encontrados (referentes à lista completa)
        ArrayList<Integer> foundPetIndexes = sp.searchPet();

        System.out.println();

        System.out.println("Índices dos pets encontrados na busca (referentes à lista acima):");
        System.out.println(foundPetIndexes);
        System.out.println();

        // Simula escolha do usuário
        int chosenResultPosition = 3; // posição na lista de resultados
        int chosenPetIndex = foundPetIndexes.get(chosenResultPosition - 1); // índice na lista completa de arquivos

        System.out.println("O arquivo correspondente ao pet escolhido na busca é:");
        System.out.println("Índice " + chosenPetIndex + ": " + petFilesList.get(chosenPetIndex).getName());
        System.out.println("Caminho completo: " + petFilesList.get(chosenPetIndex).getAbsolutePath());

    }
}