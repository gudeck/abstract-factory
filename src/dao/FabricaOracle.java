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
public class FabricaOracle implements FabricaBancoDeDados {

    private static FabricaOracle uniqueInstance;

    private FabricaOracle() {

    }

    public static synchronized FabricaOracle getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FabricaOracle();
        }
        return uniqueInstance;
    }

    @Override
    public ProdutoConexao criaConexao() {
        return ProdutoOracle.getInstance();
    }

}
