
package aplicacionregex;

import javax.swing.JOptionPane;
import java.io.IOException;

/**
 *
 * @author kaisher
 */
public class AplicacionRegex {

  
    public static void main(String[] args) throws IOException {
        Registro reg=new Registro();
        String entrada;
        Persona p;
        Filtro f= new Filtro();
        for(;;){//-----funciona igual que un while para repeticion de menu-------
            entrada=JOptionPane.showInputDialog("1.Nuevo registro\n2.Cargar"
                    + " REgistros\n3.Mostrar Lista\n4. Guardar registro"
                    + "\n5.salir\nOpcion:");
            if(f.validarOpcion(entrada)){
                int num = Integer.parseInt(entrada);
                switch(num){
                    case 1:{
                        //------------insertar datos-------------------
                        String nombre=JOptionPane.showInputDialog("Ingrese: nombre");
                        String dni=JOptionPane.showInputDialog("Ingrese: Dni ");
                        String email=JOptionPane.showInputDialog("Ingrese: email");
                        p=new Persona(nombre,dni,email);
                            //---- Comprobacion de dni y email -------
                            //---- Salida mensaje de Cierto o falso segun introduzcas -----//
                        if (f.ValidarDni(dni) && f.ValidadorEmail(email)){
                            reg.addPersona(p);
                            reg.guardar();
                        }else{
                            JOptionPane.showMessageDialog(null,f.ValidarDni(dni)," DNI",JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(null,f.ValidadorEmail(email)," Email",JOptionPane.WARNING_MESSAGE);
                            JOptionPane.showMessageDialog(null,"No se han introducido correctamente los datos por lo tanto se omitiran...."," ERROR",JOptionPane.WARNING_MESSAGE); 
                        }

                        
                    }break;
                    case 2:{
                        //-----------leer de fichero y mostrar-------------------
                        reg.load();
                        reg.getRegistro();
                    }break;
                    case 3:{
                        //-----------mostrar datos--------------
                        reg.getRegistro();
                    }break;
                    case 4:{
                        //------------------Guardar en fichero-----------
                        reg.guardar();
                    }break;
                    case 5:{
                        //------------------ salir  ----------------------
                        JOptionPane.showMessageDialog(null,"Fin");
                        System.exit(0);
                    }return;
                    default:{
                    JOptionPane.showMessageDialog(null,"elija una opcion");}
                }
            }else{
            JOptionPane.showMessageDialog(null,"Las opciones no contienen letras"
                    + " ni puede dejar vacio la seleccion..\n\n Elija por favor "
                    + "una opcion...."," ERROR",JOptionPane.WARNING_MESSAGE);}
           
        }
    }
    
}
