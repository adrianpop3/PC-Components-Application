package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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


    public void handleCloseAction(ActionEvent actionEvent) {
        if (actionEvent.getSource() == closeButton) {
            OrderService.deleteOrder();
        }
        stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


}
