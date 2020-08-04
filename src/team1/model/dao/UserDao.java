package team1.model.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import team1.model.Koneksi;
import team1.model.Users;
import team1.resources.ConfigApp;

/**
 *
 * @author bayug
 */
public class UserDao {
    Connection con;
    public UserDao(){
        con = (new Koneksi().getConnection());
    }
    
    public boolean goLogin(String uname, String pass){
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users where uname='"+uname+"'and paswd=md5('"+pass+"')");
            if(rs.next()){
                ConfigApp cf = new ConfigApp();
                cf.setUnameAkun(rs.getString(1));
                cf.setNameAkun(rs.getString(3));
                cf.setLevelAkun(rs.getString(4));
                cf.setJkAkun(rs.getString(5));
                cf.writeConfig();
                return true;
            }else{
                return false;
            }
        } catch (SQLException ex) {
            return false;
        }
    }
    
    public DefaultTableModel selectAllDataToTableModel(boolean show) {
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("Username"); tableModel.addColumn("Nama"); tableModel.addColumn("Level"); tableModel.addColumn("Jk");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(3), rs.getString(4), rs.getString(5)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
    
    public DefaultTableModel searchByAllToTable1(String word) throws SQLException{
        DefaultTableModel tableModel = new DefaultTableModel(); tableModel.setRowCount(0); tableModel.setColumnCount(0);
        tableModel.addColumn("Username"); tableModel.addColumn("Nama"); tableModel.addColumn("Level"); tableModel.addColumn("Jk");
        try {
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM users WHERE uname LIKE '%"+word+"%' OR "
                    + "nama LIKE '%"+word+"%' OR lvl LIKE '%"+word+"%'");
            while (rs.next()) {
                Object[] data = {rs.getString(1), rs.getString(3), rs.getString(4), 
                    rs.getString(5)};
                tableModel.addRow(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return tableModel;
    }
}
