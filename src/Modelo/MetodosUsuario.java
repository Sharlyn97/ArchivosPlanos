/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Moon
 */
public class MetodosUsuario {

    private  ArrayList <Usuario> arrayUsuario;
    String arregloDatos[]=new String[3];
    int vueltasRegistrar=0;
    Usuario  usuario;
    ArchivosUsuarios archivoUsuarios;
    
    public MetodosUsuario()
    {
        arrayUsuario=new ArrayList <Usuario>();
    }
    
     public boolean verificarExistenciaDeArchivoDeUsuarios() {
        return archivoUsuarios.verificarExistenciaDeArchivoDeUsuarios();
    }
     
    public boolean loginExitoso(String nombreUsuario, String contrasenia)
    {
        boolean permisoEntrada=false;
        System.out.println("entra a login exitoso" );
        System.out.println("array "+arrayUsuario.size());
        // System.out.println("información guardada: "+arrayUsuario.get(0).getNombreUsuario()+" contraseña "+arrayUsuario.get(0).getContraseña());
         System.out.println("información que entra: "+nombreUsuario+" contra: "+contrasenia);
       for(int contador=0; contador<arrayUsuario.size(); contador++)
        {  
             System.out.println("entra al FOR" );
         System.out.println("información guardada: "+arrayUsuario.get(contador).getNombreUsuario()+" contraseña "+arrayUsuario.get(contador).getContraseña());
         System.out.println("información que entra: "+nombreUsuario+" contra: "+contrasenia);
         if(arrayUsuario.get(contador).getNombreUsuario().equals(nombreUsuario)&&arrayUsuario.get(contador).getContraseña().equals(contrasenia))
         {
             permisoEntrada=true;
         }
     }
        return permisoEntrada;
    }
    
    public boolean agregarUsuario(String informacion[])
    {
          boolean estudianteRepetido=false;
          boolean agrego=false;
    Usuario temporal=new Usuario(informacion[0], informacion[1], informacion[2], informacion[3]);
    
    if(vueltasRegistrar==0)
    {  
      arrayUsuario.add(temporal);
      vueltasRegistrar=1;
     
     // JOptionPane.showMessageDialog(null,"El estudiante se agregó correctamente");  
     agrego=true;
    }    
    else
    { 
      for(int contador=0; contador<arrayUsuario.size(); contador++)
        { 
            System.out.println("el nombre com: "+arrayUsuario.get(contador).getNombreUsuario());
            System.out.println("igual a: "+informacion[1]);
          if(arrayUsuario.get(contador).getNombreUsuario().equals(informacion[1]))
            {
                estudianteRepetido=true;  
            }     
         }   
           if(estudianteRepetido)
            {
                    //JOptionPane.showMessageDialog(null,"El estudiante ya existe"); 
            }
           else
            {
                    arrayUsuario.add(temporal);
                    //JOptionPane.showMessageDialog(null,"El estudiante se agregó correctamente");
                    
                    estudianteRepetido=false;
                    agrego=true;
             }
    }
        return agrego;
    }
    
    public ArrayList <Usuario> getArray()
    {
        System.out.println("Array: "+arrayUsuario.get(0).getInformacion());
        return arrayUsuario;
    }
    public void setArray(ArrayList<Usuario>array)
    {
      arrayUsuario=array;
    }
    
     public void mostrarInformacion()
    {
        for(int contador=0;contador<arrayUsuario.size();contador++)
        {
            System.out.println(arrayUsuario.get(contador).getInformacion());
        
        }
    
    }
    
    public boolean consultarUsuario(String nombreUsuario)
    {
        {
     boolean consulto=false;
     for(int contador=0; contador<arrayUsuario.size(); contador++)
     {
         //System.out.println(arrayCurso.get(contador).getNombre());
         if(arrayUsuario.get(contador).getNombreUsuario().equals(nombreUsuario))
        {
            arregloDatos[0]=arrayUsuario.get(contador).getNombreCompleto();
            arregloDatos[1]=""+arrayUsuario.get(contador).getTipo();
            arregloDatos[2]=arrayUsuario.get(contador).getContraseña();
            consulto=true;
        }
     }
     
    return consulto;
 }
    }
    public boolean modificarUsuario(String informacion[])
    { 
        boolean modifico=false;
        int vueltas=0;
     for(int contador=0; contador<arrayUsuario.size(); contador++)
     {
         if(arrayUsuario.get(contador).getNombreUsuario().equals(informacion[1]))
         {
             arrayUsuario.get(contador).setNombreCompleto(informacion[0]);
             arrayUsuario.get(contador).setContraseña(informacion[2]);
             arrayUsuario.get(contador).setTipo(informacion[3]);
             
             modifico=true;
            // JOptionPane.showMessageDialog(null,"El estudiante se modificó correctamente"); 
         }
         else
         {
             vueltas++;
             if(vueltas==arrayUsuario.size())
             {
              //JOptionPane.showMessageDialog(null,"El estudiante no existe"); 
             }
         }
     }
     return modifico;
    }
    public boolean eliminarUsuario(String nombreUsuario)
    {
        boolean elimino=false;
        int vueltas=0;
     for(int contador=0; contador<arrayUsuario.size(); contador++)
     {
         if(arrayUsuario.get(contador).getNombreUsuario().equals(nombreUsuario))
         {
             arrayUsuario.remove(contador);
             elimino=true;
            // JOptionPane.showMessageDialog(null,"El estudiante se ha eliminado correctamente");   
         }
     }
     return  elimino;
    }
    
    public String[] getArregloInformacion()
    {
        
        return this.arregloDatos;
        
    }  
    
}
