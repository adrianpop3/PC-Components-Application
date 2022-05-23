package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.exceptions.ProductAlreadyAdded;
import org.loose.fis.sre.products.processors.Processors;
import org.loose.fis.sre.products.ram.RAM;
import org.loose.fis.sre.products.ram.RAMObj;

import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class RAMService {

    private static ObjectRepository<RAMObj> RAMRepository;
    private static Nitrite database;
    private static int i = 0;

    public static void initDataBaseRAM() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("RAM.db").toFile())
                .openOrCreate("test", "test");
        RAMRepository = database.getRepository(RAMObj.class);
    }

    public static void display() {
        for (RAMObj ramObj : RAMRepository.find()) {
            i++;
            RAM.displayProduct(ramObj.getNumeProdus(), ramObj.getPret(), ramObj.getSpecific(), ramObj.getDescriere(), ramObj.getGarantie(), "b" + i);
        }
    }

    public static void closeDataBase() {
        database.close();
    }

    public static List<RAMObj> getAllProduct() {
        return RAMRepository.find().toList();
    }

    public static void editProduct(String numeProdus,String Pret,String Specific,String Garantie,String Descriere) {
        for(RAMObj ramObj : RAMRepository.find())
        {
            if (numeProdus.equals(ramObj.getNumeProdus())) {
                ramObj.setDescriere(Descriere);
                ramObj.setPret(Pret);
                ramObj.setGarantie(Garantie);
                ramObj.setSpecific(Specific);;
                deleteProduct(numeProdus);
                RAMRepository.insert(ramObj);
            }
        }
    }

    public static void setForDelete() {
        for (RAMObj ramBase : RAMRepository.find()) {
            if (UserService.returnId(HomePageController.getUsernameHome()) == ramBase.getId()) {
                i++;
                PopUpController.getDataBase(ramBase.getNumeProdus(), ramBase.getPret(), ramBase.getDescriere(), ramBase.getSpecific(), ramBase.getGarantie(), "b" + i);
            }
        }
    }

    public static void addRAM(String numeProdus, String pret, String specific, String descriere, String garantie, int id) throws ProductAlreadyAdded {
        ErrorProductAlreadyAdded(numeProdus);
        RAMRepository.insert(new RAMObj(numeProdus, pret, specific, descriere, garantie, id));
    }

    public static void deleteProduct(String numeProdus){
        for(RAMObj ramBase : RAMRepository.find()){
            if(numeProdus.equals(ramBase.getNumeProdus())){
                RAMRepository.remove(ObjectFilters.eq("numeProdus",numeProdus));
            }
        }
    }

    public static int returnProductId(String productName) {
        for (RAMObj ramObj : RAMRepository.find()) {
            if (Objects.equals(productName, ramObj.getNumeProdus())) {
                return ramObj.getId();
            }
        }
        return -1;
    }

    public static void ErrorProductAlreadyAdded(String nume) throws ProductAlreadyAdded {
        for(RAMObj ramObj:RAMRepository.find())
        {
            if(Objects.equals(nume,ramObj.getNumeProdus()))
                throw new ProductAlreadyAdded(nume);
            }
        }
    }
