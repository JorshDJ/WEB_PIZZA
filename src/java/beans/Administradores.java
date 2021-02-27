/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author PC
 */
public class Administradores {
    
    private String codigo;
    private String nombre;
    private String pass;
    private String correo;
    
    
    //ctrl + espacio
    
    public Administradores() {
    }
    

    public Administradores(String codigo, String nombre, String pass, String correo) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pass = pass;
        this.correo = correo;
    }  

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
    
}
