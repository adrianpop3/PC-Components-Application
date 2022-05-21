package org.loose.fis.sre.products.ram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.controllers.HomePageController;

import java.util.ArrayList;
import java.util.List;

import static org.loose.fis.sre.services.UserService.checkUserRole;

public class RAM {

    @FXML
    public Button back;

    @FXML
    public AnchorPane anchorPaneRight;

    private static VBox vBox = new VBox();
    private static Pane[] pane = new Pane[10];
    private static List<Text> name = new ArrayList<>(10);
    private static List<Text> description = new ArrayList<>(10);
    private static List<Text> price = new ArrayList<>(10);
    private static List<Text> type = new ArrayList<>(10);
    private static List<Text> guaranty = new ArrayList<>(10);
    private static List<Button> button = new ArrayList<>(10);

    private Stage stage;
    private Parent root;

    @FXML
    public void initialize() {
        vBox = new VBox();
        vBox.setPadding(new Insets(10, 10, 10, 10));
        vBox.setSpacing(50);

        anchorPaneRight.getChildren().add(vBox);
    }

    public static void displayProduct(String nume, String pret, String tip, String descriere, String garantie, String id) {
        for (int i = 0; i < 10; i++) {
            // Name
            name.add(i, new Text(nume));
            name.get(i).setLayoutX(0);
            name.get(i).setLayoutY(3);

            // Price
            price.add(i, new Text(pret));
            price.get(i).setLayoutX(80);
            price.get(i).setLayoutY(3);

            // Description
            description.add(i, new Text(tip));
            description.get(i).setLayoutX(220);
            description.get(i).setLayoutY(3);

            // Type
            type.add(i, new Text(descriere));
            type.get(i).setLayoutX(320);
            type.get(i).setLayoutY(3);

            // Guaranty
            guaranty.add(i, new Text(garantie));
            guaranty.get(i).setLayoutX(420);
            guaranty.get(i).setLayoutY(3);

            // Add to cart button
            button.add(i, new Button("Add to cart"));
            button.get(i).setLayoutX(620);
            button.get(i).setStyle("-fx-background-color: #20B2AA; -fx-background-radius: 15px; -fx-text-fill: #ffffff");
            button.get(i).setId(id);

            // Hide visibility of buttons for seller
            if (checkUserRole(HomePageController.getUsernameHome()).equals("Seller"))
                button.get(i).setVisible(false);
            else
                button.get(i).setVisible(true);

            pane[i] = new Pane();
            pane[i].setLayoutX(700);
            pane[i].setLayoutY(50);
            pane[i].getChildren().addAll(name.get(i), price.get(i), description.get(i), type.get(i), guaranty.get(i), button.get(i));
        }

        // don't forget about the case when new products are added
        // don't forget about the implementation of the button add to cart
    }

    public void BackToHomePage(ActionEvent actionEvent) throws Exception {
        if (actionEvent.getSource() == back) {
            stage = (Stage) back.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/pages/home_page.fxml"));
            stage.setTitle("PCA - HOME");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
