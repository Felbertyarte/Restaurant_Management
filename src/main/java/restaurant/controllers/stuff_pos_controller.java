package restaurant.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import restaurant.models.product;
import restaurant.models.product_model;

public class stuff_pos_controller {
    private String storename;
    private int storeID;
    private product_model productmodel;

    public stuff_pos_controller() throws SQLException, IOException {
        this.productmodel = new product_model();
    }

    @FXML
    private MenuButton category;

    @FXML
    private GridPane product_grid;

    @FXML
    private ScrollPane product_scroll;

    @FXML
    private TextField productsearch_tf;

    @FXML
    private Label store_name;

    public void init() {
        ResultSet rs = this.productmodel.retrieve_all_product();
        int row = 1;
        int column = 0;
        try {
            while (rs.next()) {
                product Product = new product();
                System.out.println(rs.getString("name"));

                // setting the product
                Product.setID(rs.getInt("ID"));
                Product.setName(rs.getString("name"));
                Product.setPrice(rs.getInt("price"));
                Product.setCategory_ID(rs.getInt("categoryID"));
                Product.setPicture("C:/Users/Administrator/Downloads/pizza-2.png");
                /// ---------------------------------------
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/restaurant/views/product_card.fxml"));
                AnchorPane product_card = fxmlLoader.load();
                product_card_controller productcardcontroller = fxmlLoader.getController();
                productcardcontroller.setdata(Product, 9);

                if (column == 4) {
                    column = 0;
                    row++;
                }

                // add the product card in grid
                this.product_grid.add(product_card, column++, row);

                GridPane.setMargin(product_card, new Insets(10));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}