package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.*;

import java.util.List;
import java.util.ArrayList;

public class PopUpController {

    @FXML
    public Pane panelProcessors1, panelGraphic1, panelRAM1, panelSSD_HDD1, panelProcessors3, panelGraphic3, panelRAM3, panelSSD_HDD3;
    public Button ClosePopUp1;
    public ComboBox comboBox1, comboBox2, comboBox3;
    private static VBox vBox = new VBox();

    private static int count = 0;
    private static List<Button> buttons = new ArrayList<Button>();
    private static List<Text> numeProduse = new ArrayList<Text>(10);
    private static String nume;
    private Parent root;
    private static Text[] Pret = new Text[10];
    private static Text[] Descriere = new Text[10];
    private static Text[] Specific = new Text[10];
    private static Text[] Garantie = new Text[10];
    private static Pane[] panels = new Pane[10];

    @FXML
    private TextField numeProdus, pret, specific, descriere, garantie;
    private Stage stage = new Stage();
    @FXML
    private Button addit, CloseWindow, CloseWindow1, goback, confirmChange;
    private Alert alert = new Alert(Alert.AlertType.ERROR);

    private static int nrP = 0, nrG = 0, nrR = 0, nrM = 0;

    private void initializeVbox() {
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(50);
    }

    @FXML
    private void initialize() {

        if (HomePageController.GetNr() == 1) {
            comboBox1.getItems().add("Processors");
            comboBox1.getItems().add("RAM");
            comboBox1.getItems().add("Graphic Cards");
            comboBox1.getItems().add("SSD & HDD");
        }

        if (HomePageController.GetNr() == 2) {
            comboBox2.getItems().add("Processors");
            comboBox2.getItems().add("RAM");
            comboBox2.getItems().add("Graphic Cards");
            comboBox2.getItems().add("SSD & HDD");
        }

        if (HomePageController.GetNr() == 3) {
            comboBox3.getItems().add("Processors");
            comboBox3.getItems().add("RAM");
            comboBox3.getItems().add("Graphic Cards");
            comboBox3.getItems().add("SSD & HDD");
        }
    }

