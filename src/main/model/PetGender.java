package main.model;

public enum PetGender {
    MALE(1, "Macho"),
    FEMALE(2, "Fêmea");

    private final int ID;
    private final String GENDER_NAME;

    PetGender(int id, String GENDER_NAME) {
        this.ID = id;
        this.GENDER_NAME = GENDER_NAME;
    }

    public int getID() {
        return ID;
    }

    public String getGENDER_NAME() {
        return GENDER_NAME;
    }
}
