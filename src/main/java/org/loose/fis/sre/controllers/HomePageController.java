package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomePageController {

    @FXML
    private Text welcomeTxt;

    @FXML
    private Button processors, graphic, ram, ssdhdd, add, delete, edit, placeOrder, approve, status, sellerHistory, customerHistory, logout;

    @FXML
    private Stage stage;
    private Parent root;

    public void handleLinkToCategoriesAction(ActionEvent actionEvent) throws Exception {

        if(actionEvent.getSource() == processors){
            stage = (Stage) processors.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/processors_page.fxml")); //processors_page.fxml - to be done
            stage.setTitle("Processors");
        }

        if(actionEvent.getSource() == graphic){
            stage = (Stage) graphic.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/graphic.fxml")); //graphic.fxml - to be done
            stage.setTitle("Graphic Card");
        }

        if(actionEvent.getSource() == ram){
            stage = (Stage) ram.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/ram.fxml")); //ram.fxml - to be done
            stage.setTitle("RAM");
        }

        if(actionEvent.getSource() == ssdhdd){
            stage = (Stage) ssdhdd.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/ssdhdd.fxml")); //ssdhdd.fxml - to be done
            stage.setTitle("SSD & HDD");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleLogOutAction(ActionEvent actionEvent) throws Exception {
        //to be done
    }

    public void handleAddProductAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handleDeleteProductAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handleEditProductAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handlePlaceOrderAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handleApproveOrderAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handleOnViewStatusAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handleOnSellerHistoryAction(ActionEvent actionEvent) {
        //to be done
    }

    public void handleOnCustomerHistoryAction(ActionEvent actionEvent) {
        //to be done
    }
}
