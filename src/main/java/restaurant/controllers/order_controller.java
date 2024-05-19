package restaurant.controllers;

import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import restaurant.models.Invoice;
import restaurant.models.order;
import restaurant.models.product;

public class order_controller {

    private order Order;

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

    public void setdata(order Order) {
        this.Order = Order;
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
