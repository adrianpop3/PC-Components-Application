package org.loose.fis.sre.services;

import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.dizitart.no2.objects.filters.ObjectFilters;
import org.loose.fis.sre.controllers.HomePageController;
import org.loose.fis.sre.controllers.OrderStatusController;
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

    public static void deleteOrder() {
        orderObjectRepository.remove(ObjectFilters.eq("status", "Accepted"));
        orderObjectRepository.remove(ObjectFilters.eq("status", "Declined"));
    }

    public static void addOrder(String sellerName, String customerName, String productName, int quantity, String status, int customerId, int orderId) {
        orderObjectRepository.insert(new Order(sellerName, customerName, productName, quantity, status, customerId, orderId));
    }

    public static void displayOrderStatus(String customerName) {
        for (Order order : orderObjectRepository.find()) {
            if (order.getCustomerName().equals(customerName)) {
                int orderQuantity = order.getQuantity();
                OrderStatusController.displayStatus(order.getProductName(), Integer.toString(orderQuantity), order.getStatus());

            }
        }
    }

    public static void replaceData() {
        for (Order order : orderObjectRepository.find()) {
            if (order.getCustomerName().equals(HomePageController.getUsernameHome())) {
                if (order.getStatus().equals("Accepted") || order.getStatus().equals("Declined")) {
                    FinalStatusService.addFinalOrder(order.getSellerName(), order.getCustomerName(), order.getProductName(), order.getQuantity(), order.getStatus());
                }
            }
        }
    }

}
