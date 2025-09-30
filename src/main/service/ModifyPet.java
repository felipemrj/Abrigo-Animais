package main.service;

import main.repository.FormRepository;
import main.util.UserInputValidation;

import java.io.File;
import java.util.ArrayList;

public class ModifyPet {

    public void modifyPet() {
        SearchPet sp = new SearchPet();
        ArrayList<File> petFilesList = sp.createPetList();

        ArrayList<Integer> foundPetIndexes = sp.searchPet();

        int selectedPet = selectPet(foundPetIndexes);
        int selectedPetIndex = foundPetIndexes.get(selectedPet - 1);

        File petToModify = petFilesList.get(selectedPetIndex);
        System.out.println(petToModify);

        int selectedInfo = selectInfo();

        String newInfo = newInfo(selectedInfo);
        System.out.println(newInfo);

        // open selected pet file

        // replace old line with new info
    }

    public int selectPet(ArrayList<Integer> foundPets) {
        int minValue = 1;
        int maxValue = foundPets.size();
        System.out.println("Insira o número do animal que deseja modificar os dados: ");
        return UserInputValidation.validateOption(minValue, maxValue);
    }

    public int selectInfo() {
        int option = 0;
        while (option < 1 || option > 5) {
            System.out.println("""
                    Selecione o dado a ser alterado: 
                    1 - Nome e sobrenome
                    2 - Endereço
                    3 - Idade
                    4 - Peso
                    5 - Raça
                    """);
            option = UserInputValidation.validateOption(1, 5);
        }
        return option;
    }

    public String newInfo(int selectedInfo) {
        String newInfo = "";
        switch (selectedInfo) {
            case 1:
                newInfo = newName();
                break;
            case 2:
                newInfo = newAdress();
                break;
            case 3:
                newInfo = newPetAge();
                break;
            case 4:
                newInfo = newPetWeight();
                break;
            case 5:
                newInfo = newPetBreed();
                break;
            default:
                break;
        }
        return newInfo;
    }

    public String newName() {
        FormRepository.readStringInFile(1);
        String firstName = UserInputValidation.validateName("nome");
        String lastName = UserInputValidation.validateName("sobrenome");
        return firstName + " " + lastName;
    }

    public String newAdress() {
        FormRepository.readStringInFile(4);
        System.out.println("a. Rua: ");
        String street = UserInputValidation.validateAdressStreet();
        System.out.println("b. Número da casa: ");
        String number = UserInputValidation.validateAdressNumber();
        System.out.println("c. Cidade: ");
        String city = UserInputValidation.validateAdressCity();
        return street + ", " + number + ", " + city;
    }

    public String newPetAge() {
        FormRepository.readStringInFile(5);
        return UserInputValidation.validateAge();
    }

    public String newPetWeight() {
        FormRepository.readStringInFile(6);
        return UserInputValidation.validateWeight();
    }

    public String newPetBreed() {
        FormRepository.readStringInFile(7);
        return UserInputValidation.validateBreed();
    }
}
