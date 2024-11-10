package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.models.Product;

import java.util.List;

public interface ProductManager {

    public Pedido RealizarPedido(String id, List<Product> lista, String name, Integer prize);
    public Pedido ServirPedido(String id, List<Product> lista, String Name, Integer prize);
    public List<Pedido> ListadoPedidos(String name);
    public List<Product> ListadoProductosPorVenta();
    public List<Product> ListadoProductosPorPrecio();



    public void clear();
    public int size();
}
