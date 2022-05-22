package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.products.processors.Processors;
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
            Processors.displayProduct(ssd_hdd_obj.getNumeProdus(), ssd_hdd_obj.getPret(), ssd_hdd_obj.getSpecific(), ssd_hdd_obj.getDescriere(), ssd_hdd_obj.getGarantie(), "b" + i);
        }
    }

    public static void closeDataBase() {
        database.close();
    }

    public static List<SSD_HDD_Obj> getAllProduct() {
        return SSDHDDRepository.find().toList();
    }

    /*public static void EditProduct(String numeProdus,String Pret,String Specific,String Garantie,String Descriere) {
        for(SSD_HDD_Obj sourcesBase : SSDHDDRepository.find())
        {
            if (numeProdus.equals(sourcesBase.getNumeProdus())) {
                sourcesBase.setDescriere(Descriere);
                sourcesBase.setPret(Pret);
                sourcesBase.setGarantie(Garantie);
                sourcesBase.setSpecific(Specific);
                SSDHDDRepository.insert(sourcesBase);
            }
        }
    }*/

    public static void setForDelete() {
        for (SSD_HDD_Obj sourcesBase : SSDHDDRepository.find()) {
            if (UserService.returnId(HomePageController.getUsernameHome()) == sourcesBase.getId()) {
                i++;
                PopUpController.getDataBase(sourcesBase.getNumeProdus(), sourcesBase.getPret(), sourcesBase.getDescriere(), sourcesBase.getSpecific(), sourcesBase.getGarantie(), "b" + i);
            }
        }
    }

    public static void addSSDHDD(String numeProdus, String pret, String specific, String descriere, String garantie, int id) {
        SSDHDDRepository.insert(new SSD_HDD_Obj(numeProdus, specific, pret, descriere, garantie, id));
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
