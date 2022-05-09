package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class RegistrationPageController {
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordConfirmation;
    @FXML
    private Button registrationButton;
    @FXML
    private CheckBox termsCheckBox;
    @FXML
    private CheckBox hide;
    @FXML
    private PasswordField hiddenPassword;
    @FXML
    private PasswordField hiddenPasswordConfirmation;
    @FXML
    private Hyperlink linkToLogin;
    @FXML
    private ComboBox roleComboBox;

    public void handleRegistrationAction(ActionEvent event) throws Exception {
        // To be done
    }

    public void handlePasswordVisibilityAction() {
        // To be done
    }

    public void handleLinkToLoginAction(ActionEvent event) throws Exception {
        // To be done
    }
}