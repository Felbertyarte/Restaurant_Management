package restaurant.models;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import restaurant.db.database;

public class product_order_model extends database {
    private PreparedStatement ps;

    public int create_product_order(int productID, int quantity) throws SQLException {
        String sql = "insert into tbl_product_order(productID,quantity)values(?,?)";
        ps = getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, productID);
        ps.setInt(2, quantity);
        ps.executeUpdate();

        ResultSet generate_key = ps.getGeneratedKeys();
        if (generate_key.next()) {
            return generate_key.getInt(1);
        }
        getConnection().close();
        ps.close();
        return 0;
    }

    public ResultSet get_sub_total(int product_order_ID) throws SQLException {
        String sql = """
                select (tbl_product.price * tbl_product_order.quantity) as sub_total
                from tbl_product_order
                inner join tbl_product on tbl_product_order.productID = tbl_product.ID
                where tbl_product_order.ID =?
                """;
        ps = getConnection().prepareStatement(sql);
        ps.setInt(1, product_order_ID);
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    public void delete_product_order(int product_order_ID) throws SQLException {
        String sql = "delete from tbl_product_order where ID =?";
        ps = getConnection().prepareStatement(sql);
        ps.setInt(1, product_order_ID);
        ps.executeUpdate();
        getConnection().close();
        ps.close();
    }

    public void update_product_order(int product_order_ID, int quantity) throws SQLException {
        String sql = "update tbl_product_order set quantity =? where ID =?";
        ps = getConnection().prepareStatement(sql);
        ps.setInt(1, quantity);
        ps.setInt(2, product_order_ID);
        ps.executeUpdate();
        getConnection().close();
        ps.close();
    }

}
