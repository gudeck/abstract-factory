/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.*;
import domain.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 *
 * @author gudeck
 */
public class ControleDominio {

    private Connection conexao;
    private DAOCliente clienteDao;
    ArrayList<Cliente> listaClientes = new ArrayList();

    public ControleDominio() {
        conexao = Database.getConnection();
        clienteDao = new DAOCliente(conexao);

    }

    public void clienteCreate(String nome, String endereco, String email, String cpf, String dataNascimento, String telefone, char sexo) throws ParseException, SQLException {

        cpf = cpf.replace(".", "").replace("-", "");
        telefone = telefone.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");

        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date javaDate = formatPattern.parse(dataNascimento);
        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());

        clienteDao.create(nome, endereco, email, cpf, sqlDate, telefone, sexo);
    }

    public ArrayList clienteRead(String nome) throws SQLException {
        ResultSet resultadoPesquisa = clienteDao.read(nome);
        Cliente cliente;

        listaClientes.clear();
        while (resultadoPesquisa.next()) {
            cliente = new Cliente();
            cliente.setNome(resultadoPesquisa.getString("nome"));
            cliente.setCpf(resultadoPesquisa.getString("cpf"));
            cliente.setDataNascimento(resultadoPesquisa.getString("dataNascimento"));
            cliente.setSexo(resultadoPesquisa.getString("sexo").charAt(0));
            cliente.setEndereco(resultadoPesquisa.getString("endereco"));
            cliente.setEmail(resultadoPesquisa.getString("email"));

            listaClientes.add(cliente);

        }

        return listaClientes;

    }

    public ArrayList clienteConsulta(String nome, String endereco, String anoNascimento) throws SQLException {

        ResultSet resultadoPesquisa = clienteDao.consulta(nome, endereco, anoNascimento);
        Cliente cliente;
        String dia, mes, ano, data;

        listaClientes.clear();
        while (resultadoPesquisa.next()) {
            cliente = new Cliente();
            cliente.setNome(resultadoPesquisa.getString("nome"));
            cliente.setCpf(resultadoPesquisa.getString("cpf"));

            data = resultadoPesquisa.getString("dataNascimento");
            dia = data.substring(8, 10);
            mes = data.substring(5, 7);
            ano = data.substring(0, 4);
            cliente.setDataNascimento(dia + "/" + mes + "/" + ano);

            cliente.setSexo(resultadoPesquisa.getString("sexo").charAt(0));
            cliente.setEndereco(resultadoPesquisa.getString("endereco"));
            cliente.setTelefone(resultadoPesquisa.getString("telefone"));
            cliente.setEmail(resultadoPesquisa.getString("email"));

            listaClientes.add(cliente);

        }

        return listaClientes;

    }

}
