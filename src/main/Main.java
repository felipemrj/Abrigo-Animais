package main;

import main.service.MainMenu;
import main.model.Pet;
import main.repository.FormRepository;
import main.repository.SaveDataRepository;
import main.service.RegisterPet;
import main.service.SearchPet;

public class Main {
    public static void main(String[] args) {
        FormRepository.createStandardForm();

        RegisterPet rp = new RegisterPet();
        SearchPet sp = new SearchPet();

        MainMenu ui = new MainMenu();
        int selectedOption = ui.Menu();

        switch (selectedOption) {
            case 1:
                Pet pet = rp.createPet();
                SaveDataRepository.createPetFile(pet);
                break;
            case 2:
                System.out.println("Under development");
                break;
            case 3:
                System.out.println("Under development");
                break;
            case 4:
                System.out.println("Under development");
                break;
            case 5:
                if (sp.searchPetMenu() == 1) {
                    sp.simplePetSearch();
                    break;
                }
                sp.detailedPetSearch();
                break;
            case 6:
                System.out.println("Under development");
                return;
            default:
                System.out.println("Invalid");
                break;
        }
    }
}
