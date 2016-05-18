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
public class ArchivosUsuarios {
 
    ObjectOutputStream archivosSalida;
    ObjectInputStream archivosEntrada;
    
    public ArchivosUsuarios()
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
         archivosEntrada=new ObjectInputStream(new FileInputStream("Usuarios.dat"));
         existe=true;
        //System.out.println("Se cargo el archivo de forma correcta");
        }
        catch(Exception e)
        {
         System.out.println(""+e);

        }
      return existe;  
    }
    public void crearArchivo()
    {
      try
        {
            archivosSalida=new ObjectOutputStream(new FileOutputStream("Usuarios.dat"));
            System.out.println("Se creo el archivo de forma correcta");
        }
      catch(Exception e)
      {
          System.out.println("Error al crear el archivo"+e);
      }
    }
           
    public void ingresarInformacionAlArchivo(Usuario usuario)//recibe  objeto y lo agrega al archivo
    {
        try
        {
            archivosSalida.writeObject(usuario);//mete información en el archivo
            System.out.println("Se ingreso de forma correcta la información del archivo");
        }
        catch(Exception e)
        {
            System.out.println("error: "+e);
        }
    }
    public ArrayList<Usuario> devolverInformacionDelArchivo()//cuando llegue al final del archivo se cae, lo atrapa en el catch; esto solo para saber cuando llegó al final
    {
        ArrayList<Usuario> array=new ArrayList<Usuario>();
        try
        {
            while(true)
            {
                array.add((Usuario)archivosEntrada.readObject());
               // System.out.println("va a llegar al final");
            }
        }
        catch(Exception e)
        {
            System.out.println("Se llegó al final del archivo");
        }
        return array;
    }
     public boolean verificarExistenciaDeArchivoDeUsuarios()
    {
        boolean existeArchivo=true;
        try{
        archivosEntrada=new ObjectInputStream(new FileInputStream("Usuarios.dat"));
        }
        catch(Exception e)
        {
            existeArchivo=false;
            System.out.println("Error al cargar el archivo de Usuarios: "+e);
        }
            
        return existeArchivo;
    }
}
