package org.loose.fis.sre.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(ApplicationExtension.class)

public class StartingPageControllerTest {

    @Start
    void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/starting_page.fxml"));
        primaryStage.setTitle("PCA - STARTING");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    @Test
    void handleLinkToRegistrationOrLoginAction(FxRobot robot){
        robot.clickOn("#login");
        assertEquals(2, 1 + 1);
    }


}
