package main.service;

import java.util.Scanner;

public class SearchPet {
    Scanner read = new Scanner(System.in);
    public int searchPetMenu() {
        int option = 0;
        while (option != 1 && option != 2) {
            System.out.println("""
                    1. Busca simples (1 Critério)
                    2. Busca detalhada (2 Critérios)
                    """);
            option = validateOption();
        }
        return option;
    }

    public int validateOption() {
        System.out.print("Escolha uma opção (1 ou 2): ");
        String option = read.nextLine();
        if (option.isEmpty()) {
            System.out.println("Entrada em branco, por favor escolha uma opção.");
            return 0;
        }
        try {
            int value = Integer.parseInt(option);
            if (value != 1 && value != 2) {
                System.out.println("Opção inválida, escolha 1 ou 2.");
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida, escolha 1 ou 2.");
            return 0;
        }
    }

    public void simplePetSearch() {
        System.out.println("simple");
    }

    public void detailedPetSearch() {
        System.out.println("detailed");
    }
}
