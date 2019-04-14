/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author gudeck
 */
public class ProdutoMySQL implements ProdutoConexao {

    private static ProdutoMySQL uniqueInstance;

    private ProdutoMySQL() {

    }

    public static synchronized ProdutoMySQL getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ProdutoMySQL();
        }
        return uniqueInstance;
    }

    private static final String DRIVER = ("com.mysql.cj.jdbc.Driver");
    private static final String IP = "localhost:3306";
    private static final String DBNAME = "bdprojetosistemas";
    private static final String URL = "jdbc:mysql://" + IP + "/" + DBNAME + "?useTimezone=true&serverTimezone=UTC";
    private static final String LOGIN = "gustavo";
    private static final String SENHA = "+pao1234";
//    private static final String LOGIN = "root";
//    private static final String SENHA = "";

    @Override
    public Connection getConnection() {

        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            return DriverManager.getConnection(URL, LOGIN, SENHA);
        } catch (SQLException erro) {
            System.out.println("Falha ao Conectar: " + erro.toString());
            return null;
        }
    }

}
