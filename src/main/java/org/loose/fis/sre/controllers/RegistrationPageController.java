package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class RegistrationPageController {
    @FXML
    private TextField username, password, passwordConfirmation;
    @FXML
    private Button registrationButton;
    @FXML
    private CheckBox termsCheckBox, passwordVisibility;
    @FXML
    private PasswordField hiddenPassword, hiddenPasswordConfirmation;
    @FXML
    private Hyperlink linkToLogin;
    @FXML
    private ComboBox roleComboBox;

    private Parent root;
    private Stage stage;

    public void handleRegistrationAction(ActionEvent event) throws Exception {
        // To be done
    }

    public void handlePasswordVisibilityAction() {
        // To be done
    }

    public void handleLinkToLoginAction(ActionEvent event) throws Exception {
        if (event.getSource() == this.linkToLogin) {
            this.stage = (Stage) this.linkToLogin.getScene().getWindow();
            // login page NOT implemented yet
            this.root = FXMLLoader.load(this.getClass().getResource("fxml/login_page.fxml"));
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Login Page");
            this.stage.setScene(scene);
            this.stage.show();
        }
    }

}