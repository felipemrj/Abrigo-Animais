package main.model;

public class Pet {
    private String petName;
    private PetGender petGender;
    private PetType petType;
    private PetAdress petAdress;
    private int petAge;
    private double petWeight;
    private String petBreed;

    public Pet() {

    }

    public Pet(String petName, PetGender petGender, PetType petType, PetAdress petAdress, int petAge, double petWeight, String petBreed) {
        this.petName = petName;
        this.petGender = petGender;
        this.petType = petType;
        this.petAdress = petAdress;
        this.petAge = petAge;
        this.petWeight = petWeight;
        this.petBreed = petBreed;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName='" + petName + '\'' +
                ", petGender=" + petGender +
                ", petType=" + petType +
                ", petAdress=" + petAdress +
                ", petAge=" + petAge +
                ", petWeight=" + petWeight +
                ", petBreed='" + petBreed + '\'' +
                '}';
    }
}
