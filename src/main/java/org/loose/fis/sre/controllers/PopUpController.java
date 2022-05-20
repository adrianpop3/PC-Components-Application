package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import javafx.scene.text.Text;
import org.loose.fis.sre.services.ProcessorService;

import java.util.List;
import java.util.ArrayList;

public class PopUpController {

    @FXML
    public Pane panelProcessors1, panelGraphic1, panelRAM1, panelSSD_HDD1;
    public Button ClosePopUp1;
    public ComboBox comboBox1, comboBox2, comboBox3;
    private static VBox vBox = new VBox();

    private static int count=0;
    private static List<Button> buttons = new ArrayList<Button>();
    private static List<Text> numeProduse = new ArrayList<Text>(10);
    private static String nume;
    private Parent root;
    private static Text[] Pret= new Text[10];
    private static Text[] Descriere=new Text[10];
    private static Text[] Tip=new Text[10];
    private static Text[] Garantie=new Text[10];
    private static Pane[] panels = new Pane[10];


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

        if (comboBox1.getSelectionModel().getSelectedItem().toString().equals("Processors")) {
            count = 1;
            ProcessorService.setForDelete();

            for (int i=0; i<buttons.size(); i++) {
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
    }

    public void CloseEditPopUp(ActionEvent actionEvent) {
        Stage stage = (Stage) ClosePopUp1.getScene().getWindow();
        stage.close();
    }

    public static void getDataBase(String nume,String descriere,String pret,String tip,String garantie,String id){

        if(HomePageController.GetNr()==1)
        {
            for(int i=0; i<10; i++)
            {
                buttons.add(i,new Button("Edit"));
                buttons.get(i).setLayoutX(620);
                buttons.get(i).setId(id);
                buttons.get(i).setStyle("-fx-background-color: #8a6a57; -fx-background-radius: 15px; -fx-text-fill: #154a44");
            }
        }
        for(int i=0; i<10; i++)
        {
            numeProduse.add(i,new Text(nume));
            numeProduse.get(i).setLayoutX(0);;
            numeProduse.get(i).setLayoutY(3);;
            Pret[i] = new Text(pret);
            Descriere[i] = new Text(descriere);
            Tip[i] = new Text(tip);
            Garantie[i] = new Text(garantie);
            Pret[i].setLayoutX(80);
            Pret[i].setLayoutY(3);
            Descriere[i].setLayoutX(220);
            Descriere[i].setLayoutY(3);
            Tip[i].setLayoutX(320);
            Tip[i].setLayoutY(3);
            Garantie[i].setLayoutX(420);
            Garantie[i].setLayoutY(3);
            panels[i]=new Pane();
            panels[i].setLayoutX(700);
            panels[i].setLayoutY(50);
            panels[i].getChildren().addAll(numeProduse.get(i),Pret[i],Descriere[i],Tip[i],Garantie[i], buttons.get(i));
        }

    }

    public void addProduct(ActionEvent actionEvent) {
        //to be done
    }
}



