package restaurant.models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import restaurant.db.database;

public class invoice_model extends database {
    private PreparedStatement ps;

    public void create_invoice(String costumer_name, boolean istakeout, int tableID, double discount, boolean ispaid)
            throws SQLException {
        String sql = "INSERT INTO `tbl_invoice`(`costumer_name`, `istakeout`, `tableID`, `discount`, `ispaid`) VALUES (?,?,?,?,?)";
        ps = getConnection().prepareStatement(sql);
        ps.setString(1, costumer_name);
        ps.setBoolean(2, istakeout);
        ps.setInt(3, tableID);
        ps.setDouble(4, discount);
        ps.setBoolean(5, ispaid);
        ps.executeUpdate();
        ps.close();
        getConnection().close();
    }

    public void invoice_set_paid(int invoiceID, boolean ispaid) {
        String sql = "UPDATE `tbl_invoice` SET `ispaid`=? WHERE `invoiceID`=?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setBoolean(1, ispaid);
            ps.setInt(2, invoiceID);
            ps.executeUpdate();
            ps.close();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void invoice_set_discount(int invoiceID, double discount) {
        String sql = "UPDATE `tbl_invoice` SET `discount`=? WHERE `invoiceID`=?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setDouble(1, discount);
            ps.setInt(2, invoiceID);
            ps.executeUpdate();
            ps.close();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // delete
    public void delete_invoice(int invoiceID) {
        String sql = "DELETE FROM `tbl_invoice` WHERE `invoiceID`=?";
        try {
            ps = getConnection().prepareStatement(sql);
            ps.setInt(1, invoiceID);
            ps.executeUpdate();
            ps.close();
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
