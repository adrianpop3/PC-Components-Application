package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.products.processors.Processors;
import org.loose.fis.sre.products.processors.ProcessorsObj;
import java.util.List;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ProcessorService {

    private static ObjectRepository<ProcessorsObj> ProcessorsRepository;
    private static Nitrite database;
    private static int i=0;

    public static void initDataBaseProcessors(){
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("Processors.db").toFile())
                .openOrCreate("test", "test");
        ProcessorsRepository = database.getRepository(ProcessorsObj.class);
    }

    public static void closeDataBase(){
        database.close();
    }

    public static List<ProcessorsObj> getAllProccesors() {
        return ProcessorsRepository.find().toList();
    }

    /*public static void EditProduct(String numeProdus, String Pret, String Specific, String Descriere, String Garantie) {
        for(ProcessorsObj processorsBase : ProcessorsRepository.find())
        {
            if (numeProdus.equals(processorsBase.getNumeProdus())) {
                processorsBase.setPret(Pret);
                processorsBase.setSpecific(Specific);
                processorsBase.setDescriere(Descriere);
                processorsBase.setGarantie(Garantie);
                ProcessorsRepository.insert(processorsBase);
            }
        }
    }*/

    public static void setForDelete(){
        for(ProcessorsObj processorsBase : ProcessorsRepository.find())
        {
            if(UserService.returnId(HomePageController.getUsernameHome()) == processorsBase.getId()){
                i++;
                PopUpController.getDataBase(processorsBase.getNumeProdus(),processorsBase.getPret(),processorsBase.getDescriere(),processorsBase.getSpecific(), processorsBase.getGarantie(),"b"+i);
            }
        }
    }

    public static void addProcessor(String numeProdus, String pret, String specific, String descriere, String garantie, int id) {
        ProcessorsRepository.insert(new ProcessorsObj(numeProdus, pret, specific, descriere, garantie, id));
    }

    public static int returnId(String numeProdus){
        for(ProcessorsObj processorsBase : ProcessorsRepository.find())
        {
            if (numeProdus.equals(processorsBase.getNumeProdus())) {
                return processorsBase.getId();
            }
        }
        return  -1;

    }

}
