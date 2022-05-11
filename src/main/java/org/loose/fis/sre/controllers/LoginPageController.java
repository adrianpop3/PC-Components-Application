package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.loose.fis.sre.services.UserService;

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

    private Alert alertFieldEmpty = new Alert(Alert.AlertType.CONFIRMATION);
    private Alert alertUsernameOrPasswordIncorrect = new Alert(Alert.AlertType.ERROR);
    private Button myButton;

    public void handleLoginAction(ActionEvent event) throws Exception {
        alertFieldEmpty.setTitle("Field is empty");
        alertUsernameOrPasswordIncorrect.setTitle("Incorrect username or password");
        if (password.getText().isEmpty()) {
            password.setText(hiddenPassword.getText());
        }
        if (event.getSource() == loginButton) {
            if (username.getText().isEmpty() || password.getText().isEmpty()) {
                alertFieldEmpty.setHeaderText(null);
                alertFieldEmpty.setContentText("Field is empty!");
                myButton = (Button) alertFieldEmpty.getDialogPane().lookupButton(ButtonType.OK);
                myButton.setId("test");
                alertFieldEmpty.showAndWait();
                username.clear();
                password.clear();
                hiddenPassword.clear();
                return;
            }

            if (!UserService.verifyUsernamePassword(username.getText(), password.getText())) {
                alertUsernameOrPasswordIncorrect.setHeaderText(null);
                alertUsernameOrPasswordIncorrect.setContentText("Please try again!");
                myButton = (Button) alertUsernameOrPasswordIncorrect.getDialogPane().lookupButton(ButtonType.OK);
                myButton.setId("test");
                alertUsernameOrPasswordIncorrect.showAndWait();
                username.clear();
                password.clear();
                hiddenPassword.clear();
                return;
            }
            // NOT implemented yet add method for seller or customer
            stage = (Stage) loginButton.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/home_page.fxml"));
        }

        Scene scene = new Scene(root);
        stage.setTitle("PCA - HOME");
        stage.setScene(scene);
        stage.show();
    }

    public void handlePasswordVisibilityAction() {
        if (passwordVisibility.isSelected()) {
            password.setText(hiddenPassword.getText());
            password.setVisible(true);
            hiddenPassword.setVisible(false);
            hiddenPassword.setText(password.getText());
            return;
        }
        hiddenPassword.setText(password.getText());
        hiddenPassword.setVisible(true);
        password.setVisible(false);
        password.setText(hiddenPassword.getText());
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
