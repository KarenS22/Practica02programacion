
package ec.edu.ups.practica02.quitokaren.penasofia.modelo;

import java.util.Objects;


public class Cancion {
    //atributos
    private int codigo;
    private String titulo;
    private String letra;
    private double tiempoEnMinutos;
//constructor vacio
    public Cancion() {
    }
//constructos con todos los parametros
    public Cancion(int codigo, String titulo, String letra, double tiempoEnMinutos) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.letra = letra;
        this.tiempoEnMinutos = tiempoEnMinutos;
    }
    
    
//getters and setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public double getTiempoEnMinutos() {
        return tiempoEnMinutos;
    }

    public void setTiempoEnMinutos(double tiempoEnMinutos) {
        this.tiempoEnMinutos = tiempoEnMinutos;
    }
//sobreescritura metodo hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + this.codigo;
        hash = 37 * hash + Objects.hashCode(this.titulo);
        hash = 37 * hash + Objects.hashCode(this.letra);
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.tiempoEnMinutos) ^ (Double.doubleToLongBits(this.tiempoEnMinutos) >>> 32));
        return hash;
    }
//sobreescritura metodo equals
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
        final Cancion other = (Cancion) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (Double.doubleToLongBits(this.tiempoEnMinutos) != Double.doubleToLongBits(other.tiempoEnMinutos)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.letra, other.letra);
    }
//sobreescritura toString
    @Override
    public String toString() {
        return "Cancion{" + "codigo=" + codigo + ", titulo=" + titulo + ", letra=" + letra + ", tiempoEnMinutos=" + tiempoEnMinutos + '}';
    }
         
}
