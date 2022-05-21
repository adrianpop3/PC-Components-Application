package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PopUpEditInfoController {

    @FXML
    public Button Confirm;
    public TextArea Name;
    public TextField Price, Specific, Description, Guarantee;

    public void CloseEditInfoPopUp(ActionEvent actionEvent) {
        Stage stage = (Stage) Confirm.getScene().getWindow();
        stage.close();
    }
}
