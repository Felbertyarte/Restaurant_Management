package restaurant.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import restaurant.db.database;

public class orders_model extends database {
    private PreparedStatement ps;

    public void create_orders() throws SQLException {
        String sql = "INSERT INTO `tbl_orders`(`invoiceID`, `product_orderID`) VALUES (?,?)";
        ps = getConnection().prepareStatement(sql);
        ps.setInt(1, 1);
        ps.setInt(2, 1);
        ps.executeUpdate();
        ps.close();
        getConnection().close();
    }

    // delete orders
    public void delete_orders(int product_order_ID) throws SQLException {
        String sql = "DELETE FROM `tbl_orders` WHERE `product_orderID`=?";
        ps = getConnection().prepareStatement(sql);
        ps.setInt(1, 1);
        ps.executeUpdate();
        ps.close();
        getConnection().close();

    }

    // retrieve all orders with invoice id
    public ResultSet retrieve_orders(int invoiceID) throws SQLException {
        String sql = "SELECT * FROM `tbl_orders` WHERE `invoiceID`=?";
        ps = getConnection().prepareStatement(sql);
        ps.setInt(1, invoiceID);
        ResultSet rs = ps.executeQuery();
        return rs;
    }
}
