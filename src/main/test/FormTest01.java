package main.test;

import java.io.*;

public class FormTest01 {

    private static final String FILE_PATH = "C:\\Users\\felip\\IdeaProjects\\desafioCadastro\\src\\main\\test\\";
    private static final String FILE_NAME = "formulario.txt";

    public static void main(String[] args) {
        FormTest01.createStandardFormTest(FILE_PATH, FILE_NAME);
        FormTest01.readStringInFileTest(FILE_PATH, FILE_NAME);
    }

    public static void createStandardFormTest(String filePath, String fileName) {
        File file = new File(filePath, fileName);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("""
                    1 - Qual o nome e sobrenome do pet?
                    2 - Qual o tipo do pet (Cachorro/Gato)?
                    3 - Qual o sexo do animal?
                    4 - Qual endereço e bairro que ele foi encontrado?
                    5 - Qual a idade aproximada do pet?
                    6 - Qual o peso aproximado do pet?
                    7 - Qual a raça do pet?
                    """);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readStringInFileTest(String filePath, String fileName) {
        File file = new File(filePath, fileName);
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
