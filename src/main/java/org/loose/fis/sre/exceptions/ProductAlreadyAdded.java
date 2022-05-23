package org.loose.fis.sre.exceptions;

public class ProductAlreadyAdded extends Exception{

    private String numeP;

    public ProductAlreadyAdded(String nume) {
        super(String.format(nume));
        this.numeP = nume;
    }

    public String getName() {
        return numeP;
    }
}
