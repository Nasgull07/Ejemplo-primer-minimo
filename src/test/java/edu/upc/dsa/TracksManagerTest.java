package edu.upc.dsa;

import edu.upc.dsa.exceptions.ProductNotFoundException;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.Pedido;
import edu.upc.dsa.ProductsManagerImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TracksManagerTest {
    ProductManager tm;

    @Before
    public void setUp() {
        tm = new ProductsManagerImpl();
        tm.RealizarPedido("1", List.of(new Product("Product1", 10, 2)), "Pedido1", 20);
        tm.RealizarPedido("2", List.of(new Product("Product2", 15, 1)), "Pedido2", 15);
    }

    @After
    public void tearDown() {
        if (tm != null) {
            tm.clear();
        }
        tm = null;
    }

    @Test
    public void testRealizarPedido() {
        Pedido pedido = tm.RealizarPedido("3", List.of(new Product("Product3", 20, 1)), "Pedido3", 20);
        Assert.assertNotNull(pedido);
        Assert.assertEquals("3", pedido.getId());
        Assert.assertEquals("Pedido3", pedido.getNombre());
        Assert.assertEquals(20, pedido.getPrecio().intValue());
        Assert.assertEquals(1, pedido.getProducts().size());
        Assert.assertEquals("Product3", pedido.getProducts().get(0).getName());
    }

    @Test
    public void testServirPedido() {
        Pedido pedido = tm.ServirPedido("1", List.of(new Product("Product1", 10, 2)), "Pedido1", 20);
        Assert.assertNotNull(pedido);
        Assert.assertEquals("1", pedido.getId());
        Assert.assertEquals("Pedido1", pedido.getNombre());
        Assert.assertEquals(20, pedido.getPrecio().intValue());
        Assert.assertEquals(1, pedido.getProducts().size());
        Assert.assertEquals("Product1", pedido.getProducts().get(0).getName());
    }
}