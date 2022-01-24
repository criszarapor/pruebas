
package pruebas;

import java.io.*;
import java.util.Scanner;

public class Pruebas {
    public static void main(String[] args) {
 try {
            Scanner td = new Scanner (System.in);
            int opcion1 = 0, i = 0;

            System.out.println("Bienvenido/a al programa de registro.");
            
            while ( opcion1 < 3){

                mostrarMenu();

                System.out.println("Introduzca la opcion que desea ejecutar (1-3): ");
                opcion1=td.nextInt();

                System.out.println();

                if (opcion1==1){
                    System.out.println("Ha escogido la opcion 1: Añadir un nuevo registro.");                 
                    nuevo();
                    System.out.println();
                    
                    System.out.println("EL fichero ha sido guardado con exito.");  
                    System.out.println();
                }
                else if (opcion1==2){
                    System.out.println("Ha escogido la opcion 2: Ver datos registrados.");
                    lectura();
                    System.out.println();   
                }
                else {
                    System.out.println("Ha escogido la opcion 3: Salir.");
                    System.out.println();
                    System.out.println("Adiós.");
                }            
            }
        }    
            
       catch (Exception e){
               System.out.println("Se ha producido un error. Vuelva a intentarlo.");         
        }
        
    }
        
    public static void mostrarMenu(){
       System.out.println("---OPCIONES---");
       System.out.println("1. Añadir un nuevo registro");
       System.out.println("2. Ver datos registrados");
       System.out.println("3. Salir");
    }
    public static void nuevo(){
      
        try {
            Scanner td = new Scanner (System.in);
            String datos [] = new String [100];
            String nom, ape, gene;
            int edad, i =0;
            
            System.out.println("Dame el nombre de una persona: ");
            nom=td.nextLine();

            System.out.println("Dame sus apellidos: ");
            ape=td.nextLine();        

            System.out.println("Dame su edad: ");
            edad=td.nextInt();

            System.out.println("Introduce su genero: ");
            td.nextLine();
            gene=td.nextLine();

            File fichero = new File ("personas.txt");
            BufferedWriter escritor = new BufferedWriter (new FileWriter(fichero, true));
                
                escritor.write(nom);
                escritor.newLine();

                escritor.write(ape);
                escritor.newLine();

                escritor.write(String.valueOf(edad));
                escritor.newLine();

                escritor.write(gene);
                escritor.newLine();
                
                datos[i]=nom+" "+ape+" "+edad+" "+gene;
                  
            escritor.close();    
        }
        catch (IOException e){
            System.out.println("Se ha producido un error al registrar. Intentelo de nuevo.");
        }
    }
  
    public static void lectura(){
         try{
            String datos [] = new String [100];

            File fichero = new File ("personas.txt");

            BufferedReader lector = new BufferedReader (new FileReader(fichero));
            String linea,linea2,linea3, linea4;
            int i=0;

            while ((linea = lector.readLine()) != null){
                linea2 = lector.readLine();
                linea3 = lector.readLine();
                linea4 = lector.readLine();
                datos[i] = linea+"\n"+linea2+"\n"+linea3+"\n"+linea4;
                i++;
            }
            
            lector.close();
            
            System.out.println("Los datos registrados son: ");
            
            for (int j=0; j<datos.length;j++){
                if (datos[j] !=null){
                    System.out.println(datos[j]);
                }
            }
        }
         
        catch(IOException e){
            System.out.println("Error en la lectura del fichero");
        }
    }
}
