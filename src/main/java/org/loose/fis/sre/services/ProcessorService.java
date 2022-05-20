package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.products.processors.ProcessorsObj;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;


public class ProcessorService {

    private static ObjectRepository<ProcessorsObj> ProcessorsRepository;
    private static Nitrite database;
    private static int i = 0;

    public static void initDataBaseforProcessors() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("Processors.db").toFile())
                .openOrCreate("test", "test");
        ProcessorsRepository = database.getRepository(ProcessorsObj.class);
    }

    public static void setForDelete(){
        for(ProcessorsObj processorsBase : ProcessorsRepository.find())
        {
            if(UserService.returnId(HomePageController.getUsernameHome()) == processorsBase.getId()){
                i++;
                PopUpController.getDataBase(processorsBase.getNumeProdus(),processorsBase.getPret(),processorsBase.getDescriere(),processorsBase.getArhitectura(), processorsBase.getGarantie(),"b"+i);
            }
        }
    }


}