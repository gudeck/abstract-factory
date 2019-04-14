/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author gudeck
 */
public class FabricaMySQL implements FabricaBancoDeDados {

    private static FabricaMySQL uniqueInstance;

    private FabricaMySQL() {

    }

    public static synchronized FabricaMySQL getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FabricaMySQL();
        }
        return uniqueInstance;
    }

    @Override
    public ProdutoConexao criaConexao() {
        return ProdutoMySQL.getInstance();
    }

}