    private void initializeEdit() {
        vBox = new VBox();
        initializeVbox();

        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Processors")) {
            panelProcessors1.getChildren().add(vBox);
            panelProcessors1.setVisible(true);
            panelGraphic1.setVisible(false);
            panelRAM1.setVisible(false);
            panelSSD_HDD1.setVisible(false);
        }
        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Graphic Cards")) {
            panelProcessors1.setVisible(false);
            panelGraphic1.getChildren().add(vBox);
            panelGraphic1.setVisible(true);
            panelRAM1.setVisible(false);
            panelSSD_HDD1.setVisible(false);

        }
        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("RAM")) {
            panelProcessors1.setVisible(false);
            panelGraphic1.setVisible(false);
            panelRAM1.getChildren().add(vBox);
            panelRAM1.setVisible(true);
            panelSSD_HDD1.setVisible(false);
        }
        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("SSD & HDD")) {
            panelProcessors1.setVisible(false);
            panelGraphic1.setVisible(false);
            panelRAM1.setVisible(false);
            panelSSD_HDD1.getChildren().add(vBox);
            panelSSD_HDD1.setVisible(true);
        }
    }

    private void initializeDelete() {
        vBox = new VBox();
        initializeVbox();

        if (comboBox3.getSelectionModel().getSelectedItem().toString().equals("Processors")) {
            panelProcessors3.getChildren().add(vBox);
            panelProcessors3.setVisible(true);
            panelGraphic3.setVisible(false);
            panelRAM3.setVisible(false);
            panelSSD_HDD3.setVisible(false);
        }
        if (comboBox3.getSelectionModel().getSelectedItem().toString().equals("Graphic Cards")) {
            panelProcessors3.setVisible(false);
            panelGraphic3.getChildren().add(vBox);
            panelGraphic3.setVisible(true);
            panelRAM3.setVisible(false);
            panelSSD_HDD3.setVisible(false);

        }
        if (comboBox3.getSelectionModel().getSelectedItem().toString().equals("RAM")) {
            panelProcessors3.setVisible(false);
            panelGraphic3.setVisible(false);
            panelRAM3.getChildren().add(vBox);
            panelRAM3.setVisible(true);
            panelSSD_HDD3.setVisible(false);
        }
        if (comboBox3.getSelectionModel().getSelectedItem().toString().equals("SSD & HDD")) {
            panelProcessors3.setVisible(false);
            panelGraphic3.setVisible(false);
            panelRAM3.setVisible(false);
            panelSSD_HDD3.getChildren().add(vBox);
            panelSSD_HDD3.setVisible(true);
        }
    }

    public void initializeEditPopUp(ActionEvent actionEvent) {
        initializeEdit();

        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Processors")) {
            count = 1;
            ProcessorService.setForDelete();

            for (int i = 0; i < buttons.size(); i++) {
                final int nr = i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {

                    @Override
                    public void handle(ActionEvent event) {
                        for (int j = 0; j < numeProduse.size(); j++) {
                            if (nr == j) {
                                try {
                                    nume = numeProduse.get(nr).getText();
                                    Stage stage1 = new Stage();
                                    root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpEditInfo.fxml"));
                                    Scene scene = new Scene(root);
                                    stage1.setScene(scene);
                                    stage1.setTitle("Edit info about this product");
                                    stage1.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }

        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Graphic Cards")) {
            count = 2;
            GraphicService.setForDelete();
            for (int i = 0; i < buttons.size(); i++) {
                final int nr = i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for (int j = 0; j < numeProduse.size(); j++) {
                            if (nr == j) {
                                try {
                                    nume = numeProduse.get(nr).getText();
                                    Stage stage1 = new Stage();
                                    root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpEditInfo.fxml"));
                                    Scene scene = new Scene(root);
                                    stage1.setScene(scene);
                                    stage1.setTitle("Edit this product");
                                    stage1.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }

        if(comboBox1.getSelectionModel().getSelectedItem().toString().equals("RAM")) {
            count=3;
            RAMService.setForDelete();
            for (int i = 0; i < buttons.size(); i++) {
                final int nr = i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event){
                        for(int j=0;j<numeProduse.size();j++){
                            if(nr==j){
                                try {
                                    nume=numeProduse.get(nr).getText();
                                    Stage stage1=new Stage();
                                    root= FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpEditInfo.fxml"));
                                    Scene scene=new Scene(root);
                                    stage1.setScene(scene);
                                    stage1.setTitle("Edit this product");
                                    stage1.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }

        if(comboBox1.getSelectionModel().getSelectedItem().toString().equals("SSD & HDD")) {
            count=4;
            SSD_HDDService.setForDelete();
            for (int i = 0; i < buttons.size(); i++) {
                final int nr = i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event){
                        for(int j=0;j<numeProduse.size();j++){
                            if(nr==j){
                                try {
                                    nume=numeProduse.get(nr).getText();
                                    Stage stage1=new Stage();
                                    root= FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpEditInfo.fxml"));
                                    Scene scene=new Scene(root);
                                    stage1.setScene(scene);
                                    stage1.setTitle("Edit this product");
                                    stage1.show();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }

    }

    public void CloseEditPopUp(ActionEvent actionEvent) {
        Stage stage = (Stage) ClosePopUp1.getScene().getWindow();
        stage.close();
    }

    public void CloseDeletePopUp(ActionEvent actionEvent) {
        stage = (Stage) ClosePopUp1.getScene().getWindow();
        stage.close();
    }

    public static void getDataBase(String nume, String pret, String specific, String descriere, String garantie, String id) {

        if (HomePageController.GetNr() == 1) {
            for (int i = 0; i < 10; i++) {
                buttons.add(i, new Button("Edit it"));
                buttons.get(i).setLayoutX(620);
                buttons.get(i).setId(id);
                buttons.get(i).setStyle("-fx-background-color: #8a6a57; -fx-background-radius: 15px; -fx-text-fill: #154a44");
            }
        }
        if (HomePageController.GetNr() == 3) {
            for (int i = 0; i < 10; i++) {
                buttons.add(i, new Button("Delete it"));
                buttons.get(i).setLayoutX(620);
                buttons.get(i).setId(id);
                buttons.get(i).setStyle("-fx-background-color: #8a6a57; -fx-background-radius: 15px; -fx-text-fill: #154a44");
            }
        }
        for (int i = 0; i < 10; i++) {
            numeProduse.add(i, new Text(nume));
            numeProduse.get(i).setLayoutX(0);
            numeProduse.get(i).setLayoutY(3);
            Pret[i] = new Text(pret);
            Descriere[i] = new Text(descriere);
            Specific[i] = new Text(specific);
            Garantie[i] = new Text(garantie);
            Pret[i].setLayoutX(80);
            Pret[i].setLayoutY(3);
            Descriere[i].setLayoutX(220);
            Descriere[i].setLayoutY(3);
            Specific[i].setLayoutX(320);
            Specific[i].setLayoutY(3);
            Garantie[i].setLayoutX(420);
            Garantie[i].setLayoutY(3);
            panels[i] = new Pane();
            panels[i].setLayoutX(700);
            panels[i].setLayoutY(50);
            panels[i].getChildren().addAll(numeProduse.get(i), Pret[i], Specific[i], Descriere[i], Garantie[i], buttons.get(i));
        }

        vBox.getChildren().add(panels[PopUpController.getMaxNrProducts()]);

    }

    public void addProduct(ActionEvent event) {
        if (numeProdus.getText().isEmpty() || pret.getText().isEmpty() || specific.getText().isEmpty() || descriere.getText().isEmpty() || garantie.getText().isEmpty()) {
            alert.setTitle("Empty field found!");
            alert.setHeaderText((String) null);
            alert.setContentText("Please complete all the fields!");
            alert.showAndWait();
        } else {
            if (comboBox2.getSelectionModel().getSelectedItem().toString().equals("Processors")) {
                ProcessorService.addProcessor(numeProdus.getText(), pret.getText(), specific.getText(), descriere.getText(), garantie.getText(), UserService.returnId(HomePageController.getUsernameHome()));
                nrP++;
            }
            if (comboBox2.getSelectionModel().getSelectedItem().toString().equals("Graphic Cards")) {
                GraphicService.addGraphic(numeProdus.getText(), pret.getText(), specific.getText(), descriere.getText(), garantie.getText(), UserService.returnId(HomePageController.getUsernameHome()));
                nrG++;
            }
            if (comboBox2.getSelectionModel().getSelectedItem().toString().equals("RAM")) {
                RAMService.addRAM(numeProdus.getText(), pret.getText(), specific.getText(), descriere.getText(), garantie.getText(), UserService.returnId(HomePageController.getUsernameHome()));
                nrR++;
            }
            if (comboBox2.getSelectionModel().getSelectedItem().equals("SSD & HDD")) {
                SSD_HDDService.addSSDHDD(numeProdus.getText(), pret.getText(), specific.getText(), descriere.getText(), garantie.getText(), UserService.returnId(HomePageController.getUsernameHome()));
                nrM++;
            }

            stage = (Stage) addit.getScene().getWindow();
            stage.close();
        }
    }

    public void initializeDeletePopUp(ActionEvent event) {
        initializeDelete();

        if (comboBox3.getSelectionModel().getSelectedItem().toString().equals("Processors")) {
            ProcessorService.setForDelete();
            for (int i = 0; i < buttons.size(); i++) {
                final int nr = i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for (int j = 0; j < numeProduse.size(); j++) {
                            if (nr == j) {
                                ProcessorService.deleteProduct(numeProduse.get(j).getText());
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }
        if (comboBox3.getSelectionModel().getSelectedItem().toString().equals("Graphic Cards")) {
            GraphicService.setForDelete();
            for (int i = 0; i < buttons.size(); i++) {
                final int nr = i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for (int j = 0; j < numeProduse.size(); j++) {
                            if (nr == j) {
                                GraphicService.deleteProduct(numeProduse.get(j).getText());
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }

        if(comboBox3.getSelectionModel().getSelectedItem().toString().equals("RAM")){
            RAMService.setForDelete();
            for(int i=0; i<buttons.size(); i++){
                final int nr=i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for(int j=0; j<numeProduse.size(); j++){
                            if(nr == j){
                                RAMService.deleteProduct(numeProduse.get(j).getText());
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }

        if(comboBox3.getSelectionModel().getSelectedItem().toString().equals("SSD & HDD")){
            SSD_HDDService.setForDelete();
            for(int i=0; i<buttons.size(); i++){
                final int nr=i;
                buttons.get(i).setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        for(int j=0; j<numeProduse.size(); j++){
                            if(nr == j){
                                SSD_HDDService.deleteProduct(numeProduse.get(j).getText());
                                buttons.get(nr).setVisible(false);
                            }
                        }
                    }
                });
            }
        }
    }

    public static int getNrP() {
        return nrP;
    }

    public static int getNrG() {
        return nrG;
    }

    public static int getNrR() {
        return nrR;
    }

    public static int getNrM() {
        return nrM;
    }

    public static int getCount() {
        return count;
    }

    public static String returnNume() {
        return nume;
    }

    public static int getMaxNrProducts() {
        return Math.max(Math.max(nrG, nrP), Math.max(nrM, nrR));
    }
}
