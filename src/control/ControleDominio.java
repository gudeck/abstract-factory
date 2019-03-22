/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author gudeck
 */
public class ControleDominio {
    
    private DAOCliente clienteDao;
    
    public ControleDominio(){
        clienteDao = new DAOCliente();
    }

    public void clienteCreate(String nome, String endereco, String email, String cpf, String dataNascimento, String telefone, char sexo) throws ParseException {

        cpf = cpf.replace(".", "").replace("-", "");
        telefone = telefone.replace("(", "").replace(")", "").replace(" ", "").replace("-", "");
        
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date javaDate = formatPattern.parse(dataNascimento);
        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());
        
        clienteDao.create(nome, endereco, email, cpf, sqlDate, telefone, sexo);
    }

}
