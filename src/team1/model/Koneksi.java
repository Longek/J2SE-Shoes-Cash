package team1.model;

import java.sql.Connection;
import javax.swing.JOptionPane;
import team1.resources.ConfigApp;

/**
 *f
 * @author bayug
 */
public class Koneksi {
    ConfigApp conf = new ConfigApp();
    
    private final String url = "jdbc:mysql://"+conf.getDbHost()+"/"+conf.getDbName();     // url database
    private final String uname = conf.getDbUname();                                  // username server mysql
    private final String pswd = conf.getDbPass();                                 // password server mysql
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");                 // name of driver
            return java.sql.DriverManager.getConnection(url, uname, pswd);
	} catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Gagal terkoneksi, tidak bisa dilanjutkan \n -> "+ex.getMessage().toString());
            ex.printStackTrace();
	}
        return null;
    }    
    
}
