package com.ketzal.ketzal.model;

import javax.persistence.*;

@Entity
@Table(name = "productos")
public class productos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproductos",unique = true,nullable = false)
    private Long idProductos;
    private String nombre;
    private String imagen;
    private String descripcion;
    private double precio;
    private double gramaje;

    public productos(Long idProductos, String nombre, String imagen, String descripcion, double precio, double gramaje) {
        this.idProductos = idProductos;
        this.nombre = nombre;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gramaje = gramaje;
    }

    public productos() {
    }

    public Long getIdProductos() {
        return idProductos;
    }

    public void setIdProductos(Long idProductos) {
        this.idProductos = idProductos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getGramaje() {
        return gramaje;
    }

    public void setGramaje(double gramaje) {
        this.gramaje = gramaje;
    }
}



