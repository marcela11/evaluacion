/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

/**
 *
 * @author -ADMIN-
 */
public class usuarioDTO {
 
    private int idUsuario;
    private String nombre;
    private String email;
    private String userName;
    private String pass;

    public usuarioDTO(String userName, String pass) {
        this.userName = userName;
        this.pass = pass;
    }

    public usuarioDTO() {
    }

    public usuarioDTO(int idUsuario, String nombre, String email, String userName, String pass) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.email = email;
        this.userName = userName;
        this.pass = pass;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
        
}
