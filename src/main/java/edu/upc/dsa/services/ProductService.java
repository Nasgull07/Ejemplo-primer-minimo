

  package edu.upc.dsa.services;

import edu.upc.dsa.ProductManager;
import edu.upc.dsa.ProductsManagerImpl;
import edu.upc.dsa.models.Product;
import edu.upc.dsa.models.Pedido;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

    @Path("/products")
    public class ProductService {

        private ProductManager productManager;

        @GET
        @Path("/list/products")
        @Produces(MediaType.APPLICATION_JSON)
        public List<Product> getProducts() {
            return  productManager.ListadoProductosPorVenta();

        }

        @GET
        @Path("/list/productsPrecio")
        @Produces(MediaType.APPLICATION_JSON)
        public  List<Product> getProductsPrecio(){
            return  productManager.ListadoProductosPorPrecio();

        }

        @GET
        @Path("/list/pedidos")
        @Produces(MediaType.APPLICATION_JSON)
        public  List<Pedido> getPedidos(String name){
            return productManager.ListadoPedidos(name);

        }

        @POST
        @Path("/order")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response realizarPedido(PedidoRequest pedidoRequest) {
            Pedido newPedido = productManager.RealizarPedido(
                    pedidoRequest.getId(), pedidoRequest.getProduct(), pedidoRequest.getName(), pedidoRequest.getPrize());
            return Response.status(Response.Status.CREATED).entity(newPedido).build();
        }


        @POST
        @Path("/serve")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response servirPedido(Pedido pedido) {
            Pedido servedPedido = productManager.ServirPedido(pedido.getId(), pedido.getProductos(), pedido.getNombre(), pedido.getPrecio());
            if (servedPedido != null) {
                return Response.ok(servedPedido).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).build();
            }
        }
    }