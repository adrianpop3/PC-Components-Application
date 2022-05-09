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
        if (this.passwordVisibility.isSelected()) {
            this.password.setText(this.hiddenPassword.getText());
            this.passwordConfirmation.setText(this.hiddenPasswordConfirmation.getText());
            this.password.setVisible(true);
            this.passwordConfirmation.setVisible(true);
            this.hiddenPassword.setVisible(false);
            this.hiddenPasswordConfirmation.setVisible(false);
        } else {
            this.hiddenPassword.setText(this.password.getText());
            this.hiddenPasswordConfirmation.setText(this.passwordConfirmation.getText());
            this.password.setVisible(false);
            this.passwordConfirmation.setVisible(false);
            this.hiddenPassword.setVisible(true);
            this.hiddenPasswordConfirmation.setVisible(true);
        }
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