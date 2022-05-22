package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.TemporaryOrderService;

import java.util.ArrayList;
import java.util.List;

public class MyCartController {

    @FXML
    private AnchorPane anchorPane;
    private static VBox vBox = new VBox();
    private static Pane[] pane = new Pane[10];
    private static List<Text> name = new ArrayList<>(10);
    private static List<Text> quantity = new ArrayList<>(10);

    private Stage stage;

    @FXML
    private Button placeOrder, cancelOrder;

    @FXML
    public void initialize() {
        vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(50);

        anchorPane.getChildren().add(vBox);
    }

    public static void displayProducts(String productName, String productQuantity) {
        for (int i = 0; i < 10; i++) {

            // Name
            name.add(i, new Text(productName));
            name.get(i).setLayoutX(0);
            name.get(i).setLayoutY(3);

            // Quantity
            quantity.add(i, new Text(productQuantity));
            quantity.get(i).setLayoutY(3);
            quantity.get(i).setLayoutX(100);

            pane[i] = new Pane();
            pane[i].setLayoutX(300);
            pane[i].setLayoutY(50);
            pane[i].getChildren().addAll(name.get(i), quantity.get(i));

        }
        vBox.getChildren().add(pane[PopUpController.getMaxNrProducts()]);
    }

    public void handlePlaceOrderAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == placeOrder) {
            TemporaryOrderService.setNewOrder();
            TemporaryOrderService.removeFromDatabase(HomePageController.getUsernameHome());
            stage = (Stage) cancelOrder.getScene().getWindow();
            stage.close();
        }
    }

    public void handleCancelOrder() {
        // to be implemented
    }

}
