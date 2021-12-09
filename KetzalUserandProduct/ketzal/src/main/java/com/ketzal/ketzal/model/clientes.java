package com.ketzal.ketzal.model;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class clientes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcontacto", unique = true, nullable = false)
    private Long idcontacto;
    private String nombre;
    private String correo;
    private String telefono;
    private String contrasena;

    public clientes(Long idcontacto, String nombre, String correo, String telefono, String contrasena) {
        this.idcontacto = idcontacto;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public clientes() {
    }

    public Long getIdcontacto() {
        return idcontacto;
    }

    public void setIdcontacto(Long idcontacto) {
        this.idcontacto = idcontacto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
