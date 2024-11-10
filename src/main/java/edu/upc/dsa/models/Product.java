package edu.upc.dsa.models;

import edu.upc.dsa.util.RandomUtils;

public class Product {

    String id;
    String name;
    Integer prize;
    Integer quantity;

    public Product() {
        this.setId(RandomUtils.getId());
    }

    public Product(String name, Integer prize, Integer quantity) {
        this(null, name, prize, quantity);
    }

    public Product(String id, String name, Integer prize, Integer quantity) {
        this();
        if (id != null) this.setId(id);
        this.setPrize(prize);
        this.setName(name);
        this.setQuantity(quantity);
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrize() {
        return this.prize;
    }

    public void setPrize(Integer prize) {
        this.prize = prize;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product [id=" + id + ", Name=" + name + ", prize=" + prize + ", quantity=" + quantity + "]";
    }

}