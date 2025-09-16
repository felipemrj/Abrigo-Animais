package main.model;

public enum PetGender {
    MALE(1, "Masculino"),
    FEMALE(2, "Feminino");

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

    @Override
    public String toString() {
        return "PetGender{" +
                "ID=" + ID +
                ", GENDER_NAME='" + GENDER_NAME + '\'' +
                '}';
    }
}
