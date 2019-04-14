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
public class FabricaPostgree implements FabricaBancoDeDados {

    private static FabricaPostgree uniqueInstance;

    private FabricaPostgree() {

    }

    public static synchronized FabricaPostgree getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new FabricaPostgree();
        }
        return uniqueInstance;
    }

    @Override
    public ProdutoConexao criaConexao() {
        return ProdutoPostgree.getInstance();
    }
}
