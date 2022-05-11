package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;

public class LoginPageController {

    @FXML
    private TextField password, username;
    @FXML
    private CheckBox passwordVisibility;
    @FXML
    private PasswordField hiddenPassword;
    @FXML
    private Button loginButton;

    private Parent root;
    private Stage stage;

    public void handleLoginAction() {
        // To be implemented
    }

    public void handlePasswordVisibilityAction() {
        // To be implemented
    }

    public void handleLinkToRegistrationAction(ActionEvent event) throws Exception {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("/fxml/registration_page.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("PCA - REGISTRATION");
        stage.setScene(scene);
        stage.show();
    }
}
