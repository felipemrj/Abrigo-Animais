package main.model;

public enum PetType {
    DOG(1, "Cachorro"),
    CAT(2, "Gato");

    private final int ID;
    private final String TYPE_NAME;

    PetType(int id, String typeName) {
        this.ID = id;
        this.TYPE_NAME = typeName;
    }

    public int getID() {
        return ID;
    }

    public String getTYPE_NAME() {
        return TYPE_NAME;
    }

    @Override
    public String toString() {
        return "PetType{" +
                "ID=" + ID +
                ", TYPE_NAME='" + TYPE_NAME + '\'' +
                '}';
    }
}
