/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Cliente;
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
        if (cpfConsulta(cpf) == 1) {
            throw new SQLException("CPF já cadastrado!");
        } else {

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

    }

    public ResultSet read(String nome) throws SQLException {

        ResultSet result;
        sql = "select * from cliente where nome like '" + nome + "%'";
        statement = conexao.prepareStatement(sql);
        result = statement.executeQuery();
        return result;
    }

    public void update(Cliente cliente) throws SQLException, SQLException {

        System.out.println("chegou aqui1");
        sql = "update cliente set nome = ?, "
                + "cpf = ?, "
                + "dataNascimento = ?, "
                + "sexo = ?, "
                + "endereco = ?, "
                + "telefone = ?, "
                + "email = ? "
                + "where codCliente = " + cliente.getCodCliente();
        statement = conexao.prepareStatement(sql);

        System.out.println("chegou aqui2");
        java.sql.Date sqlDate = new java.sql.Date(cliente.getDataNascimento().getTime());
        int coluna = 1;
        statement.setString(coluna++, cliente.getNome());
        statement.setString(coluna++, cliente.getCpf());
        statement.setDate(coluna++, sqlDate);
        statement.setString(coluna++, String.valueOf(cliente.getSexo()));
        statement.setString(coluna++, cliente.getEndereco());
        statement.setString(coluna++, cliente.getTelefone());
        statement.setString(coluna++, cliente.getEmail());

        System.out.println("chegou aqui3");
        statement.executeUpdate(sql);
        System.out.println("chegou aqui4");
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
            sql = sql + " and nome like '" + nome + "%'";
        }

        if (!endereco.isEmpty()) {
            sql = sql + " and endereco like '" + endereco + "%'";
        }

        if (!anoNascimento.equals("    ")) {
            sql = sql + " and year(dataNascimento) = " + anoNascimento;
        }

        result = statement.executeQuery(sql);

        return result;
    }

    public int cpfConsulta(String cpf) throws SQLException {

        ResultSet result;
        sql = "select count(*) from cliente where cpf like '" + cpf + "'";
        statement = conexao.prepareStatement(sql);
        result = statement.executeQuery(sql);
        if (result.next()) {
            return result.getInt(1);
        }
        else{
            return -1;
        }

    }

}
