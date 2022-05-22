package org.loose.fis.sre.products.ram;

public class RAMObj {

    private String numeProdus;
    private String pret;
    private String specific;
    private String descriere;
    private String garantie;
    private int id;

    //Constructors:

    public RAMObj() {}

    public RAMObj (String numeProdus, String pret, String specific, String descriere, String garantie, int id) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.specific = specific;
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

    public String getSpecific() {
        return specific;
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

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    @Override
    public String toString() {
        return numeProdus + " " + pret + " " + specific + " " + descriere + " " + garantie;
    }

}
