package main;

import main.service.*;
import main.repository.FormRepository;

public class Main {
    public static void main(String[] args) {
        FormRepository.createStandardForm();

        RegisterPet rp = new RegisterPet();
        ModifyPet mp = new ModifyPet();
        DeletePet dp = new DeletePet();
        SearchPet sp = new SearchPet();

        boolean runProgram = true;

        do {
            MainMenu ui = new MainMenu();
            int selectedOption = ui.Menu();

            switch (selectedOption) {
                case 1:
                    rp.registerPet();
                    break;
                case 2:
                    mp.modifyPet();
                    break;
                case 3:
                    dp.deletePet();
                    break;
                case 4:
                    sp.searchPet();
                    break;
                case 5:
                    runProgram = false;
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    break;
            }
        } while (runProgram);

    }
}
