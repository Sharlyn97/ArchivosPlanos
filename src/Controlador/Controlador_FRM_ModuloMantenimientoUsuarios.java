/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivosUsuarios;
import Modelo.MetodosUsuario;
import Modelo.Usuario;
import Vista.FRM_Login;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_ModuloMantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Moon
 */
public class Controlador_FRM_ModuloMantenimientoUsuarios implements ActionListener{

       MetodosUsuario metodos;
       FRM_ModuloMantenimientoUsuarios moduloUsuarios;
       ArchivosUsuarios archivos;
       FRM_Login login;
      //public boolean creo=false;
      private int vezQueEntra=1;

    public Controlador_FRM_ModuloMantenimientoUsuarios(FRM_ModuloMantenimientoUsuarios moduloUsuarios,ArchivosUsuarios archivos,FRM_MenuPrincipal frm_menuPrincipal) 
    {
       this.moduloUsuarios=moduloUsuarios; 
       metodos=new MetodosUsuario(); 
       this.archivos=archivos;
       System.out.println("vez: "+vezQueEntra);
       if(vezQueEntra==1)
       {
           System.out.println("primera vez");
           System.out.println("vez: "+vezQueEntra);
           login=new FRM_Login(frm_menuPrincipal);
           verificarExistenciaDeArchivoDeUsuario();
       }
       else
       {
       
       }
    }
    
    public void verificarExistenciaDeArchivoDeUsuario()
    {
     if(archivos.verificarExistenciaDeArchivoDeUsuarios())
       {
         login.mensaje("Inicie sesión por favor 2");
         login.setVisible(true);
         vezQueEntra++;
         System.out.println("vez2: "+vezQueEntra);
       }
       else
       {
           login.mensaje("No existe usuarios agregados, proceda a agregar");
           moduloUsuarios.setVisible(true);
       }   
    }
    
    public void crearArchivo()
    {
        
      ArrayList <Usuario> array=metodos.getArray();
     archivos.crearArchivo();
//     creo=true;
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivos.ingresarInformacionAlArchivo(array.get(conta));
         archivos.devolverInformacionDelArchivo();
     }   
     
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getActionCommand().equals("Agregar"))
        {
            System.out.println("agregar");
          if(metodos.agregarUsuario(moduloUsuarios.devolverInformacion()))
          {
              moduloUsuarios.mensaje("Se agregó correctamente");
          }
          else
          {
              moduloUsuarios.mensaje("No se agregó correctamente");
          }
            
        }
        if(e.getActionCommand().equals("modificar"))
        {
            System.out.println("modificar");
            if(metodos.modificarUsuario(moduloUsuarios.devolverInformacion()))
            {
                moduloUsuarios.mensaje("Se modificó correctamente");
            }
            else
            {
                moduloUsuarios.mensaje("No se modificó correctamente");
            }
        }
        if(e.getActionCommand().equals("eliminar"))
        {
          System.out.println("eliminar");
          if(metodos.eliminarUsuario(moduloUsuarios.devolverNombreUsuario()))
          {
              moduloUsuarios.mensaje("Se eliminó correctamente");
          }
          else
          {
              moduloUsuarios.mensaje("No se eliminó correctamente");
          }
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            System.out.println("consular");
            if(metodos.consultarUsuario(moduloUsuarios.devolverNombreUsuario()))
            {
                moduloUsuarios.mensaje("Se consultó correctamente");
                moduloUsuarios.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
                moduloUsuarios.mensaje("No se consultó correctamente");
            }
        }
       
    }
    
}
