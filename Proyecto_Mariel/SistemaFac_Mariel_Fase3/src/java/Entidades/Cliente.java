/**
 *
 * @author Mariel Rojas
 */
package Entidades;

public class Cliente {

    // Atributos clase
    private int id_cliente;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private boolean existe; // controlar insertar y modificar
    
    
    // Constructores 
    // vacio
    public Cliente() {
       id_cliente = 0;
       nombre = "";
       apellido = "";
       telefono = "";
       email = "";
       existe = false;
    }
    // parametros
    public Cliente(int id_cliente,String nombre, String apellido, String telefono, String email) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.existe=true;
    }
    
    //Metodos Getter / setter
   public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isExiste() {
        return existe;
    }
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    // Metodo Insertar
    // SOBRESCRIBIR MÉTODOS _______________________________
    @Override
    public String toString() {
        return id_cliente + " " + nombre;
    }
}