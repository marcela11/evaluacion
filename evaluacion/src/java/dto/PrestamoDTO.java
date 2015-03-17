/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.sql.Date;

/**
 *
 * @author -ADMIN-
 */
public class PrestamoDTO {
    
    private int idPrestamo;
    private int usuarioId;
    private int libroId ;
    private int estado ;
    private Date fechaPrestamo;
    private Date fechaDevolucion;

    
    
    public PrestamoDTO(int idPrestamo, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoDTO(int idPrestamo, int usuarioId, int libroId, Date fechaPrestamo, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }

    public PrestamoDTO(int idPrestamo, int usuarioId, int libroId, int estado, Date fechaPrestamo, Date fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.estado = estado;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    }
    

    public PrestamoDTO(int usuarioId, int libroId) {
        this.usuarioId = usuarioId;
        this.libroId = libroId;
    }

    public PrestamoDTO() {
    }
    
    public PrestamoDTO(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public PrestamoDTO(int idPrestamo, int usuarioId, int libroId, int estado) {
        this.idPrestamo = idPrestamo;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.estado = estado;
    }
    
    
    
    //UsuarioDTO user = null;
    //LibroDTO libro = null;

    /**
     * @return the idPrestamo
     */
    public int getIdPrestamo() {
        return idPrestamo;
    }

    /**
     * @param idPrestamo the idPrestamo to set
     */
    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    /**
     * @return the usuarioId
     */
    public int getUsuarioId() {
        return usuarioId;
    }

    /**
     * @param usuarioId the usuarioId to set
     */
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    /**
     * @return the libroId
     */
    public int getLibroId() {
        return libroId;
    }

    /**
     * @param libroId the libroId to set
     */
    public void setLibroId(int libroId) {
        this.libroId = libroId; 
    }

    /**
     * @return the estado
     */
    public int getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }


    @Override
    public String toString() {
        return "PrestamoDTO{" + "idPrestamo=" + idPrestamo + ", usuarioId=" + usuarioId + ", libroId=" + libroId + ", estado=" + estado + ", fechaPrestamo=" + fechaPrestamo + ", fechaDevolucion=" + fechaDevolucion + '}';
    }


    
}
