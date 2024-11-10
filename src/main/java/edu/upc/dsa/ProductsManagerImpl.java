package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.Pedido;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;

public class ProductsManagerImpl implements ProductManager {
    private static ProductManager instance;
    protected List<Product> products;
    protected List<Pedido> pedidos;
    final static Logger logger = Logger.getLogger(ProductsManagerImpl.class);

    public ProductsManagerImpl() {
        this.products = new LinkedList<>();
        this.pedidos = new ArrayList<>();
    }

    public static ProductManager getInstance() {
        if (instance==null) instance = new ProductsManagerImpl();
        return instance;
    }
    @Override
    public int size() {
        int ret = this.products.size();
        logger.info("size " + ret);

        return ret;
    }



    @Override
    public List<Pedido> ListadoPedidos(String name) {
        logger.info("ListadoPedidos(name: " + name + ")");
        List<Pedido> result = new LinkedList<>();
        for (Pedido p : this.pedidos) {
            if (p.getNombre().equals(name)) {
                result.add(p);
            }
        }
        logger.info("ListadoPedidos result: " + result);
        return result;
    }

    @Override
    public List<Product> ListadoProductosPorVenta() {
        logger.info("ListadoProductosPorVenta()");
        this.products.sort((p1, p2) -> p2.getQuantity() - p1.getQuantity());
        logger.info("ListadoProductosPorVenta result: " + this.products);
        return this.products;
    }
    @Override
    public Pedido RealizarPedido(String id, List<Product> lista, String name, Integer prize) {
        logger.info("RealizarPedido(id: " + id + ", lista: " + lista + ", name: " + name + ", prize: " + prize + ")");
        Pedido pedido = new Pedido(id, name, prize, lista);
        this.pedidos.add(pedido);
        logger.info("Pedido realizado: " + pedido);
        return pedido;
    }
    @Override
    public Pedido ServirPedido(String id, List<Product> lista, String name, Integer prize) {
        logger.info("ServirPedido(id: " + id + ", lista: " + lista + ", name: " + name + ", prize: " + prize + ")");
        Pedido pedido = new Pedido(id, name, prize, products);
        for (Pedido p : this.pedidos) {
            if (pedido.getId().equals(id)) {
                this.pedidos.remove(p);
                logger.info("Pedido servido: " + p);
                return p;
            }
        }
        logger.warn("Pedido no encontrado: " + id);
        return null;
    }

    @Override
    public List<Product> ListadoProductosPorPrecio() {
        logger.info("ListadoProductosPorPrecio()");
        this.products.sort((p1, p2) -> p1.getPrize() - p2.getPrize());
        logger.info("ListadoProductosPorPrecio result: " + this.products);
        return this.products;
    }



    @Override
    public void clear() {
        this.products.clear();
    }
}