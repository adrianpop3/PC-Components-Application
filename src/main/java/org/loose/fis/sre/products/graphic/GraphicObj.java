package org.loose.fis.sre.products.graphic;

public class GraphicObj {

    private String numeProdus;
    private String pret;
    private String model;
    private String descriere;
    private String garantie;
    private int id;

    //Constructors:

    public GraphicObj() {}

    public GraphicObj (String numeProdus, String pret, String model, String descriere, String garantie, int id) {
        this.numeProdus = numeProdus;
        this.pret = pret;
        this.model = model;
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

    public String getModel() {
        return model;
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

    public void setModel(String model) {
        this.model = model;
    }

    public void setDescriere(String descriere) {
        this.descriere = descriere;
    }

    public void setGarantie(String garantie) {
        this.garantie = garantie;
    }

    @Override
    public String toString() {
        return numeProdus + " " + pret + " " + model + " " + descriere + " " + garantie;
    }

}
