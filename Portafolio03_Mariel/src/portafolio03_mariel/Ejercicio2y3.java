/**
 *
 * @author MarielRojas Sanchez
 * 05/09/2023
 */
package portafolio03_mariel;

import java.util.Random;
import java.util.Scanner;
import java.util.Random;


public class Ejercicio2y3 {
     public static void main(String[] args) {
        
        // numeros de un vector sin rrepetir
        int[] vector = new int[20];
        // Llena el vector con números del 1 al 20.
        for (int i = 0; i < vector.length; i++) {
          vector[i] = i + 1;
        }
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int n = 0; // Tamaño de la matriz
        int[][] matriz = null;
        boolean matrizLlena = false;
        int opcion;
        while (true) {
            
            opcion = mostrarMenu();

            switch (opcion) {
                
                case 1:
                    System.out.print("Ingrese el tamaño de la matriz (n x n): ");
                    n = scanner.nextInt();
                    matriz = new int[n][n];
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            matriz[i][j] = random.nextInt(200) + 1;
                        }
                    }
                    matrizLlena = true;
                    System.out.println("La matriz ha sido llenada con números aleatorios.");
                    break;
                case 2:
                    if (matrizLlena) {
                        mostrarMatriz(matriz);
                    } else {
                        System.out.println("Debe primero rellenar la matriz.");
                    }
                    break;
                case 3:
                    if (matrizLlena) {
                        System.out.print("Ingrese el número de fila a sumar (0 a " + (n - 1) + "): ");
                        int fila = scanner.nextInt();
                        if (fila >= 0 && fila < n) {
                            int sumaFila = sumarFila(matriz, fila);
                            System.out.println("La suma de la fila " + fila + " es: " + sumaFila);
                        } else {
                            System.out.println("Número de fila fuera de rango.");
                        }
                    } else {
                        System.out.println("Debe primero rellenar la matriz.");
                    }
                    break;
                case 4:
                    if (matrizLlena) {
                        System.out.print("Ingrese el número de columna a sumar (0 a " + (n - 1) + "): ");
                        int columna = scanner.nextInt();
                        if (columna >= 0 && columna < n) {
                            int sumaColumna = sumarColumna(matriz, columna);
                            System.out.println("La suma de la columna " + columna + " es: " + sumaColumna);
                        } else {
                            System.out.println("Número de columna fuera de rango.");
                        }
                    } else {
                        System.out.println("Debe primero rellenar la matriz.");
                    }
                    break;
                case 5:
                    if (matrizLlena) {
                        int sumaDiagonalPrincipal = sumarDiagonalPrincipal(matriz);
                        System.out.println("La suma de la diagonal principal es: " + sumaDiagonalPrincipal);
                    } else {
                        System.out.println("Debe primero rellenar la matriz.");
                    }
                    break;
                case 6:
                    if (matrizLlena) {
                        int sumaDiagonalInversa = sumarDiagonalInversa(matriz);
                        System.out.println("La suma de la diagonal inversa es: " + sumaDiagonalInversa);
                    } else {
                        System.out.println("Debe primero rellenar la matriz.");
                    }
                    break;
                case 7:
                    if (matrizLlena) {
                        double promedio = calcularPromedio(matriz);
                        System.out.println("El promedio de los valores de la matriz es: " + promedio);
                    } else {
                        System.out.println("Debe primero rellenar la matriz.");
                    }
                    break;
                case 8:
                    mezclarVector(vector);
                    System.out.println("Vector con Números aleatorios sin repetir.");
                    for (int num : vector) {
                        System.out.print(num + " ");
                    }
                    break;
                case 9:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
     // mezclar vector para que no se repitan numeros
    public static void mezclarVector(int[] vector) { //Fisher-Yates 
       Random random = new Random();
        // Realiza un intercambio aleatorio para mezclar el vector.
        for (int i = vector.length - 1; i > 0; i--) { // el bucle comienza desde el ultimo elemento del vector
            // Genera un índice aleatorio en el rango [0, i].
            int indiceAleatorio = random.nextInt(i + 1);

            // Intercambia el elemento actual con el elemento en el índice aleatorio.
            int aux = vector[i];
            vector[i] = vector[indiceAleatorio];
            vector[indiceAleatorio] = aux;
        }
    }
    
    public static int mostrarMenu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nMenú:");
            System.out.println("1) Llenar la matriz con números aleatorios entre 1 y 200.");
            System.out.println("2) Mostrar la matriz.");
            System.out.println("3) Sumar una fila.");
            System.out.println("4) Sumar una columna.");
            System.out.println("5) Sumar la diagonal principal.");
            System.out.println("6) Sumar la diagonal inversa.");
            System.out.println("7) Calcular el promedio de los valores de la matriz.");
            System.out.println("8) Mostrar números aleatorios sin repetir");
            System.out.println("9) Salir."); 
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            return opcion;
    }
    
    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + "\t");
            }
            System.out.println();
        }
    }

    public static int[][] llenarMatriz(int n, Random random) {
        int[][] matriz = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matriz[i][j] = random.nextInt(200) + 1;
            }
        }
        return matriz;
    }

    public static int sumarFila(int[][] matriz, int fila) {
        int suma = 0;
        for (int valor : matriz[fila]) { // numero de fila que se va a sumar
            suma += valor; // suma almacena los valores de la fila que se van a ir sumando
        }
        return suma;
    }

    public static int sumarColumna(int[][] matriz, int columna) {
        int suma = 0;
        for(int i = 0; i < matriz.length; i++) {
            suma += matriz[i][columna]; // suma almacena los valores de la columna que se van a ir sumando
        }
        return suma;
    }

    public static int sumarDiagonalPrincipal(int[][] matriz) {
        int suma = 0;
        for(int i = 0; i < matriz.length; i++) {
            suma += matriz[i][i];
        }
        return suma;
    }

    public static int sumarDiagonalInversa(int[][] matriz) {
        int suma = 0;
        for(int i = 0; i < matriz.length; i++) {
            suma += matriz[i][matriz.length - 1 - i];
        }
        return suma;
    }

    public static double calcularPromedio(int[][] matriz) {
        int suma = 0;
        int elementos = 0;
        for(int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
                elementos++;
            }
        }
        return (double) suma / elementos;
    }            
}
