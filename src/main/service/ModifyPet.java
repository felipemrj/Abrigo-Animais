package main.service;

import main.repository.FormRepository;
import main.util.UserInputValidation;

import java.io.*;
import java.util.ArrayList;

public class ModifyPet {

    public void modifyPet() {
        SearchPet sp = new SearchPet();
        ArrayList<File> petFilesList = sp.createPetList();
        ArrayList<Integer> foundPetIndexes = sp.searchPet();

        if (foundPetIndexes == null || foundPetIndexes.isEmpty()) {
            return;
        }

        int selectedPet = selectPet(foundPetIndexes);
        int selectedPetIndex = foundPetIndexes.get(selectedPet - 1);

        File petToModify = petFilesList.get(selectedPetIndex);

        int selectedInfo = selectInfo();

        String newInfo = newInfo(selectedInfo);

        int lineToReplace = lineToReplace(selectedInfo);

        replaceInfo(petToModify, lineToReplace, newInfo);
    }

    public boolean verifyIsThereResults(ArrayList<Integer> searchResult) {
        if (searchResult == null || searchResult.isEmpty()) {
            return true;
        }
        return false;
    }

    public void noResultsMessage() {
        System.out.println("Não foram encontrados resultados que atendessem aos critérios de busca.");
    }

    public int selectPet(ArrayList<Integer> foundPets) {
        int minValue = 1;
        int maxValue = foundPets.size();
        System.out.println();
        System.out.println("Insira o número do animal que deseja modificar os dados: ");
        System.out.println();
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

    public int lineToReplace(int selectedInfo) {
        if (selectedInfo != 1) {
            return selectedInfo + 2;
        }
        return selectedInfo;
    }

    public File replaceInfo(File selectedPetFile, int lineToReplace, String newInfo) {
        try {
            ArrayList<String> lines = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(selectedPetFile))) {
                String line;
                while ((line = br.readLine()) != null) {
                    lines.add(line);
                }
            }

            if (lineToReplace == 5) {
                newInfo = formatAge(newInfo);
            } else if (lineToReplace == 6) {
                newInfo = newInfo + "kg";
            }

            lines.set(lineToReplace - 1, lineToReplace + " - " + newInfo);

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(selectedPetFile))) {
                for (String l : lines) {
                    bw.write(l);
                    bw.newLine();
                }
            }
            return selectedPetFile;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
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

    public String formatAge(String petAge) {
        try {
            double age = Double.parseDouble(petAge.replace(",", ".").trim());
            if (age < 1) {
                int months = (int) Math.round(age * 100);
                return months + (months == 1 ? " mês" : " meses");
            } else {
                int years = (int) age;
                return years + (years == 1 ? " ano" : " anos");
            }
        } catch (NumberFormatException e) {
            return petAge;
        }
    }

}
