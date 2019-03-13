package com.example.farmaapp.entity;

public class ProductoBarra {

    private String coBarra;
    private String coProducto;

    public ProductoBarra(String coBarra, String coProducto) {
        this.coBarra = coBarra;
        this.coProducto = coProducto;
    }

    public String getCoBarra() {
        return coBarra;
    }

    public void setCoBarra(String coBarra) {
        this.coBarra = coBarra;
    }

    public String getCoProducto() {
        return coProducto;
    }

    public void setCoProducto(String coProducto) {
        this.coProducto = coProducto;
    }
}
