package com.palacio.productos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "productos")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private Long id;

    @NonNull
    @Column(name = "nombre_producto")
    private String nombreProducto;

    @NonNull
    @Column(name = "descripcion")
    private String descripcion;

    @NonNull
    @Column(name = "tipo_producto")
    private  int tipoProducto;

    @NonNull
    @Column(name = "categoria")
    private int categoria;

    @NonNull
    @Column(name = "estatus")
    private int estatus;

    @NonNull
    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

    @NonNull
    @Column(name = "fecha_modificacion")
    private Date fechaModificacion;
}
