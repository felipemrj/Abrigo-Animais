package main.model;

public class PetAdress {
    private String adressStreet;
    private String adressNumber;
    private String adressCity;

    public PetAdress(String adressStreet, String adressNumber, String adressCity) {
        this.adressStreet = adressStreet;
        this.adressNumber = adressNumber;
        this.adressCity = adressCity;
    }

    @Override
    public String toString() {
        return adressStreet +", "+ adressNumber + ", " + adressCity;
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public String getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(String adressNumber) {
        this.adressNumber = adressNumber;
    }

    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }
}
