package com.example.farmaapp.entity;

public class Producto {

    private String coProducto;
    private String deProducto;
    private String deUnidad;
    private String deUnidadFraccion;
    private String inProdFraccionado;
    private Integer vaFraccion;
    private String coLaboratorio;
    private String deLaboratorio;

    public Producto(String coProducto, String deProducto, String deUnidad, String deUnidadFraccion, String inProdFraccionado, Integer vaFraccion, String coLaboratorio, String deLaboratorio) {
        this.coProducto = coProducto;
        this.deProducto = deProducto;
        this.deUnidad = deUnidad;
        this.deUnidadFraccion = deUnidadFraccion;
        this.inProdFraccionado = inProdFraccionado;
        this.vaFraccion = vaFraccion;
        this.coLaboratorio = coLaboratorio;
        this.deLaboratorio = deLaboratorio;
    }

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }

    public String getDeProducto() {
        return deProducto;
    }

    public void setDeProducto(String deProducto) {
        this.deProducto = deProducto;
    }

    public String getDeUnidad() {
        return deUnidad;
    }

    public void setDeUnidad(String deUnidad) {
        this.deUnidad = deUnidad;
    }

    public String getDeUnidadFraccion() {
        return deUnidadFraccion;
    }

    public void setDeUnidadFraccion(String deUnidadFraccion) {
        this.deUnidadFraccion = deUnidadFraccion;
    }

    public String getInProdFraccionado() {
        return inProdFraccionado;
    }

    public void setInProdFraccionado(String inProdFraccionado) {
        this.inProdFraccionado = inProdFraccionado;
    }

    public Integer getVaFraccion() {
        return vaFraccion;
    }

    public void setVaFraccion(Integer vaFraccion) {
        this.vaFraccion = vaFraccion;
    }

    public String getCoLaboratorio() {
        return coLaboratorio;
    }

    public void setCoLaboratorio(String coLaboratorio) {
        this.coLaboratorio = coLaboratorio;
    }

    public String getDeLaboratorio() {
        return deLaboratorio;
    }

    public void setDeLaboratorio(String deLaboratorio) {
        this.deLaboratorio = deLaboratorio;
    }
}
