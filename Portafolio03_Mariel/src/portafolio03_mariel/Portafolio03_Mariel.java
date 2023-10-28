/*
 * Mariel Daniela Rojas Sánchez
 * 208030487
    05/09/2023
 */
package portafolio03_mariel;
import java.util.Scanner;

public class Portafolio03_Mariel {

  
    public static void main(String[] args) {
        
        // Arreglos con el mismo tamaño que es indicado por el usuario 
        //El primer arreglo contendrá los nombres de los trabajadores.
        String[] nombre= null;
        //El segundo arreglo sus edades 
        int[] edad = null;
        // el tercero sus salarios.
        double salario [] = null;
        // opcion
        int opcion = 0; // se inicializa en 0 para que ingrese al while
        Scanner scanner = new Scanner(System.in);
        
        
  
        while (opcion != 7) { // mientras no se digite e 7 sigue recorriendo
           
            opcion = mostrarMenu();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de trabajadores: ");
                    int cantidad = scanner.nextInt();
                    nombre = new String[cantidad];
                    edad = new int[cantidad];
                    salario = new double[cantidad];
                    break;
                case 2:
                    if (nombre != null) { // si el nombre esta lleno
                        for (int i = 0; i < nombre.length; i++) {
                            scanner.nextLine(); 
                            System.out.print("Ingrese el nombre del trabajador " + (i + 1) + ": ");
                            nombre[i] = scanner.nextLine();
                            System.out.print("Ingrese la edad del trabajador " + (i + 1) + ": ");
                            edad[i] = scanner.nextInt();
                            System.out.print("Ingrese el salario del trabajador " + (i + 1) + ": ");
                            salario[i] = scanner.nextDouble();
                        }
                    } else {
                        System.out.println("Primero debe indicar la cantidad de trabajadores.");
                    }
                    break;
                case 3:
                    if (nombre != null) {
                        System.out.println("Datos ordenados por nombre.");
                        ordenarNombreBurbuja(nombre,edad,salario);
//                        for (int i = 0; i < nombre.length; i++) {
//                        System.out.println("Nombre: " + nombre[i] 
//                        + ", Salario: " + salarios[i] + ", Edad: " + edades[i]);}
                        
                    } else {
                        System.out.println("Primero debe ingresar los datos de los trabajadores.");
                    }
                    break;
                case 4:
                    if (edad != null) {
                        ordenarEdadSeleccion (edad,nombre,salario);
                        System.out.println("Datos ordenados por edad.");
                    } else {
                        System.out.println("Primero debe ingresar los datos de los trabajadores.");
                    }
                    break;
                case 5:
                    if (salario != null) {
                        ordenarSalarioInserccion (salario, nombre, edad);
                        System.out.println("Datos ordenados por salario.");
                    } else {
                        System.out.println("Primero debe ingresar los datos de los trabajadores.");
                    }
                    break;
                case 6:
                    if (nombre != null) {
                        mostrarInformacion(nombre, edad, salario);
                    } else {
                        System.out.println("Primero debe ingresar los datos de los trabajadores.");
                    }
                    break;
                    
                case 7:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    public static int mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMenú:");
        System.out.println("1) Indicar la cantidad de trabajadores");
        System.out.println("2) Introducir los datos de los trabajadores");
        System.out.println("3) Ordenar por nombre"); //burbuja
        System.out.println("4) Ordenar por edad"); // seleccion
        System.out.println("5) Ordenar por salario"); // inserccion
        System.out.println("6) Mostrar información de los empleados");
        System.out.println("7) Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = scanner.nextInt();
        return opcion;
    }
    
    public static void ordenarNombreBurbuja(String[] nombres, int[] edades, double[] salarios)
    {
        for (int i = 0; i < nombres.length - 1; i++) {
            for (int j = i + 1; j < nombres.length; j++) {
                if (nombres[i].compareTo(nombres[j]) > 0) {
                    // Intercambiar nombres
                    String tempNombre = nombres[i];
                    nombres[i] = nombres[j];
                    nombres[j] = tempNombre;

                    // Intercambiar edades para que coincida con los nombres
                    int tempEdad = edades[i];
                    edades[i] = edades[j];
                    edades[j] = tempEdad;
                    double tempSalario = salarios[i];
                    salarios[i] = salarios[j];
                    salarios[j] = tempSalario;
                }
            }
        }
        
    }
    
    
    private static void mostrarInformacion(String[] nombres, int[] edades, double[] salarios) {
        System.out.println("\nInformación de los empleados:");
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Trabajador " + (i + 1) + ":");
            System.out.println("Nombre: " + nombres[i]);
            System.out.println("Edad: " + edades[i]);
            System.out.println("Salario: " + salarios[i]);
            System.out.println();
        }
    }
    
    public static void ordenarEdadSeleccion (int[] edades, String[] nombres, double[] salarios){
        
        for (int i = 0; i < edades.length - 1; i++) { // recorrer el arreglo de edades
            int menor = i;
            for (int j = i + 1; j < edades.length; j++) { // encontrar el salario mas pequeñp
                if (edades[j] < edades[menor]) { // si ela nueva edad encontrada es menor 
                    menor = j; // se intercambia
                }
            }

            // Intercambia las edades
            int edadMenor = edades[i];
            edades[i] = edades[menor];
            edades[menor] = edadMenor;

            // se intercambia nombres y salarios para que coincidan c
            String nombreMenor = nombres[i];
            nombres[i] = nombres[menor];
            nombres[menor] = nombreMenor;
            double salarioMenor = salarios[i];
            salarios[i] = salarios[menor];
            salarios[menor] = salarioMenor;
        }
    }
    
    public static void ordenarSalarioInserccion (double[] salario, String[] nombre, int[] edad)
    {
        double salarioActual;// variable auxiliar para el intercambio
        int edadActual, j;
        String nombreActual;
        
        for (int i = 1; i < salario.length; i++) {
            salarioActual = salario[i]; // se guarda el elemento actual
            nombreActual = nombre[i]; // se guarda el elemento actual
            edadActual = edad[i]; // se guarda el elemento actual
            j = i - 1; // se combrueba con el los elementos anteriores

            while (j >= 0 && salario[j] > salarioActual) { // Siempre que sea mayor que los elementos actualess
                salario[j + 1] = salario[j]; // ordenamos de menor a mayor.
                nombre[j + 1] = nombre[j]; //Trasladamos el valor y movemos el indice.
                edad[j + 1] = edad[j];
                j--;
            }
            // Ponemos el valor a ordenar en su sitio.
            salario[j + 1] = salarioActual;
            nombre[j + 1] = nombreActual;
            edad[j + 1] = edadActual;
        }
    }
    
    
    
}

