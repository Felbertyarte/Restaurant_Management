package restaurant.controllers;

import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import restaurant.models.user;
import restaurant.models.user_model;

public class auth_controller {
    private user User;
    private user_model User_model;

    public auth_controller() {
        User_model = new user_model();
        User = new user();
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
            System.out.println("login succ");
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
                User.setStoreID(rs.getInt("storeID"));
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
