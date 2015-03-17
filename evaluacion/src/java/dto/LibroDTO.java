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
public class LibroDTO {
    
    private int idLibro;
    private String isbn;
    private String titulo;
    private int estado;

    public LibroDTO() {
    }

    public LibroDTO(int idLibro, String isbn, int estado) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.estado = estado;
    }

    public LibroDTO(int idLibro, String isbn, String titulo, int estado) {
        this.idLibro = idLibro;
        this.isbn = isbn;
        this.titulo = titulo;
        this.estado = estado;
    }

    
    
   
    /**
     * @return the idLibro
     */
    public int getIdLibro() {
        return idLibro;
    }

    /**
     * @param idLibro the idLibro to set
     */
    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
    
    @Override
    public String toString() {
        return "Dto{" + "idLibro=" + idLibro + ", isbn=" + isbn + ", titulo=" + titulo + ", estado=" + estado + '}';
    }
    
    
}
