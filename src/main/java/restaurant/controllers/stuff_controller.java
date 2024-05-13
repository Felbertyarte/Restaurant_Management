package restaurant.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class stuff_controller {
    private int storeID;
    private FXMLLoader stuff_pos_view;
    stuff_pos_controller stuff_pos_controller;
    private AnchorPane stuff_pos_root;

    public stuff_controller() throws IOException {
        product_loading();
    }

    void product_loading() {

        try {
            this.stuff_pos_view = new FXMLLoader(getClass().getResource("/restaurant/views/stuff_pos.fxml"));
            stuff_pos_root = this.stuff_pos_view.load();
            stuff_pos_controller = this.stuff_pos_view.getController();
            stuff_pos_controller.init();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }

    @FXML
    private Pane stuff_page;

    @FXML
    void Order_e(MouseEvent event) {

    }

    @FXML
    void dashboard_e(MouseEvent event) {

    }

    @FXML
    void pos_e(MouseEvent event) throws SQLException {
        System.out.println("you click pos");
        stuff_page.getChildren().setAll(stuff_pos_root);
    }

    @FXML
    void table_e(MouseEvent event) {

    }
}