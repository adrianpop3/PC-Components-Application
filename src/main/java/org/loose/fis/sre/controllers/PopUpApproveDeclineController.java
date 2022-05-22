package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PopUpApproveDeclineController {

    public Button close;
    public AnchorPane CentralAnchor;
    private Stage stage;
    private static VBox vbox1 = new VBox();

    public void ClosePopUpApproveDecline(ActionEvent actionEvent) {
        if(actionEvent.getSource() == close){
            stage = (Stage) close.getScene().getWindow();
            stage.close();
        }
    }

    private void initVBOX() {
        vbox1.setPadding(new Insets(10,10,10,10));
        vbox1.setSpacing(50);
    }

    public void initialize() {
        vbox1=new VBox();
        initVBOX();
        CentralAnchor.getChildren().add(vbox1);
    }
}
