package main.model;

public class PetAdress {
    private String adressStreet;
    private int adressNumber;
    private String adressCity;

    public PetAdress(String adressStreet, int adressNumber, String adressCity) {
        this.adressStreet = adressStreet;
        this.adressNumber = adressNumber;
        this.adressCity = adressCity;
    }

    @Override
    public String toString() {
        return "PetAdress{" +
                "adressStreet='" + adressStreet + '\'' +
                ", adressNumber='" + adressNumber + '\'' +
                ", adressCity='" + adressCity + '\'' +
                '}';
    }

    public String getAdressStreet() {
        return adressStreet;
    }

    public void setAdressStreet(String adressStreet) {
        this.adressStreet = adressStreet;
    }

    public int getAdressNumber() {
        return adressNumber;
    }

    public void setAdressNumber(int adressNumber) {
        this.adressNumber = adressNumber;
    }

    public String getAdressCity() {
        return adressCity;
    }

    public void setAdressCity(String adressCity) {
        this.adressCity = adressCity;
    }
}
