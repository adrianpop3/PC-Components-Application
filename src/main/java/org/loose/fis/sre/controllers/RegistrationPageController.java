package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.services.UserService;

import java.util.Random;

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

    private Alert alertFieldEmpty, alertTermsConditions, alertUsernameExists, alertPasswordIncorect;
    private Button myButton;

    public RegistrationPageController() {
        this.alertFieldEmpty = new Alert(AlertType.ERROR);
        this.alertTermsConditions = new Alert(AlertType.ERROR);
        this.alertUsernameExists = new Alert(AlertType.ERROR);
        this.alertPasswordIncorect = new Alert(AlertType.ERROR);
    }

    @FXML
    private void initialize() {
        roleComboBox.getItems().add("Customer");
        roleComboBox.getItems().add("Seller");
    }

    public void handleRegistrationAction(ActionEvent event) throws Exception {
        this.alertFieldEmpty.setTitle("Field is empty");
        this.alertTermsConditions.setTitle("Terms & Conditions");
        boolean isMychoiceEmpty = roleComboBox.getSelectionModel().isEmpty();
        try {
            if (event.getSource() == this.registrationButton) {

                if (password.getText().isEmpty() && passwordConfirmation.getText().isEmpty()) {
                    password.setText(hiddenPassword.getText());
                    passwordConfirmation.setText(hiddenPasswordConfirmation.getText());
                }

                if (hiddenPassword.getText().isEmpty() && hiddenPasswordConfirmation.getText().isEmpty()) {
                    hiddenPassword.setText(password.getText());
                    hiddenPasswordConfirmation.setText(passwordConfirmation.getText());
                }

                if (!password.getText().equals(passwordConfirmation.getText())) {
                    alertPasswordIncorect.setHeaderText(null);
                    alertPasswordIncorect.setTitle("Passwords don't match");
                    alertPasswordIncorect.setContentText("Please check your password again!");
                    myButton = (Button) alertPasswordIncorect.getDialogPane().lookupButton(ButtonType.OK);
                    myButton.setId("test");
                    alertPasswordIncorect.showAndWait();
                    password.clear();
                    passwordConfirmation.clear();
                    hiddenPasswordConfirmation.clear();
                    hiddenPassword.clear();
                    return;
                }

                if (this.username.getText().isEmpty() ||
                        this.password.getText().isEmpty() ||
                        this.passwordConfirmation.getText().isEmpty() || isMychoiceEmpty) {
                    this.alertFieldEmpty.setHeaderText(null);
                    this.alertFieldEmpty.setContentText("Please fill in all text fields!");
                    myButton = (Button) alertFieldEmpty.getDialogPane().lookupButton(ButtonType.OK);
                    myButton.setId("test");
                    this.alertFieldEmpty.showAndWait();
                    return;
                }

                if (!this.termsCheckBox.isSelected()) {
                    this.alertTermsConditions.setHeaderText(null);
                    this.alertTermsConditions.setContentText("Please check the terms and conditions!");
                    myButton = (Button) alertTermsConditions.getDialogPane().lookupButton(ButtonType.OK);
                    myButton.setId("test");
                    this.alertTermsConditions.showAndWait();
                    return;
                }

                Random random = new Random();
                int userId;
                do {
                    userId = random.nextInt(1000);
                } while (UserService.verifyUserId(userId));

                UserService.addUser(username.getText(), password.getText(), roleComboBox.getSelectionModel().getSelectedItem().toString(), userId);
                this.stage = (Stage) this.registrationButton.getScene().getWindow();
                // home_page NOT implemented yet
                this.root = FXMLLoader.load(this.getClass().getResource("/fxml/home_page.fxml"));
                Scene scene = new Scene(this.root);
                this.stage.setTitle("CCP - HOME");
                this.stage.setScene(scene);
                this.stage.show();
            }

        } catch (UsernameAlreadyExistsException e) {
            alertUsernameExists.setTitle("The username " + e.getMessage() + " already exists!");
            alertUsernameExists.setHeaderText(null);
            alertUsernameExists.setContentText("Please choose another username!");
            myButton = (Button) alertUsernameExists.getDialogPane().lookupButton(ButtonType.OK);
            myButton.setId("test");
            alertUsernameExists.showAndWait();
            username.clear();
            password.clear();
            passwordConfirmation.clear();
            hiddenPasswordConfirmation.clear();
            hiddenPassword.clear();
        }
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
            this.root = FXMLLoader.load(this.getClass().getResource("/fxml/login_page.fxml"));
            Scene scene = new Scene(this.root);
            this.stage.setTitle("Login Page");
            this.stage.setScene(scene);
            this.stage.show();
        }
    }

}