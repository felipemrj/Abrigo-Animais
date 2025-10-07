package main.service;

import main.util.UserInputValidation;

import java.io.File;
import java.util.ArrayList;

public class DeletePet {
    public void deletePet() {
        SearchPet sp = new SearchPet();
        ArrayList<File> petFilesList = sp.createPetList();

        ArrayList<Integer> foundPetIndexes = sp.searchPet();

        int selectedPet = selectPet(foundPetIndexes);
        int selectedPetIndex = foundPetIndexes.get(selectedPet - 1);

        File petToDelete = petFilesList.get(selectedPetIndex);

        deleteFile(petToDelete);
    }

    public int selectPet(ArrayList<Integer> foundPets) {
        int minValue = 1;
        int maxValue = foundPets.size();
        System.out.println("Insira o número do animal que deseja deletar: ");
        return UserInputValidation.validateOption(minValue, maxValue);
    }

    public void deleteFile(File selectedPetFile) {
        boolean isDeleted = selectedPetFile.delete();
        if (isDeleted) {
            System.out.println("Arquivo deletado com sucesso.");
        } else {
            System.out.println("Falha ao deletar o arquivo.");
        }
    }
}
