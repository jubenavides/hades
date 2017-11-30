/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.hades.modelo;

/**
 *
 * @author Eduardo Vera
 */
public class Reserva {
    
    private String identificacion;
    private String nombre;
    private String pais;
    private String direccion;
    private String telefono;
    private String email;
    private String tipoCrucero;
    private String tipoCamarote;
    private String tipoRecorrido;
    private String tipoAlimento;

    public Reserva() {
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
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

    public String getTipoCrucero() {
        return tipoCrucero;
    }

    public void setTipoCrucero(String tipoCrucero) {
        this.tipoCrucero = tipoCrucero;
    }

    public String getTipoCamarote() {
        return tipoCamarote;
    }

    public void setTipoCamarote(String tipoCamarote) {
        this.tipoCamarote = tipoCamarote;
    }

    public String getTipoRecorrido() {
        return tipoRecorrido;
    }

    public void setTipoRecorrido(String tipoRecorrido) {
        this.tipoRecorrido = tipoRecorrido;
    }

    public String getTipoAlimento() {
        return tipoAlimento;
    }

    public void setTipoAlimento(String tipoAlimento) {
        this.tipoAlimento = tipoAlimento;
    }

    @Override
    public String toString() {
        return "Reserva{" + "identificacion=" + identificacion + ", nombre=" + nombre + ", pais=" + pais + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + ", tipoCrucero=" + tipoCrucero + ", tipoCamarote=" + tipoCamarote + ", tipoRecorrido=" + tipoRecorrido + ", tipoAlimento=" + tipoAlimento + '}';
    }

    
}
