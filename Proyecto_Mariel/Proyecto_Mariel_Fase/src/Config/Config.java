//Mariel Rojas Sanchez

package Config;

public final class Config {
    public static String getConnectionString()throws ClassNotFoundException{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        // Retorna la cadena de conexion, cuando se necesite eb cualquier aprte del programa la tenemos en un unico lugar
        // y se obtiene llamando la clase Config.java
        return "jdbc:sqlserver://localhost;databasename=VETERINARIA;user=sa;password=sa";
    }
}
