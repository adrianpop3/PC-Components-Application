package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class OrderStatusController {

    @FXML
    private Button closeButton;
    @FXML
    private AnchorPane anchorPane;
    private Stage stage = new Stage();

    private static VBox vBox = new VBox();
    private static Pane[] pane = new Pane[10];
    private static List<Text> productName = new ArrayList<>();
    private static List<Text> quantity = new ArrayList<>();
    private static List<Text> status = new ArrayList<>();

    @FXML
    public void initialize() {
        vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(50);

        anchorPane.getChildren().add(vBox);
    }

    public static void displayStatus(String numeProdus, String cantitate, String status_order) {
        for (int i = 0; i < 10; i++) {

            // Name
            productName.add(i, new Text(numeProdus));
            productName.get(i).setLayoutX(0);
            productName.get(i).setLayoutY(3);

            //Quantity
            quantity.add(i, new Text(cantitate));
            quantity.get(i).setLayoutX(100);
            quantity.get(i).setLayoutY(3);

            //Status
            status.add(i, new Text(status_order));
            status.get(i).setLayoutX(200);
            status.get(i).setLayoutY(3);

            pane[i] = new Pane();
            pane[i].setLayoutY(50);
            pane[i].setLayoutX(300);
            pane[i].getChildren().addAll(productName.get(i), quantity.get(i), status.get(i));

        }
        vBox.getChildren().add(pane[10]);
    }

    public void handleCloseAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == closeButton) {
            OrderService.deleteOrder();
        }
        stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
