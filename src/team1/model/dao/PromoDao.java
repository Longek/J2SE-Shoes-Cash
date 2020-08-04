package team1.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import team1.model.Koneksi;

/**
 *
 * @author bayug
 */
public class PromoDao {
    Connection con;
    public PromoDao(){
        con = (new Koneksi()).getConnection();
    }
    
    public DefaultTableModel selectAllDataToTableModel(boolean show) {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Nama"); tableModel.addColumn("Tipe"); tableModel.addColumn("Diskon");
        tableModel.addColumn("Maks Diskon"); tableModel.addColumn("Min Pembelian"); tableModel.addColumn("Min Item"); tableModel.addColumn("Banyak Free");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM promo");
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
}


/**
 *  0. CRUD
 *  1. getID
 * 
 */