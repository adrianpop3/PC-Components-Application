package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.products.processors.Processors;
import org.loose.fis.sre.products.ssdhdd.SSD_HDD;
import org.loose.fis.sre.products.ssdhdd.SSD_HDD_Obj;

import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class SSD_HDDService {
    private static ObjectRepository<SSD_HDD_Obj> SSDHDDRepository;
    private static Nitrite database;
    private static int i = 0;

    public static void initDataBaseSSDHDD() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("SSDHDD.db").toFile())
                .openOrCreate("test", "test");
        SSDHDDRepository = database.getRepository(SSD_HDD_Obj.class);
    }

    public static void display() {
        for (SSD_HDD_Obj ssd_hdd_obj : SSDHDDRepository.find()) {
            i++;
            SSD_HDD.displayProduct(ssd_hdd_obj.getNumeProdus(), ssd_hdd_obj.getPret(), ssd_hdd_obj.getSpecific(), ssd_hdd_obj.getDescriere(), ssd_hdd_obj.getGarantie(), "b" + i);
        }
    }

    public static void closeDataBase() {
        database.close();
    }

    public static List<SSD_HDD_Obj> getAllProduct() {
        return SSDHDDRepository.find().toList();
    }

    public static void editProduct(String numeProdus,String Pret,String Specific,String Garantie,String Descriere) {
        for(SSD_HDD_Obj ssdhddObj : SSDHDDRepository.find())
        {
            if (numeProdus.equals(ssdhddObj.getNumeProdus())) {
                ssdhddObj.setDescriere(Descriere);
                ssdhddObj.setPret(Pret);
                ssdhddObj.setGarantie(Garantie);
                ssdhddObj.setSpecific(Specific);
                deleteProduct(numeProdus);
                SSDHDDRepository.insert(ssdhddObj);
            }
        }
    }

    public static void setForDelete() {
        for (SSD_HDD_Obj ssdhddbase : SSDHDDRepository.find()) {
            if (UserService.returnId(HomePageController.getUsernameHome()) == ssdhddbase.getId()) {
                i++;
                PopUpController.getDataBase(ssdhddbase.getNumeProdus(), ssdhddbase.getPret(), ssdhddbase.getDescriere(), ssdhddbase.getSpecific(), ssdhddbase.getGarantie(), "b" + i);
            }
        }
    }

    public static void addSSDHDD(String numeProdus, String pret, String specific, String descriere, String garantie, int id) {
        SSDHDDRepository.insert(new SSD_HDD_Obj(numeProdus, specific, pret, descriere, garantie, id));
    }

    public static void deleteProduct(String numeProdus){
        for(SSD_HDD_Obj ssdhddObj : SSDHDDRepository.find())
        {
            if(numeProdus.equals(ssdhddObj.getNumeProdus())){
                SSDHDDRepository.remove(ObjectFilters.eq("numeProdus",numeProdus));
            }
        }
    }

    public static int returnProductId(String productName) {
        for (SSD_HDD_Obj ssd_hdd_obj : SSDHDDRepository.find()) {
            if (Objects.equals(productName, ssd_hdd_obj.getNumeProdus())) {
                return ssd_hdd_obj.getId();
            }
        }
        return -1;
    }

}
