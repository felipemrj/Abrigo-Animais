package main.service;

import main.util.UserInputValidation;

import java.util.Scanner;

public class MainMenu {
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
            option = UserInputValidation.validateOption(1, 6);
        }
        return option;
    }
}
