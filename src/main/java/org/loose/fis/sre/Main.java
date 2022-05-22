package org.loose.fis.sre;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.loose.fis.sre.services.GraphicService;
import org.loose.fis.sre.services.ProcessorService;
import org.loose.fis.sre.services.TemporaryOrderService;
import org.loose.fis.sre.services.UserService;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        UserService.initDatabase();
        ProcessorService.initDataBaseProcessors();
        GraphicService.initDataBaseGraphic();
        TemporaryOrderService.initDataBaseTemporaryOrder();
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/pages/starting_page.fxml"));
        primaryStage.setTitle("PCA - START");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}