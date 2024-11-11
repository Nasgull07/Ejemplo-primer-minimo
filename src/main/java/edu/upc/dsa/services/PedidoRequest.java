package edu.upc.dsa.services;
import  edu.upc.dsa.models.Product;
import java.util.List;

public class PedidoRequest {
    private String id;
    private String name;
    private List<Product> product;
    private Integer prize;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }

    public Integer getPrize() {
        return prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }
}
