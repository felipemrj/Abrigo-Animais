package main.util;

import main.exception.InvalidNameException;
import main.model.PetGender;
import main.model.PetType;

import java.util.Scanner;

public class UserInputValidation {
    static Scanner read = new Scanner(System.in);

    public static String validateName() {
        String name;
        while (true) {
            name = read.nextLine();
            try {
                String trimName = name.trim();
                if (!trimName.matches("[a-zA-Z ]+") || trimName.isEmpty()) {
                    throw new InvalidNameException("Não são permitidos caracteres especiais, nomes em branco ou números. Por favor digite um nome válido: ");
                } else {
                    return name;
                }
            } catch (InvalidNameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

//    public PetType validateType() {
//
//    }
//
//    public PetGender validateGender() {
//
//    }
//
//    public String validateAdressStreet() {
//
//    }
//
//    public int validateAdressNumber() {
//
//    }
//
//    public String validateAdressCity() {
//
//    }
//
//    public int validateAge() {
//
//    }
//
//    public double validateWeight() {
//
//    }
//
//    public String validateBreed() {
//
//    }
}
