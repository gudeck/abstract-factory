/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;

/**
 *
 * @author gudeck
 */
public class ProdutoOracle implements ProdutoConexao {

    private static ProdutoOracle uniqueInstance;

    private ProdutoOracle() {

    }

    public static synchronized ProdutoOracle getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new ProdutoOracle();
        }
        return uniqueInstance;
    }

    @Override
    public Connection getConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
