package main.test;

import java.util.Scanner;

public class MenuTest01 {
    Scanner read = new Scanner(System.in);

    public static void main(String[] args) {
        MenuTest01 menu = new MenuTest01();

        menu.MenuTest();
    }

    public int MenuTest(){
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
            option = validateOptionTest();
        }
        return option;
    }

    public int validateOptionTest() {
        System.out.println("Escolha uma opção de 1 até 6: ");
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
            System.out.println("Opção inválida, digite apenas dígitos.");
            return 0;
        }
    }
}

