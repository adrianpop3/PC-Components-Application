package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.OrderService;

import java.util.ArrayList;
import java.util.List;

public class PopUpApproveDeclineController {

    public Button close;
    public AnchorPane CentralAnchor;
    private Stage stage;
    private static VBox vbox1 = new VBox();

    private static List<Text> numeProdus = new ArrayList<>();
    private static List<Text> cantitate = new ArrayList<>();
    private static List<Button> approve = new ArrayList<>();
    private static List<Button> decline = new ArrayList<>();
    private static Pane[] panel1 = new Pane[10];

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

    public void init() {
        vbox1=new VBox();
        initVBOX();
        CentralAnchor.getChildren().add(vbox1);
    }

    public void initialize(){
        initVBOX();
        init();
    }

    public static void displayOrders(String numeProduse,int cantitate1,String id1,String id2){
        System.out.println("test");
        for(int i=0;i<10;i++)
        {
            approve.add(i,new Button("Approve"));
            approve.get(i).setLayoutX(520);
            approve.get(i).setId(id1);
            approve.get(i).setStyle("-fx-background-color: #154a44; -fx-background-radius: 15px; -fx-text-fill: #8a6a57");
            decline.add(i,new Button("Decline"));
            decline.get(i).setLayoutX(460);
            decline.get(i).setId(id2);
            decline.get(i).setStyle("-fx-background-color: #A31010; -fx-background-radius: 15px; -fx-text-fill: #8a6a57");
        }

        Integer q = cantitate1;
        for(int i=0; i<10; i++){
            numeProdus.add(i,new Text(numeProduse));
            numeProdus.get(i).setLayoutX(0);
            numeProdus.get(i).setLayoutY(3);
            cantitate.add(i,new Text(Integer.toString(q)));
            cantitate.get(i).setLayoutY(3);
            cantitate.get(i).setLayoutX(100);
            panel1[i]= new Pane();
            panel1[i].setLayoutX(300);
            panel1[i].setLayoutY(50);
            panel1[i].getChildren().addAll(numeProdus.get(i),cantitate.get(i),approve.get(i),decline.get(i));
        }

        for (int i = 0; i < approve.size(); i++) {
            final int nr = i;
            approve.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for (int j = 0; j < numeProdus.size(); j++) {
                        if (nr == j) {
                            OrderService.SetStatusOrder(numeProdus.get(nr).getText(), "Approved");
                            decline.get(nr).setVisible(false);
                            approve.get(nr).setVisible(false);
                        }
                    }
                }
            });
        }

        for (int i = 0; i < decline.size(); i++) {
            final int nr = i;
            decline.get(i).setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for (int j = 0; j < numeProdus.size(); j++) {
                        if (nr == j) {
                            OrderService.SetStatusOrder(numeProdus.get(nr).getText(), "Declined");
                            decline.get(nr).setVisible(false);
                            approve.get(nr).setVisible(false);
                        }
                    }
                }
            });
        }

        vbox1.getChildren().add(panel1[PopUpController.getMaxNrProducts()]);
    }
}
