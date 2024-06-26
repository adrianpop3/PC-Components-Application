package org.loose.fis.sre.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.loose.fis.sre.services.*;

import java.io.IOException;

import static org.loose.fis.sre.services.UserService.checkUserRole;

public class HomePageController {

    @FXML
    private Text welcomeMessage;

    private static String username;

    public static void setUsername(String userName) {
        username = userName;
    }

    public static String getUsernameHome() {
        return username;
    }

    @FXML
    private Button processors, graphic, ram, ssdhdd, add, delete, edit, myCart, approve, status, sellerHistory, customerHistory, logout;

    @FXML
    private Stage stage;
    private Parent root;
    private static int nr;

    public static int GetNr() {
        return nr;
    }

    public void handleLinkToCategoriesAction(ActionEvent actionEvent) throws Exception {

        if (actionEvent.getSource() == processors) {
            stage = (Stage) processors.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/pages/processors_page.fxml"));
            ProcessorService.display();
            stage.setTitle("PCA - PROCESSOR");
        }

        if (actionEvent.getSource() == graphic) {
            stage = (Stage) graphic.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/pages/graphic_page.fxml"));
            GraphicService.display();
            stage.setTitle("PCA - GRAPHIC CARD");
        }

        if (actionEvent.getSource() == ram) {
            stage = (Stage) ram.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/pages/ram_page.fxml"));
            RAMService.display();
            stage.setTitle("PCA - RAM");
        }

        if (actionEvent.getSource() == ssdhdd) {
            stage = (Stage) ssdhdd.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/pages/ssdhdd_page.fxml"));
            SSD_HDDService.display();
            stage.setTitle("PCA - SSD & HDD");
        }

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleLogOutAction(ActionEvent actionEvent) throws Exception {
        if (actionEvent.getSource() == logout) {
            stage = (Stage) logout.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/fxml/pages/login_page.fxml"));
        }

        stage.setTitle("PCA - LOGIN");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleAddProductAction(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == add) {
            nr = 2;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpAddProduct.fxml"));
        }

        stage.setTitle("PCA - ADD PRODUCT");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleDeleteProductAction(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == delete) {
            nr = 3;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpDeleteProduct.fxml"));
        }

        stage.setTitle("PCA - DELETE PRODUCT");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleEditProductAction(ActionEvent actionEvent) throws Exception {
        if (actionEvent.getSource() == edit) {
            nr = 1;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpEditProduct.fxml"));
        }

        stage.setTitle("PCA - EDIT PRODUCT");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleMyCartAction(ActionEvent actionEvent) throws IOException {
        if (actionEvent.getSource() == myCart) {
            nr = 6;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpMyCart.fxml"));
            if (TemporaryOrderService.verifyCustomer(HomePageController.getUsernameHome()))
                TemporaryOrderService.display(HomePageController.getUsernameHome());
        }

        stage.setTitle("PCA - MY CART");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleApproveDeclineOrderAction(ActionEvent actionEvent) throws IOException {
        if(actionEvent.getSource() == approve){
            nr=4;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpApproveDecline.fxml"));
            OrderService.setApproveDecline(HomePageController.getUsernameHome());
        }
        stage.setTitle("Approve/Decline order");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleOnViewStatusAction(ActionEvent actionEvent) throws Exception {
        if (actionEvent.getSource() == status) {
            nr = 7;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpOrderStatus.fxml"));
            OrderService.displayOrderStatus(HomePageController.getUsernameHome());
        }
        stage.setTitle("PCA - ORDER STATUS");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleOnSellerHistoryAction(ActionEvent actionEvent) throws Exception {
        if (actionEvent.getSource() == sellerHistory) {
            nr = 8;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpOrderHistorySeller.fxml"));
            FinalStatusService.displaySellerOrderHistory(HomePageController.getUsernameHome());
        }
        stage.setTitle("PCA - ORDER HISTORY");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void handleOnCustomerHistoryAction(ActionEvent actionEvent) throws Exception {
        if (actionEvent.getSource() == customerHistory) {
            nr = 8;
            stage = new Stage();
            root = FXMLLoader.load(getClass().getResource("/fxml/popUps/PopUpOrderHistoryCustomer.fxml"));
            FinalStatusService.displayCustomerOrderHistory(HomePageController.getUsernameHome());
        }
        stage.setTitle("PCA - ORDER HISTORY");
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void checkRoleForButtonVisibility() {
        if (checkUserRole(username).equals("Customer")) {
            add.setVisible(false);
            edit.setVisible(false);
            delete.setVisible(false);
            myCart.setVisible(true);
            approve.setVisible(false);
            status.setVisible(true);
            sellerHistory.setVisible(false);
            customerHistory.setVisible(true);
        } else {
            add.setVisible(true);
            edit.setVisible(true);
            delete.setVisible(true);
            myCart.setVisible(false);
            approve.setVisible(true);
            status.setVisible(false);
            sellerHistory.setVisible(true);
            customerHistory.setVisible(false);
        }
    }

    @FXML
    public void initialize() {
        welcomeMessage.setText("Glad to have you back, " + username + "!");
        checkRoleForButtonVisibility();
    }

}
