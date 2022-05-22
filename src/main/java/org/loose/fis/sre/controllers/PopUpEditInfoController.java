package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.loose.fis.sre.services.GraphicService;
import org.loose.fis.sre.services.ProcessorService;

public class PopUpEditInfoController {

    @FXML
    public Button Confirm;
    public TextArea Name;
    public TextField Price, Specific, Description, Guarantee;
    private Stage stage = new Stage();
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    public void CloseEditInfoPopUp(ActionEvent actionEvent) {
        if (Price.getText().isEmpty() || Specific.getText().isEmpty() || Description.getText().isEmpty() || Guarantee.getText().isEmpty()) {
            alert.setTitle("FIELD IS EMPTY");
            alert.setHeaderText(null);
            alert.setContentText("Please complete all the text fields");
            alert.showAndWait();
            return;
        }
        edit(PopUpController.returnNume());
        stage = (Stage) Confirm.getScene().getWindow();
        stage.close();
    }

    public void edit(String nume) {
        if (PopUpController.getCount() == 1) {
            ProcessorService.editProduct(nume, Price.getText(), Specific.getText(), Description.getText(), Guarantee.getText());
        }

        if (PopUpController.getCount() == 2) {
            GraphicService.editProduct(nume, Price.getText(), Specific.getText(), Description.getText(), Guarantee.getText());
        }

    }
}
