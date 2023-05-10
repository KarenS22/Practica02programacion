
package ec.edu.ups.practica02.quitokaren.penasofia.modelo;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Cantante extends Persona{
   //atributos de la clase Cantante
    private String nombreArtistico;
    private String generoMusical;
    private int numeroDeSencillos;
    private int numeroDeConciertos;
    private int numeroDeGiras;
    private List<Disco> discografia;
    
    
   // constructor 

    public Cantante(String nombreArtistico, String generoMusical, int numeroDeSencillos, int numeroDeConciertos, int numeroDeGiras, int codigo, String nombre, String apellido, int edad, String nacionalidad, double salario) {
        super(codigo, nombre, apellido, edad, nacionalidad, salario);
        this.nombreArtistico = nombreArtistico;
        this.generoMusical = generoMusical;
        this.numeroDeSencillos = numeroDeSencillos;
        this.numeroDeConciertos = numeroDeConciertos;
        this.numeroDeGiras = numeroDeGiras;
        this.discografia = new ArrayList();
    }
    

    /*sobreescritura del metodo abstracto calcularSalario que si se cumplen las condiciones
    este aumentara 
    */
    @Override
    public double calcularSalario() {
        double salariob = super.getSalario();
        double salariof = salariob;
        double aumento = 0;
        if (numeroDeSencillos > 10 && numeroDeGiras > 3){
            salariof +=1000;
        } else if(numeroDeSencillos >=1 && numeroDeSencillos<=10){
            aumento +=(salariob* 0.05);
        } else if(numeroDeGiras>= 1 && numeroDeGiras <=3){
            aumento+= (salariob* 0.03);
        } else if (discografia.size()>=5 ){
            salariof+=2000;
        }
        super.setSalario(salariof + aumento);
            
        return super.getSalario();
    }
    
    /*
    metod agregarDisco se colocan 3 parametros para crear un nuevo objeto tipo 
    Disco que luego sera añadido a la lista discografia
    */
    public void agregarDisco(int codigo, String nombre, int anioDeLazamiento){
        Disco disco = new Disco(codigo, nombre, anioDeLazamiento);
        discografia.add(disco);
    }
//getters and setters
    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public int getNumeroDeSencillos() {
        return numeroDeSencillos;
    }

    public void setNumeroDeSencillos(int numeroDeSencillos) {
        this.numeroDeSencillos = numeroDeSencillos;
    }

    public int getNumeroDeConciertos() {
        return numeroDeConciertos;
    }

    public void setNumeroDeConciertos(int numeroDeConciertos) {
        this.numeroDeConciertos = numeroDeConciertos;
    }

    public int getNumeroDeGiras() {
        return numeroDeGiras;
    }

    public void setNumeroDeGiras(int numeroDeGiras) {
        this.numeroDeGiras = numeroDeGiras;
    }

    public List<Disco> getDiscografia() {
        return discografia;
    }

    public void setDiscografia(List<Disco> discografia) {
        this.discografia = discografia;
    }
// sobrescritura del metodo hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.nombreArtistico);
        hash = 17 * hash + Objects.hashCode(this.generoMusical);
        hash = 17 * hash + this.numeroDeSencillos;
        hash = 17 * hash + this.numeroDeConciertos;
        hash = 17 * hash + this.numeroDeGiras;
        hash = 17 * hash + Objects.hashCode(this.discografia);
        return hash;
    }
//sobrescritura del metodo equals
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
        final Cantante other = (Cantante) obj;
        if (this.numeroDeSencillos != other.numeroDeSencillos) {
            return false;
        }
        if (this.numeroDeConciertos != other.numeroDeConciertos) {
            return false;
        }
        if (this.numeroDeGiras != other.numeroDeGiras) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        if (!Objects.equals(this.generoMusical, other.generoMusical)) {
            return false;
        }
        return Objects.equals(this.discografia, other.discografia);
    }
//sobreescritura del metodo toString
    @Override
    public String toString() {
        return "Cantante{" + super.toString() + "nombreArtistico=" + nombreArtistico + ", generoMusical=" + generoMusical + ", numeroDeSencillos=" + numeroDeSencillos + ", numeroDeConciertos=" + numeroDeConciertos + ", numeroDeGiras=" + numeroDeGiras + ", discografia=" + discografia + '}';
    }
}
