package main;

import main.cli.UserInterface;
import main.model.Pet;
import main.repository.FormRepository;
import main.service.RegisterPet;

public class Main {
    public static void main(String[] args) {
        FormRepository.createStandardForm();
        RegisterPet rp = new RegisterPet();


        UserInterface ui = new UserInterface();
        int selectedOption = ui.Menu();

        switch (selectedOption) {
            case 1:
                Pet petTest = rp.registerPet();
                System.out.println(petTest);
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
                System.out.println("Under development");
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
