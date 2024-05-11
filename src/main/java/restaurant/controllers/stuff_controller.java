package restaurant.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class stuff_controller {
    private int storeID;
    private FXMLLoader stuff_pos_view;

    public stuff_controller() throws IOException {
        this.storeID = 1;
        this.stuff_pos_view = new FXMLLoader(getClass().getResource("/restaurant/views/stuff_pos.fxml"));
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
    void pos_e(MouseEvent event) {
        System.out.println("you click pos");
        try {
            AnchorPane stuff_pos_root = FXMLLoader.load(getClass().getResource("/restaurant/views/stuff_pos.fxml"));
            stuff_page.getChildren().setAll(stuff_pos_root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void table_e(MouseEvent event) {

    }
}