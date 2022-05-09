package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class StartingPageController {

    @FXML
    private Button loginButton, registrationButton;
    private Parent root;
    private Stage stage;

    public void handleLinkToRegistrationOrLoginAction(ActionEvent event) throws Exception {
        if (event.getSource() == loginButton) {
            stage = (Stage) loginButton.getScene().getWindow();
            // login_page NOT implemented yet
            root = FXMLLoader.load(getClass().getResource("/fxml/login_page.fxml"));
            stage.setTitle("PCA - LOGIN");
        }
        if (event.getSource() == registrationButton) {
            stage = (Stage) registrationButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/registration_page.fxml"));
            stage.setTitle("PCA - REGISTRATION");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
