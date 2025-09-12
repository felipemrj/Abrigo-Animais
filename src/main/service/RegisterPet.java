package main.service;

import main.exception.InvalidNameException;
import main.model.Pet;
import main.model.PetAdress;
import main.model.PetGender;
import main.model.PetType;
import main.repository.FormRepository;
import main.util.UserInputValidation;

import java.sql.SQLOutput;
import java.util.Scanner;

public class RegisterPet {
    Scanner read = new Scanner(System.in);

    public Pet registerPet() {
        return new Pet(registerName(), registerGender(), registerType(), registerAdress(), registerPetAge(), registerPetWeight(), registerPetBreed());
    }

    public String registerName() {
        FormRepository.readStringInFile(1);
        return UserInputValidation.validateName();
    }

    public PetType registerType() {
        FormRepository.readStringInFile(2);
        String type = read.nextLine();
        if (type.equals(PetType.DOG.getTYPE_NAME())) {
            return PetType.DOG;
        }
        return PetType.CAT;
    }

    public PetGender registerGender() {
        FormRepository.readStringInFile(3);
        String gender = read.nextLine();
        if (gender.equals(PetGender.MALE.getGENDER_NAME())) {
            return PetGender.MALE;
        }
        return PetGender.FEMALE;
    }

    public PetAdress registerAdress() {
        FormRepository.readStringInFile(4);
        System.out.println("a. Rua: ");
        String street = read.nextLine();
        System.out.println("b. Número da casa: ");
        int number = read.nextInt();
        read.nextLine();
        System.out.println("c. Cidade: ");
        String city = read.nextLine();

        return new PetAdress(street, number, city);
    }

    public int registerPetAge() {
        FormRepository.readStringInFile(5);
        return read.nextInt();
    }

    public double registerPetWeight() {
        FormRepository.readStringInFile(6);
        return read.nextDouble();
    }

    public String registerPetBreed() {
        String eatGarbage = read.nextLine();
        FormRepository.readStringInFile(7);
        return read.nextLine();
    }

}
