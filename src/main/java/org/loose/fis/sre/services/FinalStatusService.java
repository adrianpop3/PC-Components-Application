package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.FinalStatus;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class FinalStatusService {

    private static ObjectRepository<FinalStatus> finalStatusObjectRepository;

    private static Nitrite database;

    public static void initDataBaseFinalStatus() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("Final.db").toFile())
                .openOrCreate("test", "test");

        finalStatusObjectRepository = database.getRepository(FinalStatus.class);
    }

    public static void addFinalOrder(String sellerName, String customerName, String productName, int quantity, String status) {
        finalStatusObjectRepository.insert(new FinalStatus(sellerName, customerName, productName, quantity, status));
    }
}
