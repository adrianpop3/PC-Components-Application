package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class PopUpController {

    @FXML
    public Pane panelProcessors1, panelGraphic1, panelRAM1, panelSSD_HDD1;
    public Button ClosePopUp1;
    public ComboBox comboBox1;

    private void initializeEdit() {
        //to be done
    }

    public void initializeEditPopUp(ActionEvent actionEvent) {
        initializeEdit();
        //to be done
    }

    public void CloseEditPopUp(ActionEvent actionEvent) {
        Stage stage = (Stage) ClosePopUp1.getScene().getWindow();
        stage.close();
    }
}



