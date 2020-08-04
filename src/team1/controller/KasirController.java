/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package team1.controller;

import java.sql.Connection;
import team1.model.Koneksi;
import team1.model.dao.DetTransDao;
import team1.view.Home;

/**
 *
 * @author bayug
 */
public class KasirController {
    Home view;
    DetTransDao detTransDao;
    
    Connection con;
    
    public KasirController(Home view){
        this.view = view;
        detTransDao = new DetTransDao();
        
        con = (new Koneksi()).getConnection();
        view.getTblDash().setModel(detTransDao.selectAllDataToTableModel(false));
        view.getLbl2WidDash1().setText(detTransDao.getStatToday());
    }
    
    public void loadData(){
        
    }
    
//    public void onSearch() throws SQLException{        
//        view.getjTable1().setModel(productDao.searchByAllToTable(view.getjTextField1().getText().toString()));
//    }
}
