package main.model;

public class PetName {
    private String firstName;
    private String lastName;

    public PetName(String firstName) {
        this.firstName = firstName;
    }

    public PetName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "PetName{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
