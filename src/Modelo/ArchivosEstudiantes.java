/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Moon
 */
public class ArchivosEstudiantes {
    
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivosEstudiantes()
    {
        if(cargarArchivo())
        {
         System.out.println("Se cargo el archivo de forma correcta");   
        }
        else
        {
         System.out.println("No se cargo el archivo de forma correcta");
        }
    }
    
    public boolean cargarArchivo()//cargarlo a la memoria
    {
        boolean existe=false;
        
        try 
        {
         archivoEntrada=new ObjectInputStream(new FileInputStream("Estudiantes.dat"));
         existe=true;
        //System.out.println("Se cargo el archivo de forma correcta");
        }
        catch(Exception e)
        {
         System.out.println("Error al cargar: "+e);

        }
      return existe;  
    }
    public void crearArchivo()
    {
      try
        {
            archivoSalida=new ObjectOutputStream(new FileOutputStream("Estudiantes.dat"));
            System.out.println("Se creo el archivo de forma correcta");
        }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo: "+e);
      }
    }
    public void ingresarInformacionAlArchivo(Estudiante estudiante)//recibe  objeto y lo agrega al archivo
    {
        try
        {
            archivoSalida.writeObject(estudiante);//mete información en el archivo
            System.out.println("Se ingreso de forma correcta la información del archivo");
        }
        catch(Exception e)
        {
            System.out.println("error: "+e);
        }
    }
    public ArrayList<Estudiante> devolverInformacionDelArchivo()//cuando llegue al final del archivo se cae, lo atrapa en el catch; esto solo para saber cuando llegó al final
    {
        ArrayList<Estudiante> array=new ArrayList<Estudiante>();
        try
        {
            while(true)
            {
                array.add((Estudiante)archivoEntrada.readObject());
                System.out.println("va a llegar al final");
            }
        }
        catch(Exception e)
        {
            System.out.println("Se llegó al final del archivo");
        }
        return array;
    }
    
}
