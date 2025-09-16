package main.model;

public class Pet {
    private PetName petName;
    private PetGender petGender;
    private PetType petType;
    private PetAdress petAdress;
    private String petAge;
    private String petWeight;
    private String petBreed;

    public Pet(PetName petName, PetType petType, PetGender petGender, PetAdress petAdress, String petAge, String petWeight, String petBreed) {
        this.petName = petName;
        this.petType = petType;
        this.petGender = petGender;
        this.petAdress = petAdress;
        this.petAge = petAge;
        this.petWeight = petWeight;
        this.petBreed = petBreed;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petName=" + petName +
                ", petGender=" + petGender +
                ", petType=" + petType +
                ", petAdress=" + petAdress +
                ", petAge='" + petAge + '\'' +
                ", petWeight='" + petWeight + '\'' +
                ", petBreed='" + petBreed + '\'' +
                '}';
    }
}
