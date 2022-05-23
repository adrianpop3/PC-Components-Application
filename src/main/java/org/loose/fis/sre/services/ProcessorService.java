package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.exceptions.ProductAlreadyAdded;
import org.loose.fis.sre.products.graphic.GraphicObj;
import org.loose.fis.sre.products.processors.Processors;
import org.loose.fis.sre.products.processors.ProcessorsObj;

import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class ProcessorService {

    private static ObjectRepository<ProcessorsObj> ProcessorsRepository;
    private static Nitrite database;
    private static int i = 0;

    public static void initDataBaseProcessors() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("Processors.db").toFile())
                .openOrCreate("test", "test");
        ProcessorsRepository = database.getRepository(ProcessorsObj.class);
    }

    public static void closeDataBase() {
        database.close();
    }

    public static void display() {
        for (ProcessorsObj processorsObj : ProcessorsRepository.find()) {
            i++;
            Processors.displayProduct(processorsObj.getNumeProdus(), processorsObj.getPret(), processorsObj.getSpecific(), processorsObj.getDescriere(), processorsObj.getGarantie(), "b" + i);
        }
    }

    public static List<ProcessorsObj> getAllProccesors() {
        return ProcessorsRepository.find().toList();
    }

    public static void editProduct(String numeProdus, String Pret, String Specific, String Descriere, String Garantie) {
        for (ProcessorsObj processorsObj : ProcessorsRepository.find()) {
            if (numeProdus.equals(processorsObj.getNumeProdus())) {
                processorsObj.setPret(Pret);
                processorsObj.setSpecific(Specific);
                processorsObj.setDescriere(Descriere);
                processorsObj.setGarantie(Garantie);
                deleteProduct(numeProdus);
                ProcessorsRepository.insert(processorsObj);
            }
        }
    }

    public static void setForDelete() {
        for (ProcessorsObj processorsBase : ProcessorsRepository.find()) {
            if (UserService.returnId(HomePageController.getUsernameHome()) == processorsBase.getId()) {
                i++;
                PopUpController.getDataBase(processorsBase.getNumeProdus(), processorsBase.getPret(), processorsBase.getDescriere(), processorsBase.getSpecific(), processorsBase.getGarantie(), "b" + i);
            }
        }
    }

    public static void addProcessor(String numeProdus, String pret, String specific, String descriere, String garantie, int id) throws ProductAlreadyAdded {
        ErrorProductAlreadyAdded(numeProdus);
        ProcessorsRepository.insert(new ProcessorsObj(numeProdus, pret, specific, descriere, garantie, id));
    }

    public static void deleteProduct(String numeProdus) {
        for (ProcessorsObj processorsBase : ProcessorsRepository.find()) {
            if (numeProdus.equals(processorsBase.getNumeProdus())) {
                ProcessorsRepository.remove(ObjectFilters.eq("numeProdus", numeProdus));
            }
        }
    }

    public static int returnProductId(String productName) {
        for (ProcessorsObj processorsObj : ProcessorsRepository.find()) {
            if (Objects.equals(productName, processorsObj.getNumeProdus())) {
                return processorsObj.getId();
            }
        }
        return -1;
    }

    public static void ErrorProductAlreadyAdded(String nume) throws ProductAlreadyAdded {
        for(ProcessorsObj processorsObj:ProcessorsRepository.find())
        {
            if(Objects.equals(nume,processorsObj.getNumeProdus()))
            {
                throw new ProductAlreadyAdded(nume);
            }
        }
    }

}
