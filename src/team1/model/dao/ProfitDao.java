/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import team1.model.Koneksi;

/**
 *
 * @author bayug
 */
public class ProfitDao {
    DecimalFormat currencyIDR = (DecimalFormat) DecimalFormat.getCurrencyInstance();
    DecimalFormatSymbols formatRp = new DecimalFormatSymbols();
    Connection con;
    public ProfitDao(){
        con = (new Koneksi()).getConnection();
        
        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');
        currencyIDR.setDecimalFormatSymbols(formatRp);
    }
    
    public String getStatToday(){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT admission_fee_today FROM profit WHERE `profit`.`date`=CURDATE()");
            if(rs.next()){
                double penjualan = Double.parseDouble(rs.getString(1));
                return (currencyIDR.format(penjualan));
            }else{
                return (currencyIDR.format(0));
            }
        } catch (SQLException ex) {
            return (currencyIDR.format(0));
        }
    }
    
    public DefaultTableModel selectAllDataToTableModel() {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("No"); tableModel.addColumn("Tanggal"); tableModel.addColumn("Transaksi"); tableModel.addColumn("Total Transaksi");
        tableModel.addColumn("Terjual"); tableModel.addColumn("Total Terjual"); tableModel.addColumn("Uang Masuk");tableModel.addColumn("Total Uang Masuk");
        tableModel.addColumn("Modal");tableModel.addColumn("Pendapatan");tableModel.addColumn("Total Pendapatan");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM profit");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5) ,
                    rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
}
