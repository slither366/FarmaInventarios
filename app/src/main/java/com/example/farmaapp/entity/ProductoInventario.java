package com.example.farmaapp.entity;

public class ProductoInventario {

    private String coProducto;
    private String coLaboratorio;
    private String inProdFraccionado;
    private Integer vaFraccion;
    private Integer caEntero;
    private Integer caFraccion;
    private String nuAnaquel;
    private String nuAnaquelConcat = "";

    public ProductoInventario(String coProducto, String coLaboratorio, String inProdFraccionado, int vaFraccion, int caEntero, int caFraccion, String nuAnaquel) {
        this.coProducto = coProducto;
        this.coLaboratorio = coLaboratorio;
        this.inProdFraccionado = inProdFraccionado;
        this.vaFraccion = vaFraccion;
        this.caEntero = caEntero;
        this.caFraccion = caFraccion;
        this.nuAnaquel = nuAnaquel;
        this.nuAnaquelConcat = this.nuAnaquelConcat + "," + nuAnaquel;
    }

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }

    public String getCoLaboratorio() {
        return coLaboratorio;
    }

    public void setCoLaboratorio(String coLaboratorio) {
        this.coLaboratorio = coLaboratorio;
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

    public Integer getCaEntero() {
        return caEntero;
    }

    public void setCaEntero(Integer caEntero) {
        this.caEntero = caEntero;
    }

    public Integer getCaFraccion() {
        return caFraccion;
    }

    public void setCaFraccion(Integer caFraccion) {
        this.caFraccion = caFraccion;
    }

    public String getNuAnaquel() {
        return nuAnaquel;
    }

    public void setNuAnaquel(String nuAnaquel) {
        this.nuAnaquel = nuAnaquel;
    }

    public String getNuAnaquelConcat() {
        return nuAnaquelConcat;
    }

    public void setNuAnaquelConcat(String nuAnaquelConcat) {
        this.nuAnaquelConcat = nuAnaquelConcat;
    }
}
