/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author 2017122760013
 */
public class MetodosUteis {

    public static java.sql.Date stringTOsqlDate(String data) throws ParseException {
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date javaDate = formatPattern.parse(data);
        java.sql.Date sqlDate = new java.sql.Date(javaDate.getTime());

        return sqlDate;
    }

    public static java.util.Date stringTOjavaDate(String data) throws ParseException {
        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date javaDate = formatPattern.parse(data);

        return javaDate;
    }

    public static java.sql.Date javaDateTOsqlDate(java.util.Date data) {
        return new java.sql.Date(data.getTime());
    }

    public static String javaDateTOstring(java.util.Date data) {

        SimpleDateFormat formatPattern = new SimpleDateFormat("dd/MM/yyyy");
        return formatPattern.format(data);
    }

}
