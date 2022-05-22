package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.PopUpController;
import org.loose.fis.sre.products.graphic.Graphic;
import org.loose.fis.sre.products.graphic.GraphicObj;

import java.util.List;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class GraphicService {

    private static Nitrite database;
    private static ObjectRepository<GraphicObj> GraphicRepository;
    private static int i = 0;

    public static void initDataBaseGraphic() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("Graphic.db").toFile())
                .openOrCreate("test", "test");
        GraphicRepository = database.getRepository(GraphicObj.class);
    }

    public static void display() {
        for (GraphicObj graphicObj : GraphicRepository.find()) {
            i++;
            Graphic.displayProduct(graphicObj.getNumeProdus(), graphicObj.getPret(), graphicObj.getSpecific(), graphicObj.getDescriere(), graphicObj.getGarantie(), "b" + i);
        }
    }

    public static List<GraphicObj> getAllGraphicCards() {
        return GraphicRepository.find().toList();
    }

    public static void editProduct(String numeProdus, String Pret, String Specific, String Descriere, String Garantie) {
        for(GraphicObj graphicBase : GraphicRepository.find())
        {
            if (numeProdus.equals(graphicBase.getNumeProdus())) {
                graphicBase.setPret(Pret);
                graphicBase.setSpecific(Specific);
                graphicBase.setDescriere(Descriere);
                graphicBase.setGarantie(Garantie);
                deleteProduct(numeProdus);
                GraphicRepository.insert(graphicBase);
            }
        }
    }

    public static void setForDelete() {
        for (GraphicObj graphicBase : GraphicRepository.find()) {
            if (UserService.returnId(HomePageController.getUsernameHome()) == graphicBase.getId()) {
                i++;
                PopUpController.getDataBase(graphicBase.getNumeProdus(), graphicBase.getPret(), graphicBase.getSpecific(), graphicBase.getDescriere(), graphicBase.getGarantie(), "b" + i);
            }
        }
    }

    public static void addGraphic(String numeProdus, String pret, String specific, String descriere, String garantie, int id) {
        GraphicRepository.insert(new GraphicObj(numeProdus, pret, specific, descriere, garantie, id));
    }

    public static void deleteProduct(String numeProdus){
        for(GraphicObj graphicBase : GraphicRepository.find())
        {
            if(numeProdus.equals(graphicBase.getNumeProdus())){
                GraphicRepository.remove(ObjectFilters.eq("numeProdus",numeProdus));
            }
        }
    }

    public static int returnProductId(String productName) {
        for (GraphicObj graphicObj : GraphicRepository.find()) {
            if (Objects.equals(productName, graphicObj.getNumeProdus())) {
                return graphicObj.getId();
            }
        }
        return -1;
    }
}
