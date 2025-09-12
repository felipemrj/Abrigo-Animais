package main.service;

import main.model.*;
import main.repository.FormRepository;
import main.util.UserInputValidation;

import java.util.Scanner;

public class RegisterPet {
    Scanner read = new Scanner(System.in);

    public Pet registerPet() {
        return new Pet(registerName(), registerType(), registerGender(), registerAdress(), registerPetAge(), registerPetWeight(), registerPetBreed());
    }

    public PetName registerName() {
        FormRepository.readStringInFile(1);
        String firstName = UserInputValidation.validateName("nome");
        String lastName = UserInputValidation.validateName("sobrenome");
        return new PetName(firstName, lastName);
        //adicionar não informado
    }


    public PetType registerType() {
        FormRepository.readStringInFile(2);
        return UserInputValidation.validateType();
    }

    public PetGender registerGender() {
        FormRepository.readStringInFile(3);
        return UserInputValidation.validateGender();
    }

    public PetAdress registerAdress() {
        FormRepository.readStringInFile(4);
        System.out.println("a. Rua: ");
        String street = UserInputValidation.validateAdressStreet();
        System.out.println("b. Número da casa: ");
        String number = UserInputValidation.validateAdressNumber();
        System.out.println("c. Cidade: ");
        String city = UserInputValidation.validateAdressCity();
        return new PetAdress(street, number, city);
        //adicionar não informado
    }

    public int registerPetAge() {
        FormRepository.readStringInFile(5);
        return UserInputValidation.validateAge();
        //adicionar não informado
    }

    public double registerPetWeight() {
        FormRepository.readStringInFile(6);
        return UserInputValidation.validateWeight();
        //adicionar não informado
    }

    public String registerPetBreed() {
        FormRepository.readStringInFile(7);
        return UserInputValidation.validateBreed();
        //adicionar não informado
    }

}
