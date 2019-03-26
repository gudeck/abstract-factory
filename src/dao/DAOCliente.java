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

    private final Connection conexao;
    private PreparedStatement statement;
    private String sql;

    public DAOCliente(Connection con) {
        conexao = con;
    }

    public void create(String nome, String endereco, String email, String cpf, Date dataNascimento, String telefone, char sexo) throws SQLException {

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

        ResultSet result;
        sql = "select * from cliente where nome like '%" + nome + "%'";
        statement = conexao.prepareStatement(sql);
        result = statement.executeQuery();
        return result;
    }

    public void update(int codigo, String nome, String endereco, String email, String cpf, Date dataNascimento, String telefone, char sexo) throws SQLException, SQLException {

        sql = "update cliente set codCliente = " + codigo;
        statement = conexao.prepareStatement(sql);
        
        if(nome != null || !nome.isEmpty()){
            sql = sql + ", nome = " + nome;
        }
        if(cpf != null || !cpf.isEmpty()){
            sql = sql + ", cpf = " + cpf;
        }
        if(dataNascimento != null){
            sql = sql + ", dataNascimento = " + dataNascimento;
        }
        if(sexo != '\0'){
            sql = sql + ", sexo = " + sexo;
        }
        if(endereco != null || !endereco.isEmpty()){
            sql = sql + ", endereco = " + endereco;
        }
        if(telefone != null || !telefone.isEmpty()){
            sql = sql + ", telefone = " + telefone;
        }
        if(email != null || !email.isEmpty()){
            sql = sql + ", email = " + email;
        }
        
        sql = sql + " where codCliente = " + codigo;
        
        statement.executeUpdate(sql);
        
    }

    public void delete(int codigo) throws SQLException {

        sql = "delete from cliente where codCliente = " + codigo;
        System.out.println(codigo);
        statement = conexao.prepareStatement(sql);
        statement.executeUpdate();

    }

    public ResultSet consulta(String nome, String endereco, String anoNascimento) throws SQLException {

        ResultSet result;

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
