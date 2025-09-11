package main.repository;

import java.io.*;

public class FormRepository {
    private static final String FILE_PATH = "C:\\Users\\felip\\IdeaProjects\\desafioCadastro\\src\\main\\resources\\";
    private static final String FILE_NAME = "formulario.txt";

    public static void createStandardForm() {
        File file = new File(FILE_PATH, FILE_NAME);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("""
                    1 - Qual o nome e sobrenome do pet?
                    2 - Qual o tipo do pet (Cachorro/Gato)?
                    3 - Qual o sexo do animal?
                    4 - Qual endereço e bairro que ele foi encontrado?
                    5 - Qual a idade aproximada do pet?
                    6 - Qual o peso aproximado do pet?
                    7 - Qual a raça do pet?""");
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStringInFile(int lineToPrint) {
        File file = new File(FILE_PATH, FILE_NAME);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            int counter = 0;
            while ((line = br.readLine()) != null) {
                counter++;
                if (counter == lineToPrint) {
                    System.out.println(line);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
