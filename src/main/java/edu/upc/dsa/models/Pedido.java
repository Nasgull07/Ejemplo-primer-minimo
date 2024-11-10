package edu.upc.dsa.models;
import java.util.List;
import java.util.Map;

public class Pedido {
    private String id;
    private String nombre;
    private Integer precio;
    private List<Product> productos;

    public Pedido(String id, String nombre, Integer precio, List<Product> productos) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.productos = productos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public List<Product> getProductos() {
        return productos;
    }

    public void setProductos(List<Product> productos) {
        this.productos = productos;
    }

    public List<Product> getProducts() {
        return productos;
    }
}