// Mariel Rojas Sánchez

package Entidades;


public class Trabajador {
    
    // Atributos clase
    private int id_trabajador;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String puesto_trabajo;
    private boolean existe; // controlar insertar y modificar
    
    // Constructor
    
    // vacio
    public Trabajador() {
        id_trabajador = 0;
        nombre = "";
        apellido = "";
        telefono = "";
        email = "";
        puesto_trabajo = "";
        existe = false;
    }
    // con parametros 
    public Trabajador(int id_trabajador, String nombre, String apellido, String telefono, String email, String puesto_trabajo) {
        this.id_trabajador = id_trabajador;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
        this.puesto_trabajo = puesto_trabajo;
        this.existe = true;
    }
    
    // metodos getter y setter
    public int getId_trabajador() {
        return id_trabajador;
    }

    public void setId_trabajador(int id_trabajador) {
        this.id_trabajador = id_trabajador;
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

    public String getPuesto_trabajo() {
        return puesto_trabajo;
    }

    public void setPuesto_trabajo(String puesto_trabajo) {
        this.puesto_trabajo = puesto_trabajo;
    }

    public boolean isExiste() {
        return existe;
    }
    
    public void setExiste(boolean existe) {
        this.existe = existe;
    }
    
}
