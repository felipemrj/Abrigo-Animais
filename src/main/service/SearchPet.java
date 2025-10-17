package main.service;

import main.util.UserInputValidation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Comparator;

public class SearchPet {
    private static final String FORM_FILE_PATH = "src/main/resources/petsCadastrados";

    public ArrayList<Integer> searchPet() {
        int option = searchMenu();

        if (option == 1) {
            int searchFilter = searchFilterMenu();
            String searchValue = searchValueValidation(searchFilter);

            ArrayList<File> simpleSearchResults = simplePetSearch(searchFilter, searchValue);

            boolean resultsVerification = verifyIsThereResults(simpleSearchResults);

            formatSearchResult(simpleSearchResults);

            if (resultsVerification) {
                noResultsMessage();
                return null;
            }

            return simplePetSearchIndexes(searchFilter, searchValue);
        }
        if (option == 2) {
            int searchFilter = searchFilterMenu();
            String searchValue = searchValueValidation(searchFilter);

            int searchFilter2 = searchFilterMenu();
            String searchValue2 = searchValueValidation(searchFilter2);

            ArrayList<File> detailedSearchResults = detailedPetSearch(searchFilter, searchValue, searchFilter2, searchValue2);

            boolean resultsVerification = verifyIsThereResults(detailedSearchResults);

            formatSearchResult(detailedSearchResults);

            if (resultsVerification) {
                noResultsMessage();
                return null;
            }

            return detailedPetSearchIndexes(searchFilter, searchValue, searchFilter2, searchValue2);
        }
        return null;
    }

    public boolean verifyIsThereResults(ArrayList<File> searchResult) {
        if (searchResult == null || searchResult.isEmpty()) {
            return true;
        }
        return false;
    }

    public void noResultsMessage() {
        System.out.println("Não foram encontrados resultados que atendessem aos critérios de busca.");
    }

    public int searchMenu() {
        int option = 0;

        while (option != 1 && option != 2) {
            System.out.println("""
                    
                    1. Busca simples (1 Critério)
                    2. Busca detalhada (2 Critérios)
                    """);
            option = UserInputValidation.validateOption(1, 2);
        }
        return option;
    }

    public int searchFilterMenu() {
        int searchFilter = 0;

        while (searchFilter < 1 || searchFilter > 7) {
            System.out.println();
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
            searchFilter = UserInputValidation.validateOption(1, 7);
        }
        return searchFilter;
    }

    public int adressFilterMenu() {
        int adressOption = 0;

        while (adressOption < 1 || adressOption > 3) {
            System.out.println();
            System.out.println("Selecione uma opção: ");
            System.out.println("""
                    
                    1. Rua
                    2. Número da casa
                    3. Cidade""");
            adressOption = UserInputValidation.validateOption(1, 3);
        }
        return adressOption;
    }

    public String searchValueValidation (int searchFilter) {
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
                int adressOption = adressFilterMenu();
                searchValue = adressValidation(adressOption);
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
        return searchValue;
    }

    public String adressValidation(int adressOption) {
        String searchValue;

        if (adressOption == 1) {
            searchValue = UserInputValidation.validateAdressStreet();
        } else if (adressOption == 2) {
            searchValue = UserInputValidation.validateAdressNumber();
        } else {
            searchValue = UserInputValidation.validateAdressCity();
        }
        return searchValue;
    }

    public ArrayList<File> createPetList() {
        File petsFolder = new File(FORM_FILE_PATH);

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
            filesList.sort(Comparator.comparing(File::getName));
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
                        if (removeAccents(line.toLowerCase()).contains(removeAccents(searchValue.toLowerCase()))) {
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

    public ArrayList<Integer> simplePetSearchIndexes(int searchFilter, String searchValue) {
        ArrayList<Integer> indexesMeetingCriteria = new ArrayList<>();
        ArrayList<File> allFilesList = createPetList();

        for (File file : allFilesList) {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                int counter = 0;
                while ((line = br.readLine()) != null) {
                    counter++;
                    if (counter == searchFilter) {
                        if (removeAccents(line.toLowerCase()).contains(removeAccents(searchValue.toLowerCase()))) {
                            indexesMeetingCriteria.add(Integer.valueOf(allFilesList.indexOf(file)));
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return indexesMeetingCriteria;
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
                        if (removeAccents(line.toLowerCase()).contains(removeAccents(searchValue2.toLowerCase()))) {
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

    public ArrayList<Integer> detailedPetSearchIndexes(int searchFilter1, String searchValue1, int searchFilter2, String searchValue2) {
        ArrayList<File> firstSearch = simplePetSearch(searchFilter1, searchValue1);
        ArrayList<File> allFilesList = createPetList();
        ArrayList<Integer> indexesMeetingCriteria = new ArrayList<>();

        for (File file : firstSearch) {
            try (FileReader fr = new FileReader(file);
                 BufferedReader br = new BufferedReader(fr)) {
                String line;
                int counter = 0;
                while ((line = br.readLine()) != null) {
                    counter++;
                    if (counter == searchFilter2) {
                        if (removeAccents(line.toLowerCase()).contains(removeAccents(searchValue2.toLowerCase()))) {
                            indexesMeetingCriteria.add(Integer.valueOf(allFilesList.indexOf(file)));
                        }
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return indexesMeetingCriteria;
    }

    public void formatSearchResult(ArrayList<File> filesMeetingCriteria) {
        ArrayList<String> formattedStrings = new ArrayList<>();
        int lineNumber = 1;
        String formattedSearch = "";
        String lineNumberString;

        if (filesMeetingCriteria == null || filesMeetingCriteria.isEmpty()) {
            return;
        }

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
        System.out.println();
        for (String formattedString : formattedStrings) {
            System.out.println(formattedString);
        }
    }

    public static String removeAccents(String s) {
        return Normalizer.normalize(s, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }
}