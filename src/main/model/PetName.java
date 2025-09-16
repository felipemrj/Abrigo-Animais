package main.model;

public class PetName {
    private String fullName;

    public PetName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return fullName;
    }
}
