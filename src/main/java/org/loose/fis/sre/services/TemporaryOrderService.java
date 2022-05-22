package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.controllers.MyCartController;
import org.loose.fis.sre.model.TemporaryOrder;

import java.util.Random;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class TemporaryOrderService {

    private static ObjectRepository<TemporaryOrder> temporaryOrderObjectRepository;
    private static Nitrite database;

    public static void initDataBaseTemporaryOrder() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .filePath(getPathToFile("TemporaryOrder.db").toFile())
                .openOrCreate("test", "test");

        temporaryOrderObjectRepository = database.getRepository(TemporaryOrder.class);
    }

    public static void deleteProduct(String productName) {
        String name = "";
        for (TemporaryOrder temporaryOrder : temporaryOrderObjectRepository.find()) {
            if (temporaryOrder.getProductName().equals(productName)) {
                name = productName;
                break;
            }
        }
        temporaryOrderObjectRepository.remove(ObjectFilters.eq("productName", name));
    }

    public static boolean verifyProduct(String productName, String customerName) {
        for (TemporaryOrder temporaryOrder : temporaryOrderObjectRepository.find()) {
            if (temporaryOrder.getProductName().equals(productName)) {
                temporaryOrder.setQuantity();
                temporaryOrder.setCustomerName(customerName);
                deleteProduct(productName);
                temporaryOrderObjectRepository.insert(temporaryOrder);
                return true;
            }
        }
        return false;
    }

    public static void addTemporaryProduct(String sellerName, String customerName, String productName, int customerId) {
        temporaryOrderObjectRepository.insert(new TemporaryOrder(sellerName, customerName, productName, customerId));
    }

    public static void display(String customerName) {
        for (TemporaryOrder temporaryOrder : temporaryOrderObjectRepository.find()) {
            if (temporaryOrder.getCustomerName().equals(customerName)) {
                int quantity = temporaryOrder.getQuantity();
                MyCartController.displayProducts(temporaryOrder.getProductName(), Integer.toString(quantity));
            }
        }
    }

    public static boolean verifyCustomer(String customerName) {
        for (TemporaryOrder temporaryOrder : temporaryOrderObjectRepository.find()) {
            if (customerName.equals(temporaryOrder.getCustomerName())) {
                return true;
            }
        }
        return false;
    }

    public static void setNewOrder() {
        Random random = new Random();
        for (TemporaryOrder temporaryOrder : temporaryOrderObjectRepository.find()) {
            int random_next_1 = random.nextInt(1000);
            if (!UserService.verifyUserId(random_next_1)) {
                random_next_1 = random.nextInt(1000);
            }
            OrderService.addOrder(temporaryOrder.getSellerName(),temporaryOrder.getCustomerName(),temporaryOrder.getProductName(),
                    temporaryOrder.getQuantity(), "It is processing", temporaryOrder.getIdCustomer(), random_next_1);
        }
    }

    public static void removeFromDatabase(String customerName) {
        for (TemporaryOrder temporaryOrder : temporaryOrderObjectRepository.find()) {
            temporaryOrderObjectRepository.remove(ObjectFilters.eq("customerName", customerName));

        }
    }
}
