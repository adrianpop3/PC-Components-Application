package org.loose.fis.sre.products.ssdhdd;

public class SSD_HDD_Obj {

    private String numeProdus;
    private String pret;
    private String capacitate;
    private String descriere;
    private String garantie;
    private int id;

    //Constructors:

    public SSD_HDD_Obj() {}

    public SSD_HDD_Obj (String numeProdus, String pret, String capacitate, String descriere, String garantie, int id) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.capacitate = capacitate;
        this.descriere = descriere;
        this.garantie = garantie;
        this.id = id;
    }

    //Getters:

    public String getNumeProdus() {
        return numeProdus;
    }

    public String getPret() {
        return pret;
    }

    public String getCapacitate() {
        return capacitate;
    }

    public String getDescriere() {
        return descriere;
    }

    public String getGarantie() {
        return garantie;
    }

    public int getId() {
        return id;
    }

    //Setters:

    public void setPret(String pret) {
        this.pret = pret;
    }

    public void setCapacitate(String capacitate) {
        this.capacitate = capacitate;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    @Override
    public String toString() {
        return numeProdus + " " + pret + " " + capacitate + " " + descriere + " " + garantie;
    }

}
