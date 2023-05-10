/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.ups.practica02.quitokaren.penasofia.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author ACER
 */
public class Compositor extends Persona {
    //atributos
    private int numeroDeComposiciones;
    private List<Cancion> cancionesTop100Billboard;
    private List<Cantante> clientes;

    //constructor
    public Compositor(int numeroDeComposiciones, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.numeroDeComposiciones = numeroDeComposiciones;
        this.cancionesTop100Billboard =new ArrayList();
        this.clientes = new ArrayList();
    }

    //getters and setters
    public int getNumeroDeComposiciones() {
        return numeroDeComposiciones;
    }

    public void setNumeroDeComposiciones(int numeroDeComposiciones) {
        this.numeroDeComposiciones = numeroDeComposiciones;
    }

    public List<Cancion> getCancionesTop100Billboard() {
        return cancionesTop100Billboard;
    }

    public void setCancionesTop100Billboard(List<Cancion> cancionesTop100Billboard) {
        this.cancionesTop100Billboard = cancionesTop100Billboard;
    }

    public List<Cantante> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cantante> clientes) {
        this.clientes = clientes;
    }

    //sobreescritura hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.numeroDeComposiciones;
        hash = 13 * hash + Objects.hashCode(this.cancionesTop100Billboard);
        hash = 13 * hash + Objects.hashCode(this.clientes);
        return hash;
    }

    //sobreescritura equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Compositor other = (Compositor) obj;
        if (this.numeroDeComposiciones != other.numeroDeComposiciones) {
            return false;
        }
        if (!Objects.equals(this.cancionesTop100Billboard, other.cancionesTop100Billboard)) {
            return false;
        }
        return Objects.equals(this.clientes, other.clientes);
    }

    //sobreescritura toString
    @Override
    public String toString() {
        return "Compositor{" + super.toString() + "numeroDeComposiciones=" + numeroDeComposiciones + ", cancionesTop100Billboard=" + cancionesTop100Billboard + ", clientes=" + clientes + '}';
    }

    //sobreescritura metodo calcularSalario, dependiendo las condiciones el salario aumenta
    @Override
    public double calcularSalario() {
        double salariob = super.getSalario();
        double salariofinal = salariob;
        double aumento = 0;
        if (numeroDeComposiciones >= 5){
            salariofinal += 300;
        } else if (cancionesTop100Billboard.size()>=1 && cancionesTop100Billboard.size()<=3){
            aumento += (salariob * 0.1);
        } else if(cancionesTop100Billboard.size()>=4 && cancionesTop100Billboard.size()<=6){
            aumento += (salariob * 0.2);
        } else if (cancionesTop100Billboard.size()> 6){
            aumento += (salariob * 0.2);
        }
        return salariofinal + aumento;
    }
    
    /*
    metodo agregarCancion donde se tiene que poner 4 parametros de entrada que crearan 
    un objeto cancion que luego sera agregado a la lista cancionesTop100Billboard
    */
    public void agregarCancion(int codigo, String titulo, String letra, double tiempoEnMinutos){
        Cancion cancion = new Cancion(codigo, titulo, letra, tiempoEnMinutos);
        cancionesTop100Billboard.add(cancion);
    }
    
    /*
    metodo agregarCliente se pone un objeto tipo Cantante que luego sera 
    agregado a la lista clientes
    */
    public void agregarCliente(Cantante cliente){
        clientes.add(cliente);
    }
}
