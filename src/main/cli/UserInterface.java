package main.cli;

import java.util.Scanner;

public class UserInterface {
    Scanner read = new Scanner(System.in);
    public int Menu(){
        int option = 0;
        while (option < 1 || option > 6) {
            System.out.print("""
                1. Cadastrar um novo pet
                2. Alterar os dados do pet cadastrado
                3. Deletar um pet cadastrado
                4. Listar todos os pets cadastrados
                5. Listar pets por algum critério (idade, nome, raça)
                6. Sair
                
                """);
            option = validateOption();
        }
        return option;
    }

    public int validateOption() {
        System.out.print("Escolha uma opção de 1 até 6: ");
        String option = read.nextLine();
        if (option.isEmpty()) {
            System.out.println("Entrada em branco, por favor escolha uma opção.");
            return 0;
        }
        try {
            int value = Integer.parseInt(option);
            if (value < 1 || value > 6) {
                System.out.println("Opção inválida, escolha de 1 até 6.");
                return 0;
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida, escolha de 1 até 6.");
            return 0;
        }
    }
}
