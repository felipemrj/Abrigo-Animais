package main.service;

import main.util.UserInputValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchPet {
    private static final String FORM_FILE_PATH = "C:\\Users\\felip\\IdeaProjects\\desafioCadastro\\src\\main\\resources\\";
    private static final String FORM_FILE_NAME = "formulario.txt";

    Scanner read = new Scanner(System.in);

    public void searchPet() {
        int option = searchMenu();
        int searchFilter = 0;
        int searchFilter2 = 0;
        if (option == 1) {
            while (searchFilter < 1 || searchFilter > 7) {
                System.out.println("Escolha o critério para a busca: ");
                System.out.println("""
                        1. Nome ou sobrenome
                        2. Tipo
                        3. Sexo
                        4. Endereço
                        5. Idade
                        6. Peso
                        7. Raça
                        """);
                searchFilter = read.nextInt();
                read.nextLine();
            }
            String searchValue = "";
            switch (searchFilter) {
                case 1:
                    searchValue = UserInputValidation.validateName("nome ou sobrenome");
                    break;
                case 2:
                    searchValue = String.valueOf(UserInputValidation.validateType());
                    break;
                case 3:
                    searchValue = String.valueOf(UserInputValidation.validateGender());
                    break;
                case 4:
                    System.out.println("Selecione uma opção: ");
                    System.out.println("""
                            1. Rua
                            2. Número da casa
                            3. Cidade""");
                    int adressOption = read.nextInt();
                    read.nextLine();
                    if (adressOption == 1) {
                        searchValue = UserInputValidation.validateAdressStreet();
                    } else if (adressOption == 2) {
                        searchValue = UserInputValidation.validateAdressNumber();
                    } else {
                        searchValue = UserInputValidation.validateAdressCity();
                    }
                    break;
                case 5:
                    searchValue = UserInputValidation.validateAge();
                    break;
                case 6:
                    searchValue = UserInputValidation.validateWeight();
                    break;
                case 7:
                    searchValue = UserInputValidation.validateBreed();
                    break;
            }
            ArrayList<File> simpleSearchResults = simplePetSearch(searchFilter, searchValue);
            formatSearchResult(simpleSearchResults);
        }
        if (option == 2) {
            while (searchFilter < 1 || searchFilter > 7) {
                System.out.println("Escolha o critério para a busca: ");
                System.out.println("""
                        1. Nome ou sobrenome
                        2. Tipo
                        3. Sexo
                        4. Endereço
                        5. Idade
                        6. Peso
                        7. Raça
                        """);
                searchFilter = read.nextInt();
                read.nextLine();
            }
            String searchValue = "";
            switch (searchFilter) {
                case 1:
                    searchValue = UserInputValidation.validateName("nome ou sobrenome");
                    break;
                case 2:
                    searchValue = String.valueOf(UserInputValidation.validateType());
                    break;
                case 3:
                    searchValue = String.valueOf(UserInputValidation.validateGender());
                    break;
                case 4:
                    System.out.println("Selecione uma opção: ");
                    System.out.println("""
                            1. Rua
                            2. Número da casa
                            3. Cidade""");
                    int adressOption = read.nextInt();
                    read.nextLine();
                    if (adressOption == 1) {
                        searchValue = UserInputValidation.validateAdressStreet();
                    } else if (adressOption == 2) {
                        searchValue = UserInputValidation.validateAdressNumber();
                    } else {
                        searchValue = UserInputValidation.validateAdressCity();
                    }
                    break;
                case 5:
                    searchValue = UserInputValidation.validateAge();
                    break;
                case 6:
                    searchValue = UserInputValidation.validateWeight();
                    break;
                case 7:
                    searchValue = UserInputValidation.validateBreed();
                    break;
            }
            while (searchFilter2 < 1 || searchFilter2 > 7) {
                System.out.println("Escolha o critério para a busca: ");
                System.out.println("""
                        1. Nome ou sobrenome
                        2. Tipo
                        3. Sexo
                        4. Endereço
                        5. Idade
                        6. Peso
                        7. Raça
                        """);
                searchFilter2 = read.nextInt();
                read.nextLine();
            }
            String searchValue2 = "";
            switch (searchFilter2) {
                case 1:
                    searchValue2 = UserInputValidation.validateName("nome ou sobrenome");
                    break;
                case 2:
                    searchValue2 = String.valueOf(UserInputValidation.validateType());
                    break;
                case 3:
                    searchValue2 = String.valueOf(UserInputValidation.validateGender());
                    break;
                case 4:
                    System.out.println("Selecione uma opção: ");
                    System.out.println("""
                            1. Rua
                            2. Número da casa
                            3. Cidade""");
                    int adressOption = read.nextInt();
                    read.nextLine();
                    if (adressOption == 1) {
                        searchValue2 = UserInputValidation.validateAdressStreet();
                    } else if (adressOption == 2) {
                        searchValue2 = UserInputValidation.validateAdressNumber();
                    } else {
                        searchValue2 = UserInputValidation.validateAdressCity();
                    }
                    break;
                case 5:
                    searchValue2 = UserInputValidation.validateAge();
                    break;
                case 6:
                    searchValue2 = UserInputValidation.validateWeight();
                    break;
                case 7:
                    searchValue2 = UserInputValidation.validateBreed();
                    break;
            }
            ArrayList<File> detailedSearchResults = detailedPetSearch(searchFilter, searchValue, searchFilter2, searchValue2);
            formatSearchResult(detailedSearchResults);
        }
    }

    public int searchMenu() {
        int option = 0;
        while (option != 1 && option != 2) {
            System.out.println("""
                    1. Busca simples (1 Critério)
                    2. Busca detalhada (2 Critérios)
                    """);
            option = validateOption();
        }
        return option;
    }

    public int validateOption() {
        System.out.print("Escolha uma opção (1 ou 2): ");
        String option = read.nextLine();
        if (option.isEmpty()) {
            System.out.println("Entrada em branco, por favor escolha uma opção.");
            return 0;
        }
        try {
            int value = Integer.parseInt(option);
            if (value != 1 && value != 2) {
                System.out.println("Opção inválida, escolha 1 ou 2.");
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida, escolha 1 ou 2.");
            return 0;
        }
    }

    public ArrayList<File> createPetList() {
        File petsFolder = new File("C:\\Users\\felip\\IdeaProjects\\desafioCadastro\\src\\main\\resources\\petsCadastrados");

        File[] files = null;
        if (petsFolder.exists() && petsFolder.isDirectory()) {
            files = petsFolder.listFiles();
        }

        ArrayList<File> filesList = new ArrayList<>();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".txt")) {
                    filesList.add(file);
                }
            }
        }
        return filesList;
    }

    public ArrayList<File> simplePetSearch(int searchFilter, String searchValue) {
        ArrayList<File> filesMeetingCriteria = new ArrayList<>();
        ArrayList<File> files = createPetList();
        for (File file : files) {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                int counter = 0;
                while ((line = br.readLine()) != null) {
                    counter++;
                    if (counter == searchFilter) {
                        if (line.toLowerCase().contains(searchValue.toLowerCase())) {
                            filesMeetingCriteria.add(file);
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return filesMeetingCriteria;
    }

    public ArrayList<File> detailedPetSearch(int searchFilter1, String searchValue1, int searchFilter2, String searchValue2) {
        ArrayList<File> firstSearch = simplePetSearch(searchFilter1, searchValue1);
        ArrayList<File> detailedSearch = new ArrayList<>();
        for (File file : firstSearch) {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                int counter = 0;
                while ((line = br.readLine()) != null) {
                    counter++;
                    if (counter == searchFilter2) {
                        if (line.toLowerCase().contains(searchValue2.toLowerCase())) {
                            detailedSearch.add(file);
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return detailedSearch;
    }

    public void formatSearchResult(ArrayList<File> filesMeetingCriteria) {
        ArrayList<String> formattedStrings = new ArrayList<>();
        int lineNumber = 1;
        String formattedSearch = "";
        String lineNumberString;
        for (File file : filesMeetingCriteria) {
            int count = 1;
            lineNumberString = Integer.toString(lineNumber);
            formattedSearch = lineNumberString + ".";
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                while ((line = br.readLine()) != null) {
                    if (count == 7) {
                        formattedSearch += line.substring(3);
                    } else {
                        formattedSearch += line.substring(3) + " -";
                    }
                    count++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            formattedStrings.add(formattedSearch);
            lineNumber++;
        }

        for (String formattedString : formattedStrings) {
            System.out.println(formattedString);
        }

    }


}