/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ArchivosEstudiantes;
import Modelo.Estudiante;
import Modelo.MetodosEstudiantes;
import Vista.FRM_MantenimientoEstudiantes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 *
 * @author tecnologiamultimedia
 */
public class Controlador_FRM_MantenimientoEstudiantes implements ActionListener{
    
    
    public MetodosEstudiantes metodos;
    FRM_MantenimientoEstudiantes mantenimientoEstudiantes;
    ArchivosEstudiantes archivo;
    
    public Controlador_FRM_MantenimientoEstudiantes(FRM_MantenimientoEstudiantes mantenimientoEstudiantes)
    {
        this.mantenimientoEstudiantes=mantenimientoEstudiantes;
        archivo= new ArchivosEstudiantes();
        metodos = new MetodosEstudiantes();
        //llamara al setArray()
        metodos.setArray(archivo.devolverInformacionDelArchivo());//carga el arreglo del archivo
        
    }
    
    public void crearArchivo()
    {
      ArrayList <Estudiante> array=metodos.getArray();
     archivo.crearArchivo();
     
     for(int conta=0; conta<array.size(); conta++)
     {
         archivo.ingresarInformacionAlArchivo(array.get(conta));
         //archivo.ingresarInformacionAlArchivo(new Estudiante(array.get(conta).getCedula(),array.get(conta).getDireccion(),array.get(conta).getNombreCompleto()));
         System.out.println("ingresa la información: "+array.get(conta).getCedula()+array.get(conta).getDireccion()+array.get(conta).getNombreCompleto());
         archivo.devolverInformacionDelArchivo();
     }   
     
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getActionCommand().equals("Consultar"))
        {
            if(metodos.consultarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
                mantenimientoEstudiantes.mensaje("Se encontó el estudiante");
                //System.out.println("consultar");
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se encontró el estudiante");
            }
        }
        if(e.getActionCommand().equals("Agregar"))
        {
            if(metodos.agregarEstudiante(mantenimientoEstudiantes.devolverInformacion(),mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.agrego();
                mantenimientoEstudiantes.mensaje("Se agregó correctamente");
                //System.out.println("agregar");
                //mantenimientoEstudiantes.mostrarInformacion(metodos.getArregloInformacion());
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se encontró el curso");
            }
        }
        if(e.getActionCommand().equals("modificar"))
        { 
           if(metodos.modificarEstudiante(mantenimientoEstudiantes.devolverCedula(), mantenimientoEstudiantes.devolverNombre(), mantenimientoEstudiantes.devolverDireccion()))
           {
               mantenimientoEstudiantes.agrego();
               mantenimientoEstudiantes.mensaje("Se modificó correctamente");
           }
           else
            {
                mantenimientoEstudiantes.mensaje("No se encontró el curso");
            }
        }
       
        if(e.getActionCommand().equals("eliminar"))
        { 
        
            if(metodos.eliminarEstudiante(mantenimientoEstudiantes.devolverCedula()))
            {
                mantenimientoEstudiantes.agrego();
                mantenimientoEstudiantes.mensaje("Se eliminó correctamente");
            }
            else
            {
                mantenimientoEstudiantes.mensaje("No se encontró el curso");
            }
        }

    
    }
}