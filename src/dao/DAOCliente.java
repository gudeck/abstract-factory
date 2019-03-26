/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author gudeck
 */
public class DAOCliente {

    private Connection conexao;

    public DAOCliente(Connection con) {
        conexao = con;
    }

    public void create(String nome, String endereco, String email, String cpf, Date dataNascimento, String telefone, char sexo) throws SQLException {

        PreparedStatement statement;
        String sql;
//                sql = "call create_cliente (?,?,?,?,?,?,?)";
        sql = "insert into cliente (nome, cpf, dataNascimento, sexo, endereco, telefone, email) values(?,?,?,?,?,?,?)";
        statement = conexao.prepareStatement(sql);
        statement.setString(1, nome);
        statement.setString(2, cpf);
        statement.setDate(3, dataNascimento);
        statement.setString(4, String.valueOf(sexo));
        statement.setString(5, endereco);
        statement.setString(6, telefone);
        statement.setString(7, email);
        statement.executeUpdate();

    }

    public ResultSet read(String nome) throws SQLException {
        PreparedStatement statement;
        String sql;
        ResultSet result = null;
//                sql = "call create_cliente (?,?,?,?,?,?,?)";
        sql = "select * from cliente where nome like '%" + nome + "%'";
        statement = conexao.prepareStatement(sql);
        result = statement.executeQuery();
        return result;
    }

    public void update(String nome, String endereco, String email, String cpf, Date sqlDate, String telefone, char sexo) {
        PreparedStatement statement;
        String sql;

        sql = "update cliente set 1 = 1 ";
        statement = conexao.prepareStatement(sql);
        
        if(!nome.isEmpty()){
            sql = sql + "and no"
        }
    }

    public ResultSet consulta(String nome, String endereco, String anoNascimento) throws SQLException {

        PreparedStatement statement;
        String sql;
        ResultSet result = null;

        sql = "select * from cliente where 1=1";
        statement = conexao.prepareStatement(sql);
        if (!nome.isEmpty()) {
            sql = sql + " and nome like '%" + nome + "%'";
        }

        if (!endereco.isEmpty()) {
            sql = sql + " and endereco like '%" + endereco + "%'";
        }

        if (!anoNascimento.equals("    ")) {
            sql = sql + " and year(dataNascimento) = " + anoNascimento;
        }

        result = statement.executeQuery(sql);

        return result;
    }

}
