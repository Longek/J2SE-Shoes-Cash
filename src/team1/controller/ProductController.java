package team1.controller;

import java.sql.Connection;
import java.sql.SQLException;
import team1.model.Koneksi;
import team1.model.dao.ProductDao;
import team1.view.ForTesting;

/**
 *
 * @author bayug
 */
public class ProductController {
    ForTesting view;
    ProductDao productDao;
    Connection con;
    
    public ProductController(ForTesting view){
        this.view = view;
        productDao = new ProductDao();
        con = (new Koneksi()).getConnection();
        view.getjTable1().setModel(productDao.selectAllDataToTableModel(false));
    }
    
    public void onSearch() throws SQLException{        
        view.getjTable1().setModel(productDao.searchByAllToTable(view.getjTextField1().getText().toString()));
    }
}
