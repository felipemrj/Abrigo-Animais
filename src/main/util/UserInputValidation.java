package main.util;

import main.exception.InvalidInputException;
import main.model.PetGender;
import main.model.PetType;

import java.util.Scanner;

public class UserInputValidation {
    static Scanner read = new Scanner(System.in);
    private static final String NOT_INFORMED = "NÃO INFORMADO";

    public static String validateName(String firstOrLastName) {
        String name;
        System.out.println("Digite o " + firstOrLastName + " do animal: ");
        while (true) {
            name = read.nextLine();
            String trimName = name.trim();
            if (trimName.isEmpty()) {
                return NOT_INFORMED;
            }
            try {
                if (!trimName.matches("[\\p{L}'-]+")) {
                    throw new InvalidInputException("Não são permitidos caracteres especiais ou números. Por favor digite um "+ firstOrLastName +" válido: ");
                }
                return name;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PetType validateType() {
        String type;
        System.out.println("Digite o tipo de animal (Cachorro ou Gato): ");
        while (true) {
            try {
                type = read.nextLine();
                String trimType = type.trim().toLowerCase();
                if (!trimType.equals("cachorro") && !trimType.equals("gato")) {
                    throw new InvalidInputException("Tipo inválido, escolha apenas entre \"cachorro\" ou \"gato\": ");
                }
                return trimType.equals("cachorro") ? PetType.DOG : PetType.CAT;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static PetGender validateGender() {
        String gender;
        System.out.println("Digite o sexo do animal (Masculino ou Feminino): ");
        while (true) {
            try {
                gender = read.nextLine();
                String trimGender = gender.trim().toLowerCase();
                if (!trimGender.equals("masculino") && !trimGender.equals("feminino")) {
                    throw new InvalidInputException("Sexo inválido, escolha apenas entre \"masculino\" ou \"feminino\": ");
                }
                return trimGender.equals("masculino") ? PetGender.MALE : PetGender.FEMALE;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validateAdressStreet() {
        String street;
        System.out.println("Digite o nome da rua/avenida (Exemplo: \"Rua das Flores\", \"Av. D'Ávila\", \"Alameda São João\"): ");
        while (true) {
            try {
                street = read.nextLine();
                String trimStreet = street.trim();
                if (!trimStreet.matches("[\\p{L}0-9 '-]+") || trimStreet.isEmpty()) {
                    throw new InvalidInputException("Endereço inválido, não são permitidos caracteres especiais. Por favor digite apenas o nome da rua/avenida:");
                }
                return street;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validateAdressNumber() {
        String number;
        System.out.println("Digite o número do endereço (Exemplo: \"12\", \"7A\", \"1024\"): ");
        while (true) {
            number = read.nextLine();
            if (number.isEmpty()) {
                return NOT_INFORMED;
            }
            try {
                if (!number.matches("[0-9A-Za-z]+") || number.isEmpty()) {
                    throw new InvalidInputException("Número de endereço inválido, não são permitidos caracteres especiais. Por favor digite o número correto, sem espaços: ");
                }
                return number;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validateAdressCity() {
        String city;
        System.out.println("Digite o nome da cidade (Exemplo: \"São Paulo\", \"Rio de Janeiro\", \"Nova Iguaçu\"): ");
        while (true) {
            try {
                city = read.nextLine();
                String trimCity = city.trim();
                if (!trimCity.matches("[\\p{L} '-]+") || trimCity.isEmpty()) {
                    throw new InvalidInputException("Nome de cidade inválido, não são permitidos caracteres especiais ou números. Por favor digite o nome correto da cidade: ");
                }
                return city;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validateAge() {
        String age;
        System.out.println("Digite a idade do pet (apenas números inteiros): ");
        while (true) {
            try {
                age = read.nextLine();
                if (age.isEmpty()) {
                    return NOT_INFORMED;
                }
                if (!age.matches("[0-9]+")) {
                    throw new InvalidInputException("Idade inválida, digite apenas números inteiros: ");
                }
                return age;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validateWeight() {
        String weight;
        System.out.println("Digite o peso do pet (apenas números): ");
        while (true) {
            try {
                weight = read.nextLine();
                if (weight.isEmpty()) {
                    return NOT_INFORMED;
                }
                if (!weight.matches("[0-9]+([.,][0-9]+)?")) {
                    throw new InvalidInputException("Peso inválido, digite apenas números, usando ponto ou vírgula para decimais: ");
                }
                weight = weight.replace(',', '.');
                return weight;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String validateBreed() {
        String breed;
        System.out.println("Digite a raça do pet:");
        while (true) {
            try {
                breed = read.nextLine();
                if (breed.isEmpty()) {
                    return NOT_INFORMED;
                }
                if (!breed.matches("[\\p{L} '-]+")) {
                    throw new InvalidInputException("Raça inválida, digite um nome válido para a raça do pet, usando letras, espaços, apóstrofo ou hífen: ");
                }
                return breed;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
