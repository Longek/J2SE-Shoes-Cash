package team1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import team1.model.Koneksi;
import team1.model.Product;

/**
 *
 * @author bayug
 */
public class DetTransDao {
    Connection con;
    public DetTransDao(){
        con = (new Koneksi()).getConnection();
    }
    
    public String getStatToday(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT COUNT(id_trans), SUM(amount) FROM trans_detail JOIN transaction USING(id_trans) WHERE DATE(transaction.datetime)=CURDATE()");
            if(rs.next()){
                return (rs.getString(2)+" psg / "+rs.getString(1)+" trans");
            }else{
                return "0 psg / 0 trans";
            }
        } catch (SQLException ex) {
            return "0 psg / 0 trans";
        }
    }
    
    public DefaultTableModel selectAllDataToTableModel(boolean show) {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("Waktu"); tableModel.addColumn("Id Trans");tableModel.addColumn("Id Produk"); tableModel.addColumn("Sepatu"); 
        tableModel.addColumn("Ukuran"); tableModel.addColumn("Jumlah"); tableModel.addColumn("Harga Satuan"); tableModel.addColumn("Status");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM v_dettrans");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }

    public void insert(Product product) throws SQLException {
        String sql = "INSERT INTO products VALUES(?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getId());
        ps.setString(2, product.getBrand());
        ps.setString(3, product.getType());
        ps.setString(4, product.getDesc());
        ps.setInt(5, product.getSize());
        ps.setInt(6, product.getCapital());
        ps.setInt(7, product.getPrice());
        ps.setInt(8, product.getStok());
        ps.executeUpdate();
    }
    
    public void update(Product product) throws SQLException {
        String sql = "UPDATE products SET brand=?, type=?, descr=?, size=?, capital=?, price=?, stok=? "
                + " WHERE id_product=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(8, product.getId());
        ps.setString(1, product.getBrand());
        ps.setString(2, product.getType());
        ps.setString(3, product.getDesc());
        ps.setInt(4, product.getSize());
        ps.setInt(5, product.getCapital());
        ps.setInt(6, product.getPrice());
        ps.setInt(7, product.getStok());
        ps.executeUpdate();
    }
    
    public void delete(Product product) throws SQLException {
        String sql = "DELETE FROM products WHERE id_product=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, product.getId());
        ps.executeUpdate();
    }
    
    public String getShoesEmpty() throws SQLException{
        String out = "0";
        String sql = "SELECT COUNT(id_product) FROM products WHERE stock=0";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs= ps.executeQuery();
        if(rs.next()){
            out = rs.getString(1);
        }
        return out;
    }
    
    public DefaultTableModel searchByAllToTable(String word) throws SQLException{
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Brand | Tipe"); tableModel.addColumn("Des");
        tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga"); tableModel.addColumn("Stok");
        try {
//            String sql ="SELECT id_product, CONCAT(brand,' ',type), descr, size, price, stock FROM products WHERE id_product LIKE '%?%' OR "
//                    + "CONCAT(brand,' ',type) LIKE '%?%' OR descr LIKE '%?%'";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setString(1, word);
//            ps.setString(2, word);
//            ps.setString(3, word);
//            ResultSet rs = ps.executeQuery();
            ResultSet rs = con.createStatement().executeQuery("SELECT id_product, CONCAT(brand,' ',type), descr, size, price, stock FROM products WHERE id_product LIKE '%"+word+"%' OR "
                    + "CONCAT(brand,' ',type) LIKE '%"+word+"%' OR descr LIKE '%"+word+"%'");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
}


/**
 *  0. crud             | oke
 *  1. sepatu kosong , stok = 0 | oke
 *  2. mengurangi stok  | oke di trigger
 *  3. pencarian | oke
 */
