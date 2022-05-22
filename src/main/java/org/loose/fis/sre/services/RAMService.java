package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.products.graphic.GraphicObj;
import org.loose.fis.sre.products.ram.RAMObj;

import java.util.List;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class RAMService {

    private static ObjectRepository<RAMObj> RAMRepository;
    private static Nitrite database;
    private static int i=0;

    public static void initDataBaseRAM(){
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("RAM.db").toFile())
                .openOrCreate("test", "test");
        RAMRepository= database.getRepository(RAMObj.class);
    }

    public static void closeDataBase(){
        database.close();
    }

    public static List<RAMObj> getAllProduct(){
        return RAMRepository.find().toList();
    }

    /*public static void EditProduct(String numeProdus,String Pret,String Specific,String Garantie,String Descriere) {
        for(RAMObj ramBase : RAMRepository.find())
        {
            if (numeProdus.equals(ramBase.getNumeProdus())) {
                ramBase.setDescriere(Descriere);
                ramBase.setPret(Pret);
                ramBase.setGarantie(Garantie);
                ramBase.setSpecific(Specific);;
                RAMRepository.insert(ramBase);
            }
        }
    }*/

    public static void setForDelete(){
        for(RAMObj ramBase : RAMRepository.find()){
            if(UserService.returnId(HomePageController.getUsernameHome())==ramBase.getId()){
                i++;
                PopUpController.getDataBase(ramBase.getNumeProdus(),ramBase.getPret(),ramBase.getDescriere(),ramBase.getSpecific(), ramBase.getGarantie(),"b"+i);
            }
        }
    }

    public static void addRAM(String numeProdus,String pret, String specific, String descriere, String garantie,int id) {
        RAMRepository.insert(new RAMObj(numeProdus, pret, specific, descriere,garantie,id));
    }

    public static int returnId(String numeProdus){
        for(RAMObj ramBase : RAMRepository.find())
        {
            if (numeProdus.equals(ramBase.getNumeProdus())) {
                return ramBase.getId();
            }
        }
        return  -1;
    }

}
