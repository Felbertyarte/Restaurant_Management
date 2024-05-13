package restaurant.controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import restaurant.models.user;
import restaurant.models.user_model;
import restaurant.controllers.stuff_controller;

public class auth_controller {
    private user User;
    private user_model User_model;
    private FXMLLoader stuff_view;
    private AnchorPane stuff;
    stuff_controller Stuffcontroller;

    public auth_controller() {
        User_model = new user_model();
        User = new user();
    }

    void get_stuff_view_controller() {
        try {
            this.stuff_view = new FXMLLoader(getClass().getResource("/restaurant/views/stuff_view.fxml"));
            this.stuff = this.stuff_view.load();
            Stuffcontroller = this.stuff_view.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private Button login_btn;

    @FXML
    private TextField password_tf;

    @FXML
    private TextField username_tf;

    @FXML
    void login_btn_e(MouseEvent event) {
        user current_user = login();
        if (current_user != null) {
            Stuffcontroller.setStoreID(current_user.getStoreID());
        } else {
            System.out.println("Login Fail");
        }
    }

    user login() {
        try {
            ResultSet rs = User_model.login(username_tf.getText(), password_tf.getText());
            if (rs.next()) {
                User.setPersonID(rs.getInt("personID"));
                User.setUsertype(rs.getString("usertype"));
                User.setUsertypeID(rs.getInt("usertypeID"));
                User.setStoreID(rs.getInt("storeID"));
                User.setStorename(rs.getString("storename"));
                return User;

            } else {
                return null;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return User;

        }

    }

}
