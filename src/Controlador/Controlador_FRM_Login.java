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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author Moon
 */
public class Controlador_FRM_Login implements ActionListener{
    
    ArchivosUsuarios archivos;
    MetodosUsuario metodos;
    FRM_Login login;
    boolean creo=false;
  
    FRM_MenuPrincipal frm_menuPrincipal;
    
    
public Controlador_FRM_Login(FRM_Login login, FRM_MenuPrincipal frm_menuPrincipal)
{
    this.login=login;
    this.frm_menuPrincipal=frm_menuPrincipal;
    archivos= new ArchivosUsuarios();
    metodos=new MetodosUsuario();
    metodos.setArray(archivos.devolverInformacionDelArchivo());     
}




    @Override
    public void actionPerformed(ActionEvent e) {
    
        if(e.getActionCommand().equals("Entrar"))
        { 
            System.out.println("entrar");
            if(metodos.loginExitoso(login.devolverNombreUsuario(), login.devolverContraseña()))
            {
                login.mensaje("Se encontró el usuario");
                
                this.frm_menuPrincipal.setVisible(true);       
            }
            else
            {
                login.mensaje("Información incorrecta, vuelva a intentarlo");
            }
        }
    }


}
