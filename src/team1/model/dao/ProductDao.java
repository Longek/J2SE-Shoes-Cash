package team1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import team1.model.Koneksi;
import team1.model.Product;

/**
 *
 * @author bayug
 */
public class ProductDao {
    Connection con;
    public ProductDao(){
        con = (new Koneksi()).getConnection();
    }
    
    public DefaultTableModel selectAllDataToTableModel(boolean show) {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Brand"); tableModel.addColumn("Tipe"); tableModel.addColumn("Des");
        tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga Modal"); tableModel.addColumn("Harga Jual");
        tableModel.addColumn("Stok"); tableModel.addColumn("Update At");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM products ORDER BY updateAt Desc");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
    
    public DefaultTableModel showDataToTableModel(boolean show) {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu"); tableModel.addColumn("Deskripsi"); tableModel.addColumn("Size"); tableModel.addColumn("Harga"); tableModel.addColumn("Stok");tableModel.addColumn("Modal");
        try {
//            ResultSet rs = con.createStatement().executeQuery("SELECT id_product, CONCAT(brand,' ',type), descr, size, price, stock FROM products where stock>0");
              ResultSet rs = con.createStatement().executeQuery("SELECT * From v_sepatu");
          while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getString(6), rs.getString(7)};
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
    
    public String getShoesEmpty(){
        try {
            String sql = "SELECT COUNT(id_product) FROM products WHERE stock=0";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            if(rs.next()){
                return rs.getString(1);
            }
            return "0";
        } catch (SQLException ex) {
            Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            return "0";
        }
    }
    
    public DefaultTableModel searchByAllToTable(String word) throws SQLException{
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu"); tableModel.addColumn("Deskripsi"); tableModel.addColumn("Size"); tableModel.addColumn("Harga"); tableModel.addColumn("Stok"); tableModel.addColumn("Modal");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM v_sepatu WHERE"
                    + " id_product LIKE '%"+word+"%' OR sepatu LIKE '%"+word+"%' OR size LIKE '%"+word+"%'");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getString(6), rs.getString(6)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
    
    public DefaultTableModel searchByAllToTable1(String word) throws SQLException{
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Brand"); tableModel.addColumn("Tipe"); tableModel.addColumn("Des");
        tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga Modal");tableModel.addColumn("Harga Jual");
        tableModel.addColumn("Stok");  tableModel.addColumn("Update At");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM products WHERE id_product LIKE '%"+word+"%' OR "
                    + "brand LIKE '%"+word+"%' OR descr LIKE '%"+word+"%' OR type LIKE '%"+word+"%'  OR size LIKE '%"+word+"%'");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), 
                    rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)};
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
