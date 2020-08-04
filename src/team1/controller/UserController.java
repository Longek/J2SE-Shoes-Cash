package team1.controller;

import java.sql.Connection;
import team1.model.Users;
import team1.model.dao.UserDao;
import team1.resources.ConfigApp;
import team1.view.Login;

/**
 *
 * @author bayug
 */
public class UserController {
    Login view;
    UserDao userDao;
//    Connection con;
    
    public UserController(Login view){
        this.view = view;
        userDao = new UserDao();
    }
    
    public boolean isLogin(){
        String u = view.getTxtUname().getText();
        String p = view.getTxtPass().getText();
        return (userDao.goLogin(u, p));
    }
}
