/*
 Mariel Daniela Rojas Sánchez
 02 Septiembre 2023
 */
package portafolio02_mariel;
import java.util.Scanner;

public class Portafolio02_Mariel {

    public static void main(String[] args) {
        int opcion;
        int[][] matriz = null;
        do {
            opcion = mostrarMenu();
            switch (opcion) {
                case 1:
                    //  número factorial
                   System.out.println("Calculando el número factorial.");
                   calcularFactorial();
                   System.out.println();
                    break;
                case 2:
                    // L primeros 10 números primos
                    System.out.println("Mostrando los primeros 10 números primo.");
                    mostrarPrimos(15);
                    System.out.println();
                    break;
                case 3:
                    //  matriz de números al azar
                    System.out.println("Creando una matriz de números al azar.");
                    matriz = crearMatriz(6, 5);
                    mostrarMatriz(matriz);
                    System.out.println();
                    break;
                case 4:
                    // número mayor de la matriz
                    System.out.println("Obteniendo el número mayor de la matriz.");
                    encontrarNumeroMayor(matriz);
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Saliendo.");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, digite una opción válida.");
                    break;
            }
        } while (opcion != 5);
    }
    
    
    public static int mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1.Número Factorial");
        System.out.println("2.Los 10 primeros números Primos");
        System.out.println("3.Crear una matriz de números al azar");
        System.out.println("4.Obtener el número mayor de la matriz");
        System.out.println("5.Salir");
        System.out.print("Ingresa el número de la opción deseada: ");
        int opcion = scanner.nextInt();
        return opcion;
    }
    
    public static void calcularFactorial() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa un número entero para calcular su factorial: ");
        int numero = scanner.nextInt();
        long factorial = 1;

        if (numero < 0) {
            System.out.println("No se puede calcular el factorial de un número negativo.");
        } else {
            for (int i = 1; i <= numero; i++) {
                factorial *= i; //acuula
            }
            System.out.println("El factorial de " + numero + " es " + factorial);
        }
    }
    
    // Metodo para ver si un nunero es primo o no
    public static boolean esPrimo(int numero) {
        if (numero <= 1 || numero == 4 ) {
            return false;
        }
        for (int i = 2; i * i <= numero; i++) { //usar el sqr
            if (numero % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static void mostrarPrimos(int n) {
        int[] numerosPrimos = new int[n];// vector que almacena los numeros primos
        int numero = 2;
        int contador = 0;

        while (contador < n) {
            if (esPrimo(numero)) {
                numerosPrimos[contador] = numero;
                contador++;
            }
            numero++;
        }

        System.out.println("Los primeros " + n + " números primos son:");
        for (int primo : numerosPrimos) {
            System.out.print(primo + " ");
        }
        System.out.println();
    }
    
    // crea la matriz
    public static int[][] crearMatriz(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = (int) (Math.random() * 200 + 1); // Números entre 1 y 200
            }
        }
        return matriz;
    }
    
    public static void mostrarMatriz(int[][] matriz) {
        int filas = matriz.length; // numero de filas de la matriz
        int columnas = matriz[0].length; // numero de columnas de la primer fila

        System.out.println("Matriz:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.printf("%-4d", matriz[i][j]); // -4en el formato indica alineación a la izquierda y un ancho de campo                      de 4 caracteres.
            }
            System.out.println(); // Cambio de línea después de cada fila
        }
    }
    
    public static void encontrarNumeroMayor(int[][] matriz) {
        if (matriz == null) {
            System.out.println("La matriz no ha sido creada. Primero debes llenar la matriz.");
            return; // Salir de la función si la matriz no ha sido creada
        }

        int filas = matriz.length;
        int columnas = matriz[0].length;
        int mayor = matriz[0][0];

        // Recorrer para encontrar el número mayor
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                }
            }
        }
        System.out.println("El número mayor en la matriz es: " + mayor);
    }
    
}

