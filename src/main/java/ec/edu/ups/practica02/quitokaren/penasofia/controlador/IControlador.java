/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.ups.practica02.quitokaren.penasofia.controlador;

import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Persona;

/**
 *
 * @author ACER
 */
public interface IControlador {
    //constante que se usa para arreglos [], no necesario para listas que se uso en este proyecto
    public int MAX_OBJECTS = 10;
    
    //metodos abstractos que se modificaran en una clase
    public abstract void create(Persona obj);
    public abstract Persona read(Persona obj);
    public abstract void update(Persona obj);
    public abstract void delete(Persona obj);
    public abstract void imprimir();
    public abstract Persona buscarPorNombreDeDisco(String valor);
    public abstract Persona buscarPorTituloDeCancion(String valor);
    
}
