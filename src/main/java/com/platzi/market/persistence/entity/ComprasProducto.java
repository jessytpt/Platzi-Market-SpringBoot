package com.platzi.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {
    //YA NO PODER LAS COLUMNAS QUE CORRESPONDEN A LA CLAVE COMPUESTA
    @EmbeddedId
    private ComprasProductoPK id;

    private Integer cantidad;
    private Double total;
    private Boolean estado;

    @ManyToOne
    @JoinColumn(name="id_compra",insertable = false,updatable = false)
    private Compra compras;

    @ManyToOne
    @JoinColumn(name="id_producto",insertable = false,updatable = false)
    private Producto productos;

    public void setId(ComprasProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public ComprasProductoPK getId() {
        return id;
    }
}
