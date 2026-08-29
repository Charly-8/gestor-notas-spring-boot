package com.charly.gestornotas.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Nota {

    /*
    Qué hace cada anotación:

    @Entity — le dice a Hibernate que esta clase representa una tabla en la base de datos.
    @Id — marca id como la llave primaria.
    @GeneratedValue(strategy = GenerationType.IDENTITY) — hace que el id se autoincremente solo (1, 2, 3...), no lo tienes que asignar tú.
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String contenido;
    private LocalDateTime fechaCreacion;

    /*
    @ManyToOne — le dice a Hibernate: "muchas Nota pueden apuntar a una Categoria." Se pone del lado de Nota porque es Nota la que tiene "el muchos" (muchas notas pueden compartir la misma categoría).
    @JoinColumn(name = "categoria_id") — le dice explícitamente qué nombre le vas a dar a la columna que va a actuar como llave foránea en la tabla NOTA. Sin esto, Hibernate elegiría un nombre automático (más feo), así que es buena práctica ponerlo tú mismo.
    El tipo del campo ya no es String, es Categoria — ahora Nota tiene una referencia directa al objeto completo de categoría, no solo un texto suelto.
    */

    @ManyToOne
    @JoinColumn(name="categoria_id")
    private Categoria categoria;

    // Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getCategoria() {
        return categoria.getNombre();
    }

    public void setCategoria(String nombreCategoria) {
        this.categoria.setNombre(nombreCategoria);
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
