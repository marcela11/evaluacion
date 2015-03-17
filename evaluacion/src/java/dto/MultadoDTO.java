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
public class MultadoDTO {
 
    private int idMulta;
    private int idPrestamo;
    private String fechaMulta;
    private Double valorTotal;
    private String fechaPago;
    private int estado;

    public MultadoDTO() {
    }

    public MultadoDTO(int idPrestamo, String fechaMulta, Double valorTotal) {
        this.idPrestamo = idPrestamo;
        this.fechaMulta = fechaMulta;
        this.valorTotal = valorTotal;
    }

    public MultadoDTO(int idMulta, int idPrestamo, Double valorTotal, String fechaMultas, int estado) {
        this.idMulta = idMulta;
        this.idPrestamo = idPrestamo;
        this.valorTotal = valorTotal;
        this.fechaMulta = fechaMultas;
        this.estado = estado;
    }

    public MultadoDTO(int idMulta, int idPrestamo, String fechaMulta, int estado) {
        this.idMulta = idMulta;
        this.idPrestamo = idPrestamo;
        this.fechaMulta = fechaMulta;
        this.estado = estado;
    }

    public MultadoDTO(int idMulta, int idPrestamo, String fechaMulta, Double valorTotal, String fechaPago, int estado) {
        this.idMulta = idMulta;
        this.idPrestamo = idPrestamo;
        this.fechaMulta = fechaMulta;
        this.valorTotal = valorTotal;
        this.fechaPago = fechaPago;
        this.estado = estado;
    }

    public int getIdMulta() {
        return idMulta;
    }

    public void setIdMulta(int idMulta) {
        this.idMulta = idMulta;
    }

    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public String getFechaMulta() {
        return fechaMulta;
    }

    public void setFechaMulta(String fechaMulta) {
        this.fechaMulta = fechaMulta;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(String fechaPago) {
        this.fechaPago = fechaPago;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
    
    
}
