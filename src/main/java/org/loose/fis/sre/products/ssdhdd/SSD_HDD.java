package org.loose.fis.sre.products.ssdhdd;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SSD_HDD {

    @FXML
    public Button back;

    @FXML
    public AnchorPane anchorPaneRight;

    private Stage stage;
    private Parent root;

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
