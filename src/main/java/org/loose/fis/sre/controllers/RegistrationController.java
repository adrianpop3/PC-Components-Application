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

import java.util.Random;

public class RegistrationPageController {
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField password;
    @FXML
    private TextField passwordConfirmation;
    @FXML
    private Button registerB;
    @FXML
    private CheckBox terms, news;
    @FXML
    private CheckBox hide;
    @FXML
    private PasswordField hidpas1;
    @FXML
    private PasswordField hidpas2;
    @FXML
    private Hyperlink gotoLOGIN;
    @FXML
    private ComboBox comboBox;
    private Parent root;
    private Stage stage;
    private Alert alert, alert1, alertUsername, alertPasswordIncorect;
    private static int id = 0;
    private Button myButton;


    public void SwitchPage(){
        System.out.println("Test");
    }

    public void ShowHide(){
        System.out.println("Test");
    }

    public void registerB(){
        System.out.println("Test");
    }
}
