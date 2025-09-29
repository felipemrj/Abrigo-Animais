package main.repository;

import main.model.Pet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SaveDataRepository {
    private static final String PET_FILE_PATH = "src/main/resources/petsCadastrados";

    public static void createPetFile(Pet pet) {
        String fileName = formatDateTime() + "-" + formatFileName(pet);
        File file = new File(PET_FILE_PATH, fileName);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(pet.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String formatFileName(Pet pet) {
        return String.valueOf(pet.getPetName()).toUpperCase().replaceAll("\\s+", "") + ".txt";
    }

    public static String formatDateTime() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmm");
        return now.format(dtf);
    }

}
