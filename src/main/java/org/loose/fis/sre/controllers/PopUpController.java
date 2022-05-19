package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

public class PopUpController {

    @FXML
    public Pane panelProcessors1, panelGraphic1, panelRAM1, panelSSD_HDD1;
    public Button ClosePopUp1;
    public ComboBox comboBox1, comboBox2, comboBox3;
    private static VBox vBox = new VBox();


    private void initializeVbox(){
        vBox.setPadding(new Insets(10,10,10,10));
        vBox.setSpacing(50);
    }

    @FXML
    private void initialize(){

        if(HomePageController.GetNr()==1) {
            comboBox1.getItems().add("Processors");
            comboBox1.getItems().add("RAM");
            comboBox1.getItems().add("Graphic Cards");
            comboBox1.getItems().add("SSD & HDD");
        }

        if(HomePageController.GetNr()==2){
            comboBox2.getItems().add("Processors");
            comboBox2.getItems().add("RAM");
            comboBox2.getItems().add("Graphic Cards");
            comboBox2.getItems().add("SSD & HDD");
        }

        if(HomePageController.GetNr()==3) {
            comboBox3.getItems().add("Processors");
            comboBox3.getItems().add("RAM");
            comboBox3.getItems().add("Graphic Cards");
            comboBox3.getItems().add("SSD & HDD");
        }
    }

    private void initializeEdit() {
        vBox=new VBox();
        initializeVbox();

        if(comboBox1.getSelectionModel().getSelectedItem().toString().equals("Processors")){
            panelProcessors1.getChildren().add(vBox);
            panelProcessors1.setVisible(true);
            panelGraphic1.setVisible(false);
            panelRAM1.setVisible(false);
            panelSSD_HDD1.setVisible(false);
        }
        if(comboBox1.getSelectionModel().getSelectedItem().toString().equals("Graphic Cards")){
            panelProcessors1.setVisible(false);
            panelGraphic1.getChildren().add(vBox);
            panelGraphic1.setVisible(true);
            panelRAM1.setVisible(false);
            panelSSD_HDD1.setVisible(false);

        }
        if(comboBox1.getSelectionModel().getSelectedItem().toString().equals("RAM")){
            panelProcessors1.setVisible(false);
            panelGraphic1.setVisible(false);
            panelRAM1.getChildren().add(vBox);
            panelRAM1.setVisible(true);
            panelSSD_HDD1.setVisible(false);
        }
        if(comboBox1.getSelectionModel().getSelectedItem().toString().equals("SSD & HDD")){
            panelProcessors1.setVisible(false);
            panelGraphic1.setVisible(false);
            panelRAM1.setVisible(false);
            panelSSD_HDD1.getChildren().add(vBox);
            panelSSD_HDD1.setVisible(true);
        }
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



