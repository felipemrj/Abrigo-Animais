package main.service;

import main.model.*;
import main.repository.FormRepository;
import main.repository.SaveDataRepository;
import main.util.UserInputValidation;

public class RegisterPet {

    public void registerPet() {
        RegisterPet rp = new RegisterPet();
        Pet pet = rp.createPet();
        SaveDataRepository.createPetFile(pet);
    }

    public Pet createPet() {
        return new Pet(registerName(), registerType(), registerGender(), registerAdress(), registerPetAge(), registerPetWeight(), registerPetBreed());
    }

    public PetName registerName() {
        FormRepository.readStringInFile(1);
        String firstName = UserInputValidation.validateName("nome");
        String lastName = UserInputValidation.validateName("sobrenome");
        return new PetName(firstName + " " + lastName);
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
    }

    public String registerPetAge() {
        FormRepository.readStringInFile(5);
        return UserInputValidation.validateAge();
    }

    public String registerPetWeight() {
        FormRepository.readStringInFile(6);
        return UserInputValidation.validateWeight();
    }

    public String registerPetBreed() {
        FormRepository.readStringInFile(7);
        return UserInputValidation.validateBreed();
    }

}
