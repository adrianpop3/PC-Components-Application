package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.TemporaryOrder;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class TemporaryOrderService {

    private static ObjectRepository<TemporaryOrder> tempOrderRepository;
    private static Nitrite database;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("TemporaryOrder.db").toFile())
                .openOrCreate("test", "test");

        tempOrderRepository = database.getRepository(TemporaryOrder.class);
    }

    public static void closeDataBase() {
        database.close();
    }



}
