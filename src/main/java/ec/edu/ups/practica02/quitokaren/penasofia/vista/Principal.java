
package ec.edu.ups.practica02.quitokaren.penasofia.vista;

import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Cantante;
import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Compositor;
import ec.edu.ups.practica02.quitokaren.penasofia.modelo.Persona;
import ec.edu.ups.practica02.quitokaren.penasofia.controlador.ControladorPersona;
import ec.edu.ups.practica02.quitokaren.penasofia.controlador.IControlador;
import java.util.Scanner;


public class Principal {

    public static void main(String[] args) {
        //instancia de un solo controlador
        IControlador controladorPersona = new ControladorPersona();
        
        // instancia de Scanner para ingreso por el usuario
        Scanner teclado = new Scanner(System.in);
        
        int op = 0;
        
        //bucle do
        do{
            //menu 
            System.out.println("\n Menu MusikUPS \n1. Ingresar un cantante \n2. Ingresar un compositor \n3. Agregar Clientes \n4. Imprimir lista de personas \n5. Buscar cantante por nombre de disco \n6. Buscar compositor por titulo de cancion \n7. Salir ");
            //ingreso por teclado de la opcion
            op = teclado.nextInt();
            switch (op) {
                case 1:
                    System.out.println("INGRESO DE CANTANTE");
                    //ingreso de datos con Scanner
                    System.out.println("Ingrese el codigo del cantante: ");
                    int codigo = teclado.nextInt();
                    System.out.println("Ingrese el nombre del cantante: ");
                    String nombre = teclado.next();
                    System.out.println("Ingrese el apellido del cantante: ");
                    String apellido = teclado.next();
                    System.out.println("Ingrese la edad del cantante: ");
                    int edad = teclado.nextInt();
                    System.out.println("Ingrese la nacionalidad del cantante: ");
                    String nacionalidad = teclado.next();
                    System.out.println("Ingrese el salario del cantante: ");
                    double salario = teclado.nextDouble();
                    System.out.println("Ingrese el nombre artistico del cantante: ");
                    String nombreArtistico = teclado.next();
                    System.out.println("Ingrese el genero musical del cantante: ");
                    String generoMusical = teclado.next();
                    System.out.println("Ingrese el numero del sencillos del cantante: ");
                    int numeroDeSencillos = teclado.nextInt();
                    System.out.println("Ingrese el numero de conciertos del cantante: ");
                    int numeroDeConciertos = teclado.nextInt();
                    System.out.println("Ingrese el numero de giras del cantante: ");
                    int numeroDeGiras = teclado.nextInt();
                    // instancia de cantante
                    Persona cantante = new Cantante(nombreArtistico, generoMusical, numeroDeSencillos, numeroDeConciertos, numeroDeGiras, codigo, nombre, apellido, edad, nacionalidad, salario);
                    //creacion de discos
                    System.out.println("Ingrese la cantidad de discos del cantante: ");
                    int nD = teclado.nextInt();
                    for (int i = 0; i < nD; i++) {
                        System.out.println("INGRESO DE DISCO ");
                        System.out.println("Ingrese el codigo del disco: ");
                        int codigoD = teclado.nextInt();
                        System.out.println("Ingrese el nombre del disco: ");
                        String nombreD = teclado.next();
                        System.out.println("Ingrese el año de lanzamiento del disco: ");
                        int anioDeLanzamiento = teclado.nextInt();
                        //casting para aplicar el metodo agregarDisco
                        Cantante cantanteC = (Cantante)cantante;
                        cantanteC.agregarDisco(codigoD, nombreD, anioDeLanzamiento);
                    }
                    //metodo para calcular salario final
                    cantante.calcularSalario();
                    
                    // agregar cantante a lista de personas
                    controladorPersona.create(cantante);
                    break;
                case 2:
                        System.out.println("INGRESO DE COMPOSITOR");
                    //ingreso de datos con scanner
                    System.out.println("Ingrese el codigo del compositor: ");
                    int codigoC = teclado.nextInt();
                    System.out.println("Ingrese el nombre del compositor: ");
                    String nombreC = teclado.next();
                    System.out.println("Ingrese el apellido del compositor: ");
                    String apellidoC = teclado.next();
                    System.out.println("Ingrese la edad del compositor: ");
                    int edadC = teclado.nextInt();
                    System.out.println("Ingrese la nacionalidad del compositor: ");
                    String nacionalidadC = teclado.next();
                    System.out.println("Ingrese el salario del compositor: ");
                    double salarioC = teclado.nextDouble();
                    System.out.println("Ingrese el numero de composiciones del compositor: ");
                    int numeroDeComposiciones = teclado.nextInt();
                    //instanciar compositor
                    Persona compositor = new Compositor(numeroDeComposiciones, codigoC, nombreC, apellidoC, edadC, nacionalidadC, salarioC);
                    System.out.println("Ingrese el numero de canciones en el Top 100 Billboard del compositor: ");
                    int nC = teclado.nextInt();
                    
                    for (int i = 0; i < nC; i++) {
                        System.out.println("INGRESO DE CANCION");
                        System.out.println("Ingrese el codigo de la cancion: ");
                        int codigoCa = teclado.nextInt();
                        System.out.println("Ingrese el titulo de la cancion: ");
                        String titulo = teclado.next();
                        System.out.println("Ingrese la letra de la cancion: ");
                        String letra = teclado.next();
                        System.out.println("Ingrese el tiempo en minutos de la cancion: ");
                        double tiempoEnMinutos = teclado.nextDouble();
                        //casting para usar metodo agregarCancion
                        Compositor compositorC = (Compositor)compositor;
                        compositorC.agregarCancion(codigoCa, titulo, letra, tiempoEnMinutos);
                    }
                    // calculo del salario final 
                    compositor.calcularSalario();
                    // colocar el objeto en la lista personas
                    controladorPersona.create(compositor);
                    break;
                case 3:
                    System.out.println("AGREGAR CLIENTE (Cantante) ");
                    // busqueda por titulo de cancion 
                    System.out.println("Ingrese un titulo de cancion del compositor para agregar un cliente");
                    String valorBC = teclado.next();
                    Compositor compositorAG = (Compositor)controladorPersona.buscarPorTituloDeCancion(valorBC);
                    System.out.println("Ingrese un titulo del Disco del cliente (cantante): ");
                    String valorBD = teclado.next();
                    //casteo y agregacion de cliente
                    Cantante cantanteAG = (Cantante)controladorPersona.buscarPorNombreDeDisco(valorBD);
                    compositorAG.agregarCliente(cantanteAG);
                    break;
                case 4:
                    // imprime la lista de personas
                    controladorPersona.imprimir();
                    
                    break;
                case 5: 
                    System.out.println("BUSQUEDA POR NOMBRE DE DISCO");
                    System.out.println("Ingrese el nombre del disco a buscar: ");
                    String valor = teclado.next();
                    controladorPersona.buscarPorNombreDeDisco(valor);
                    break;
                case 6:
                    System.out.println("BUSQUEDA POR TITULO DE CANCION");
                    System.out.println("Ingrese el titulo de la cancion a buscar: ");
                    String valorT = teclado.next();
                    controladorPersona.buscarPorTituloDeCancion(valorT);
                    break;
                case 7:
                    //salida del bucle
                    break;
                default:
                    //si es que se ingresa una opcion invalida
                    System.out.println("Error, opcion invalida ");;
               
            }
         //salida del bucle
        } while(op != 7); 
    }
}
