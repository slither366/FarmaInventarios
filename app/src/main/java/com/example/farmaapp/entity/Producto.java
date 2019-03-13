package com.example.farmaapp.entity;

public class Producto {

    private String codigo;
    private String Nombre;
    private String anaquel;
    private String anaquelTodos;
    private String cantEntero;
    private String cantFraccion;

    public Producto(String codigo, String nombre, String anaquel, String cantEntero, String cantFraccion) {
        this.codigo = codigo;
        this.Nombre = nombre;
        this.anaquel = anaquel;
        //this.anaquelTodos = anaquelTodos;
        this.cantEntero = cantEntero;
        this.cantFraccion = cantFraccion;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getAnaquel() {
        return anaquel;
    }

    public void setAnaquel(String anaquel) {
        this.anaquel = anaquel;
    }

    public String getAnaquelTodos() {
        return anaquelTodos;
    }

    public void setAnaquelTodos(String anaquelTodos) {
        this.anaquelTodos = anaquelTodos;
    }

    public String getCantEntero() {
        return cantEntero;
    }

    public void setCantEntero(String cantEntero) {
        this.cantEntero = cantEntero;
    }

    public String getCantFraccion() {
        return cantFraccion;
    }

    public void setCantFraccion(String cantFraccion) {
        this.cantFraccion = cantFraccion;
    }
}
