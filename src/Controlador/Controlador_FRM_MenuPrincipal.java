/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivosUsuarios;
import Vista.FRM_Login;
import Vista.FRM_MantenimientoCursos;
import Vista.FRM_MantenimientoEstudiantes;
import Vista.FRM_Matricula;
import Vista.FRM_MenuPrincipal;
import Vista.FRM_ModuloMantenimientoUsuarios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MenuPrincipal implements ActionListener{
    
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    FRM_MantenimientoCursos mantenimientoCursos;
    FRM_Matricula matricula;
    FRM_ModuloMantenimientoUsuarios moduloUsuarios;
    ArchivosUsuarios archivos;
    
    
    public Controlador_FRM_MenuPrincipal(FRM_MenuPrincipal frm_menuPrincipal)
    {
        
        mantenimientoEstudiantes=new FRM_MantenimientoEstudiantes();
        mantenimientoCursos=new FRM_MantenimientoCursos();
        archivos=new ArchivosUsuarios();
        moduloUsuarios=new FRM_ModuloMantenimientoUsuarios(archivos,frm_menuPrincipal);
        matricula= new FRM_Matricula(mantenimientoEstudiantes,mantenimientoCursos);
        
    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Salir"))
        {
            System.exit(0);        
        }
        if(e.getActionCommand().equals("Estudiantes"))
        {
            this.mantenimientoEstudiantes.setVisible(true);
            mantenimientoEstudiantes.setLocationRelativeTo(null);//centrarla
            
        }
        if(e.getActionCommand().equals("Cursos"))
        {
            this.mantenimientoCursos.setVisible(true);
        }
        if(e.getActionCommand().equals("Matricula"))
        {
            this.matricula.setVisible(true);
            this.matricula.colocarCodigo();
        }
        if(e.getActionCommand().equals("Usuarios"))
        {
            this.moduloUsuarios.setVisible(true);
        }
        
    }
//     public boolean ficheroExistente()
//    {
//      boolean existe=false;
//        if (archivos.exists())
//        {
//         System.out.println("El fichero existe");
//         existe=true;
//        } 
//        else 
//         {
//         System.out.println("El fichero no existe");
//        }
//        return existe;   
//    }
}
