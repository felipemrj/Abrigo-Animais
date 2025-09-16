package main.model;

public class Pet {
    private PetName petName;
    private PetType petType;
    private PetGender petGender;
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
        return "1 - " + petName +
                "\n2 - " + petType +
                "\n3 - " + petGender +
                "\n4 - " + petAdress +
                "\n5 - " + formatAge() +
                "\n6 - " + petWeight + "kg" +
                "\n7 - " + petBreed;
    }

    public String formatAge() {
        try {
            double age = Double.parseDouble(petAge.replace(",", ".").trim());
            if (age < 1) {
                int months = (int) Math.round(age * 100);
                return months + (months == 1 ? " mês" : " meses");
            } else {
                int years = (int) age;
                return years + (years == 1 ? " ano" : " anos");
            }
        } catch (NumberFormatException e) {
            return petAge;
        }
    }
    public PetName getPetName() {
        return petName;
    }

}
