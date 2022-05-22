package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.model.Order;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class OrderService {

    private static ObjectRepository<Order> orderObjectRepository;
    private static Nitrite database;

    public static void initDataBaseOrder() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("Order.db").toFile())
                .openOrCreate("test", "test");
        orderObjectRepository = database.getRepository(Order.class);
    }

    public static void addOrder(String sellerName, String customerName, String productName, int quantity, String status, int customerId, int orderId) {
        orderObjectRepository.insert(new Order(sellerName, customerName, productName, quantity, status, customerId, orderId));
    }

    public static void setApproveDecline(String numeSeller){
        //to be done
    }


}
