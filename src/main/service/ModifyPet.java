package main.service;

import main.util.UserInputValidation;

import java.util.ArrayList;

public class ModifyPet {



    public int selectPet(ArrayList<Integer> foundPets) {
        int minValue = 1;
        int maxValue = foundPets.size();
        System.out.println("Insira o número do animal que deseja modificar os dados: ");
        return UserInputValidation.validateOption(minValue, maxValue);
    }
}
