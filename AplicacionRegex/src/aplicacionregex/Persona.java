/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionregex;

/**
 *
 * @author kaisher
 */
public class Persona implements Comparable<Persona>{
    //------------------ Atributos --------------------//
    private String nombre;
    private String dni;
    private String email;
    //------------------  CONSTRUCTORES ---------------///
    public Persona(){}
    public Persona(String nombre, String dni, String email){
        setNombre(nombre);
        setDni(dni);
        setEmail(email);
    }
    //-------------MEtodo para comparar usada en Registro---------/
        public int compareTo(Persona o) {
        int resultado=0;
            if (this.getDni().equals(o.getDni()))
                resultado = 1;
        return resultado;
       
    }
    
    //-------------  Inutil el que lo lea   --------------//
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setDni(String dni){
        this.dni=dni;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getNombre(){
        return this.nombre;
    }
    public String getDni(){
        return this.dni;
    }
    public String getEmail(){
        return this.email;
    }
    
    
}
