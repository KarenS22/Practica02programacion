
package ec.edu.ups.practica02.quitokaren.penasofia.controlador;

import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Cancion;
import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Cantante;
import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Compositor;
import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Disco;
import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Persona;
import java.util.ArrayList;
import java.util.List;


public class ControladorPersona implements IControlador{
    //atributo, lista de Persona (Cantante y compositor)
    private List<Persona> personas;
    
    //constructor 
    public ControladorPersona() {
        personas = new ArrayList<>();
    }

    //getters and setters
    public List<Persona> getPersonas() {
        return personas;
    }

    public void setPersonas(List<Persona> personas) {
        this.personas = personas;
    }

    //sobreescritura toString
    @Override
    public String toString() {
        return "ControladorPersona{" + "personas=" + personas + '}';
    }
    
    ////sobreescritura del metodo abstracto imprimir que muestra la lista personas
    @Override
    public void imprimir(){
        //for each lista de personas
        for (Persona persona : personas) {
            //imprimir persona
            System.out.println(persona);   
        }
    }
    
    /* sobreescritura metodo buscarPorNombreDeDisco que compara nombres de discos 
    para devolver un objeto tipo Cantante
    */
    @Override
    public Persona buscarPorNombreDeDisco(String valor){
        //for each de la lista personas
        for(Persona persona : personas){
            //se instancia si persona pertenece a Cantante
            if(persona instanceof Cantante){
                //casteo persona se vuelve un objeto de la clase Cantante
                Cantante cantante = (Cantante) persona;
                //for each de la discografia de un cantante
                for (Disco disco : cantante.getDiscografia()){
                    //comparacion del nombre del disco con el parametro
                    if(disco.getNombre().equals(valor)){
                        //imprime nombre y apellido del cantante
                        System.out.println(cantante.getNombre() + cantante.getApellido());
                        //regresa un objeto tipo Cantante
                        return cantante;
                    }
                }
            }
        }
        return null;
    }
    
    /* sobreescritura del metodo buscarPorTituloDeCancion, compara el parametro ingresado con los titulos 
    de las canciones para devolver un objeto tipo Compositor
    */
    @Override
    public Persona buscarPorTituloDeCancion(String valor){
        //for each lista personas
        for (Persona per : personas){
            // si per es instancia de Compositor
            if (per instanceof Compositor){
                // Casteo per se vuelve un objeto tipo Compositor
                Compositor compositor = (Compositor) per;
                // for each lista de canciones Top 100 Billboard 
                for (Cancion cancion : compositor.getCancionesTop100Billboard()){
                    // busqueda, compara titulo con el parametro
                    if(cancion.getTitulo().equals(valor)){
                        // imprimir nombre y apellido de compositor
                        System.out.println(compositor.getNombre() + compositor.getApellido());
                        // retorna un compositor
                        return compositor;
                    }
                }
            }
        }
        return null;
    }

    /*sobreescritura metodo create
    Agrega compositores y cantantes a la lista personas
    */
    @Override
    public void create(Persona obj) {
        if(obj instanceof Persona){
            personas.add((Persona)obj);
        }
    }

    /* sobreescritura del metodo read
    lee un obj tipo Persona 
    */
    @Override
    public Persona read(Persona obj) {
        int codigo = obj.getCodigo();
        for(Persona pr : personas){
            if(pr.getCodigo() == codigo){
                    return pr;
            }
        }
        
        return null;
    }

    /* sobrescritura del metodo update
    en este caso, actualiza el nombre, se puede actualizar todo menos el codigo
    */
    @Override
    public void update(Persona obj) {
        if (obj instanceof Persona){
            String nombre = ((Persona)obj).getNombre();
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                if(persona.getNombre().equals(nombre)){
                    personas.set(i, (Persona)obj);
                    break;
                }
            }
        }
    }

    /* sobrescritura del metodo delete 
    elimina objetos de la lista personas si es que los parametros se cumplen
    */
    @Override
    public void delete(Persona obj) {
        if(obj instanceof Persona){
            for (int i = 0; i < personas.size(); i++) {
                Persona persona = personas.get(i);
                if(persona.equals((Persona)obj)){
                    personas.remove(i);
                    break;
                }
                
            }
        }
    }
    
    
}
