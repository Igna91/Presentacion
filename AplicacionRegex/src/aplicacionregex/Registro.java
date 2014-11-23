/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionregex;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author kaisher
 */
public class Registro {
    private ArrayList<Persona> p;
    private Scanner key;
    private Persona persona;
    
    public Registro(){
        p = new ArrayList<Persona>();
    }
    public void addPersona(Persona p){
        this.p.add(p);
    }
    
    //Lectura archivo Se implementara mas adelante una clase solo para ficheros--------//////
    
    public void load()throws IOException{
        try{
            FileReader fichero= new FileReader("reg.txt");
            Scanner key= new Scanner(fichero);
            while(key.hasNextLine()){
                String cad=key.nextLine();
                String[] aux=cad.split("-");
                persona= new Persona(aux[0],aux[1],aux[2]);
                if (!existe(persona))
                    addPersona(persona);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    
    //------------- Escritura en ficheros ---------------------//
    public void guardar()throws IOException{
        try{
            File a = new File("reg.txt");
            a.delete();
            a.createNewFile();
            FileWriter fichero=new FileWriter("reg.txt",false);
            PrintWriter pw= new PrintWriter(fichero);
                for(Persona per:p){
                    String cad=per.getNombre()+"-"+per.getDni()+"-"+per.getEmail();
                    pw.println(cad);
                }
            JOptionPane.showConfirmDialog(null,"Guardado..");
            fichero.flush();
            fichero.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    //Muestras todos los datos
    public void getRegistro(){
        for(Persona per:p){
            JOptionPane.showMessageDialog(null,per.getNombre()+"-"+per.getDni()+"-"+per.getEmail());
        }
    }
    // metodo para comparar declarada en Persona//
    public boolean existe(Persona p){
        int i=0;
        for(Persona per:this.p){
            if (i!=per.compareTo(p))
                return true;
        }
        return false;
    }
    public boolean esVacio(){
        return p.isEmpty();
    }
    
}
