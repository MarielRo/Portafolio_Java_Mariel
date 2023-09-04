/*
  Mariel Daniela Rojas Sánchez
  Fecha: 31/08/2023
 */
package portafolio01_mariel;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;

public class Portafolio01_Mariel {

    public static void main(String[] args) {
       
        //PARTE 1
        
        // Tipos de datos booleanos
        boolean verdadero = true;
        boolean falso = false;
        System.out.println("Tipos de datos booleanos");
        System.out.println("¿El planeta es redondo? " + verdadero);
        System.out.println("¿El planeta es plano? " + falso);
        System.out.println(); // salto linea en java
        
        //Operadores relacionales 
        System.out.println("Operadores relacionales");
        int x = 10;
        int y = 20;
        int z = 20;
        if(x > y) System.out.println("x es mayor a y");  
        else if( x<y ) System.out.println("y es mayor a x");
        else System.out.println("x es igual a y");
        System.out.println(); // salto linea en java
   
        //Operadores lógicos 
        System.out.println("Operadores lógicos ");
        if((x == y) && ((x == z)) && (z == y))  System.out.println("Son todos iguales con and");  
        else if((x == y) || ((x == z))|| (z == y)) System.out.println("Al menos uno, es igual se cumple con or");
       
        
        //Prueba que en Java si no asignamos valores al declarar variables, éstas tienen valores por defecto. 
        System.out.println(); // salto linea en java
        int a = 0; // Valor por defecto: 0
        int b = 0;
        int suma;;
        suma = a+b;
        System.out.println("Valores por defecto " + suma);
        System.out.println();
        //string cadena;
        //System.out.println("Valor por defecto de String: " + cadena);
                
        //Asigne adecuadamente el nombre a los identificadores
        int horasTrabajadas = 36;
        int precioHora = 1550;
        int salario = precioHora * horasTrabajadas;
        System.out.println("El salario es de " + salario + " colones");
       
        System.out.println();
        //Declara alguna constante, ponga a prueba que la constante no puede ser modificada posterior a su declaración 
        final int CONSTANTE = 10;
        
        //CONSTANTE = 15;
         System.out.println("Valor constante " + CONSTANTE);
        
        //Pruebe el uso de varios caracteres de escape
        System.out.println();
        System.out.println("Println");
        System.out.println("Mariel\nRojas"); //Salto linea
        System.out.println("Nombre:\tJuan"); //Tabula
        System.out.println("Comilla simple: \' \'");
        System.out.println("Comilla doble: \" \"");
        System.out.println();
       //Cree un tipo enumerado y pruebe su funcionamiento, investigue y cree un ejemplo diferente al estudiado en clase con Enum. 
        indicarDia(DiaSemana.MARTES);
       System.out.println();
        //Instrucciones de entrada y salida de consola
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Hola, " + nombre);
        System.out.println();
        //Envío de mensajes con la clase swing
        JOptionPane.showMessageDialog(null, "¡Usanso clase swing!");
        System.out.println();
        
        
        //PARTE 2: Cree un programa que realice lo siguiente:
        
        //Tome un texto y utilice al menos 5 métodos de la clase String para obtener determinados resultados 
        String texto = "Mi nombre es Mariel";
        //Realice conversiones de tipo String a int y double
        //  1: Obtener la longitud
        int longitud = texto.length();
        System.out.println("Longitud del texto: " + longitud);
        
        // 2: Convertir todo a mayúsculas
        String mayusculas = texto.toUpperCase();
        System.out.println("Mayúsculas: " + mayusculas);
        
        //  3: Reemplazar una subcadena
        String reemplazado = texto.replace("Mariel", "Daniela");
        System.out.println("Reemplazado: " + reemplazado);
        
        // 4: Extraer una subcadena
        String subcadena = texto.substring(0, 5);
        System.out.println("Subcadena: " + subcadena);
        
        // 5: Buscar una subcadena
        boolean contiene = texto.contains("Mariel");
        System.out.println("Contiene 'Mariel': " + contiene);
        System.out.println();
        //Realice conversiones de tipos numéricos (int y double) a string
        String enteros = "8080";
        String decimales = "12.12";
        
        int numeroEntero = Integer.parseInt(enteros);
        double numeroDecimal = Double.parseDouble(decimales);
        
        System.out.println("Número entero: " + numeroEntero);
        System.out.println("Número decimal: " + numeroDecimal);
        System.out.println();
        
        //Realice conversiones de tipos numéricos (int y double) a string
        int entero = 2000;
        double decimal = 12.08;
        
        String enteroString = Integer.toString(entero);
        String decimalString = Double.toString(decimal);
        
        System.out.println("Valor entero a String: " + enteroString);
        System.out.println("Valor decimal a String: " + decimalString);
        System.out.println();
        
        //Realice comparaciones y concatenaciones entre strings 
        String str1 = "Mariel";
        String str2 = "Mariel";
        String str3 = "Ariel";

        // Comparación de cadenas
        boolean sonIguales = str1.equals(str2);
        System.out.println("¿cadena1 es igual a cadena2? " + sonIguales);

        // Concatenación de cadenas
        String concatenacion = str1 + ", " + str3;
        System.out.println("Concatenación: " + concatenacion);
        
        //PARTE 3: Cree un programa que utilice:
        
        //Al menos 5 métodos de la clase Math para realizar determinados cálculos, debe utilizar números random en algún proceso. 
        double num1 = 15.8;
        double num2 = 4.3;
        
        //1 Potencia
        double potencia = Math.pow(num1, 2);
        System.out.println("Potencia de " + num1 + " a la 2: " + potencia);
        // 2 raiz cuadrada
        double raizCuadrada = Math.sqrt(num2);
        System.out.println("Raíz cuadrada de " + num2 + ": " + raizCuadrada);
        // 3 valor absoluto
        double valorAbsoluto = Math.abs(-15);
        System.out.println("Valor absoluto de -15: " + valorAbsoluto);
        //4 redondedo
        double redondeoArriba = Math.ceil(8.3);
        System.out.println("Redondeo hacia arriba de 8.3: " + redondeoArriba);
        // 5
        double redondeoAbajo = Math.floor(8.3);
        System.out.println("Redondeo hacia abajo: " + redondeoAbajo);
        
        System.out.println();
        //Tipos de datos int y double y realice conversiones de int a double
        int entero1 = 40;
        double doble = (double) entero1;
        System.out.println("Valor entero convertido a double: " + doble);
        System.out.println();
        //Operadores aritméticos
        int suma1 = entero1 + 10;
        int resta = entero1 - 5;
        int multiplicacion = entero1 * 2;
        double division = doble / 3.0;
        System.out.println("Suma: " + suma1);
        System.out.println("Resta: " + resta);
        System.out.println("Multiplicación: " + multiplicacion);
        System.out.println("División: " + division);
        System.out.println();
        
        //Operadores de asignación 
        int a1 = 5;
        a1 += 3; // a ahora es 8
        a1 -= 2; // a ahora es 6
        a1 *= 4; // a ahora es 24
        a1 /= 3; //a ahora es 8
        System.out.println("Valor de x después de operadores de asignación: " + a1);
        
        
        
        
        
    }
    //Cree un tipo enumerado y pruebe su funcionamiento, investigue y cree un ejemplo diferente al estudiado en clase con Enum. 
    public enum DiaSemana 
    {
        LUNES, MARTES, MIERCOLES, JUEVES, VIERNES, SABADO, DOMINGO
    }
    
    public static void indicarDia(DiaSemana  dia){
        switch(dia){
            case LUNES:
            System.out.println("PRIMER DIA DE LA SEMANA");
            break;
            case MARTES:
            System.out.println("SEGUNDO DIA DE LA SEMANA");
            break;
        }
    }
}
