package main;

import main.cli.UserInterface;
import main.repository.FormRepository;

public class Main {
    public static void main(String[] args) {
        FormRepository.createStandardForm();
        FormRepository.readStringInFile();

        UserInterface ui = new UserInterface();
        ui.Menu();
    }
}
