package restaurant.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import restaurant.models.product;

public class order_controller {

    private product Product;

    @FXML
    private ImageView delete_btn;

    @FXML
    private ImageView minus;

    @FXML
    private ImageView plus;

    @FXML
    private ImageView product_img;

    @FXML
    private Label product_name;

    @FXML
    private Label product_price;

    @FXML
    private Label qty;

    public void setdata(product Product, int qty) {
        this.Product = Product;
    }

    @FXML
    void delete_btn(MouseEvent event) {

    }

    @FXML
    void minus_btn(MouseEvent event) {

    }

    @FXML
    void plus_btn(MouseEvent event) {

    }

}
