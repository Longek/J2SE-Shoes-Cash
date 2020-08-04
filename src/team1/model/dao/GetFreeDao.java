/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import team1.model.Koneksi;

/**
 *
 * @author bayug
 */
public class GetFreeDao {
    Connection con;
    public GetFreeDao(){
        con = (new Koneksi()).getConnection();
    }
    
    public DefaultTableModel selectAllDataToTableModel(String id) {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("ID"); tableModel.addColumn("Sepatu");  tableModel.addColumn("Ukuran"); tableModel.addColumn("Harga Jual");        
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM v_getfree WHERE id_promo='"+id+"';");
            while (rs.next()) {
                Object[] data = { rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
}
