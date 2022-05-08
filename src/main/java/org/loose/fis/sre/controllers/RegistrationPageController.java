package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.loose.fis.sre.services.UserService;
import org.loose.fis.sre.model.User;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
// home_page NOT done yet

import java.util.Objects;

public class RegistrationPageController {

    @FXML
    private TextField username, password, passwordConfirmation;
    @FXML
    private Button registrationButton;
    @FXML
    private CheckBox termsCheckBox, passwordCheckBox;
    @FXML
    private PasswordField hiddenPasswordField, hiddenPasswordConfirmationField;
    @FXML
    private Hyperlink linkToLogin;
    @FXML
    private ComboBox roleComboBox;

    private Parent root;
    private Stage stage;
    private Alert alert, alert1, alertUsername, alertPasswordIncorect;
    private Button myButton;

    @FXML
    private void initialize() {
        roleComboBox.getItems().add("Customer");
        roleComboBox.getItems().add("Seller");
    }

    public void handleRegistrationAction(ActionEvent event) throws Exception {
        // To be done
    }

    public void handlePasswordVisibilityAction() {
        // To be done
    }

    public void handleLinkToLoginAction(ActionEvent event) throws Exception {
        if (event.getSource() == this.linkToLogin) {
            this.stage = (Stage) this.linkToLogin.getScene().getWindow();
            // login_page NOT done yet
            this.root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("fxml/login_page.fxml")));
            Scene scene = new Scene(this.root);
            this.stage.setTitle("PCA - LOGIN");
            this.stage.setScene(scene);
            this.stage.show();
        }

    }
}