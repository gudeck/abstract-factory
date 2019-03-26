/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gudeck
 */
public class Database {

    private static final String DRIVER = ("com.mysql.jdbc.Driver");
//    private static final String DRIVER = ("com.mysql.cj.jdbc.Driver");
    private static final String IP = "localhost:3306";
    private static final String DBNAME = "bdprojetosistemas";
    private static final String URL = "jdbc:mysql://" + IP + "/" + DBNAME;
    //private static final String URL = "jdbc:mysql://" + IP + "/" + DBNAME + "?useTimezone=true&serverTimezone=UTC";
    private static final String LOGIN = "gustavo";
    private static final String SENHA = "+pao1234";

    public static Connection getConnection() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            return DriverManager.getConnection(URL, LOGIN, SENHA);
        } catch (SQLException erro) {
            System.out.println("Falha ao Conectar: " + erro.toString());
            return null;
        }
    }

}
