/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionregex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kaisher
 */
public class Filtro {
    //--- Patrones de busqueda de cada tipo-------//
    private static final String FILTRODNI ="\\d{8}[A-Z]";
    private static final String FILTROEMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    
    //--------Valida que se introduzcan solo numeros en el menu----------
    public boolean validarOpcion(String o){
        Pattern q=Pattern.compile("[0-9]");
        Matcher m=q.matcher(o);
        return m.find();
    } 
    //---   Validacion del Email  ------------------//
    public boolean ValidadorEmail(String email){
        Pattern pattern = Pattern.compile(FILTROEMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    //--------Validacion del DNI -----------------------//
    public boolean ValidarDni(String dni){
        
        Pattern pattern = Pattern.compile(FILTRODNI);
 
        Matcher matcher = pattern.matcher(dni);
        return matcher.matches();
    }
}
