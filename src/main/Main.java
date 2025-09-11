package main;

import main.repository.FormRepository;

public class Main {
    public static void main(String[] args) {
        FormRepository.createStandardForm();
        FormRepository.readStringInFile();
    }
}
