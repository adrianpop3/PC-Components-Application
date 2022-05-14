package org.loose.fis.sre.products.processors;

public class ProcessorsObj {

    private String numeProdus;
    private String pret;
    private String arhitectura;
    private String descriere;
    private String garantie;
    private int id;

    //Constructors:

    public ProcessorsObj() {}

    public ProcessorsObj (String numeProdus, String pret, String arhitectura, String descriere, String garantie, int id) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.arhitectura = arhitectura;
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

    public String getArhitectura() {
        return arhitectura;
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

    public void setArhitectura (String arhitectura) {
        this.arhitectura = arhitectura;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    @Override
    public String toString() {
        return numeProdus + " " + pret + " " + descriere + " " + garantie;
    }

}