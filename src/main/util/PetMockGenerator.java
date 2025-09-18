package main.util;

import java.io.FileWriter;
import java.io.IOException;

public class PetMockGenerator {
    public static void main(String[] args) {
        String folderPath = "C:\\Users\\felip\\IdeaProjects\\desafioCadastro\\src\\main\\resources\\petsCadastrados\\";
        String[] nomes = {
                "Felipe Miguel", "Ana Clara", "Pedro Henrique", "Beatriz Souza", "Lucas Silva",
                "Mariana Lima", "Gabriel Costa", "Júlia Mendes", "Rafael Oliveira", "Larissa Alves",
                "Vinícius Martins", "Camila Ribeiro", "Bruno Rocha", "Isabela Duarte", "Matheus Almeida",
                "Carolina Teixeira", "Gustavo Fernandes", "Letícia Barros", "Samuel Gonçalves", "Amanda Freitas",
                "Thiago Pinto", "Natália Cardoso", "Leonardo Castro", "Sofia Pires", "Daniel Moreira",
                "Fernanda Assis", "Eduardo Vargas", "Paula Nunes", "Rodrigo Campos", "Gabriela Lopes"
        };
        String[] tipos = {"Cachorro", "Gato"};
        String[] sexos = {"Masculino", "Feminino"};
        String[] ruas = {
                "Rua das Flores", "Av. Brasil", "Alameda São João", "Rua Augusta",
                "Av. Atlântica", "Rua do Catete", "Av. Copacabana", "Rua Bela Vista",
                "Av. Central", "Rua Nova Era"
        };
        String[] cidades = {
                "Rio de Janeiro", "São Paulo", "Belo Horizonte", "Curitiba",
                "Porto Alegre", "Recife", "Salvador", "Fortaleza",
                "Brasília", "Manaus"
        };
        String[] racas = {
                "Rotweiller", "Persa", "Vira-lata", "Poodle", "Siamês",
                "Bulldog", "Golden Retriever", "Shih Tzu", "Labrador", "SRD"
        };

        for (int i = 0; i < 30; i++) {
            String fileName = folderPath + "pet" + (i + 1) + ".txt";
            String nome = nomes[i % nomes.length];
            // Mistura tipo e sexo a cada 5 pets
            String tipo = tipos[(i / 5) % tipos.length];
            String sexo = sexos[(i / 5 + i % 2) % sexos.length];
            String rua = ruas[i % ruas.length];
            String numero = (1 + i % 20) + (i % 2 == 0 ? "" : "A");
            String cidade = cidades[i % cidades.length];
            String endereco = rua + ", " + numero + ", " + cidade;
            // Alterna entre meses e anos
            String idade;
            if (i % 6 == 0) {
                int meses = (i % 12) + 1;
                idade = meses + (meses == 1 ? " mês" : " meses");
            } else {
                int anos = 1 + (i % 15);
                idade = anos + (anos == 1 ? " ano" : " anos");
            }
            String peso = String.format("%.1f", 1.0 + (i % 60)); // entre 1kg e 60kg
            String raca = racas[i % racas.length];

            try (FileWriter fw = new FileWriter(fileName)) {
                fw.write("1 - " + nome + "\n");
                fw.write("2 - " + tipo + "\n");
                fw.write("3 - " + sexo + "\n");
                fw.write("4 - " + endereco + "\n");
                fw.write("5 - " + idade + "\n");
                fw.write("6 - " + peso + "kg\n");
                fw.write("7 - " + raca + "\n");
            } catch (IOException e) {
                System.out.println("Erro ao criar arquivo " + fileName);
            }
        }
        System.out.println("Mock de 30 pets criado!");
    }
}