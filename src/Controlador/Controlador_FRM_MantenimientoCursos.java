/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.MetodosCursos;
import Vista.FRM_MantenimientoCursos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoCursos implements ActionListener{
    
    FRM_MantenimientoCursos frm_MantenimientoCursos;
    public MetodosCursos metodos;
   
    public Controlador_FRM_MantenimientoCursos(FRM_MantenimientoCursos frm_MantenimientoCursos)
    {
        this.frm_MantenimientoCursos= frm_MantenimientoCursos;
        metodos = new MetodosCursos();
    } 
    
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Agregar"))
        {
           if (metodos.agregarCurso(frm_MantenimientoCursos.devolverInformacion()))
           {
               frm_MantenimientoCursos.modifico();
               frm_MantenimientoCursos.mensaje("Se agregó correctamente");
           }
           else
            {
                frm_MantenimientoCursos.mensaje("No se encontró el curso");
            }
        }
        if(e.getActionCommand().equals("Consultar"))
        {
            if(metodos.consultarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.mostrarInformacion(metodos.getArregloInformacion());
                frm_MantenimientoCursos.mensaje("Se encontró el curso");
            }
            else
            {
                frm_MantenimientoCursos.mensaje("No se encontró el curso");
            }
        }
        if(e.getActionCommand().equals("eliminar"))
        {
            if(metodos.eliminarCurso(frm_MantenimientoCursos.devolverSigla()))
            {
                frm_MantenimientoCursos.modifico();
                frm_MantenimientoCursos.mensaje("Se eliminó correctamente");
            }
            else
            {
                frm_MantenimientoCursos.mensaje("No se encontró el curso");
            }
        }
        if(e.getActionCommand().equals("modificar"))
        {
            System.out.println("modicar");
            
            if(metodos.modificarCurso(frm_MantenimientoCursos.devolverInformacion()))
            {
                frm_MantenimientoCursos.modifico();
                frm_MantenimientoCursos.mensaje("Se modificó correctamente");
                metodos.modificarCurso(frm_MantenimientoCursos.devolverInformacion());
            }
            else
            {
                frm_MantenimientoCursos.mensaje("No se encontró el curso");
            }
        }
    }
}
