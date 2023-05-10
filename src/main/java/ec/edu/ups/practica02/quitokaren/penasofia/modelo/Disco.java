
package ec.edu.ups.practica02.quitokaren.penasofia.modelo;

import java.util.Objects;

public class Disco {
    //atributos de Disco
    private int codigo;
    private String nombre;
    private int anioDeLazamiento;
//constructor vacio
    public Disco() {    
    }
    
//constructor con todos los parametros
    public Disco(int codigo, String nombre, int anioDeLazamiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.anioDeLazamiento = anioDeLazamiento;
    }

    //getters and setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnioDeLazamiento() {
        return anioDeLazamiento;
    }

    public void setAnioDeLazamiento(int anioDeLazamiento) {
        this.anioDeLazamiento = anioDeLazamiento;
    }
//sobreescritura del metodo hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.codigo;
        hash = 97 * hash + Objects.hashCode(this.nombre);
        hash = 97 * hash + this.anioDeLazamiento;
        return hash;
    }
//sobreescritura del metodo equals
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
        final Disco other = (Disco) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (this.anioDeLazamiento != other.anioDeLazamiento) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }
    
//sobreescritura del metodo toString
    @Override
    public String toString() {
        return "Disco{" + "codigo=" + codigo + ", nombre=" + nombre + ", anioDeLazamiento=" + anioDeLazamiento + '}';
    }
    
    
}
