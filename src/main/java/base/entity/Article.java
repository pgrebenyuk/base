package base.entity;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "article", length = 32)
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "id_manufacturer")
    private int manufacturerId;

    public Article() {
    }

    public Article(String name, double price, int manufacturerId) {
        this.name = name;
        this.price = price;
        this.manufacturerId = manufacturerId;
    }

    public Article(int id, String name, double price, int manufacturerId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.manufacturerId = manufacturerId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setManufacturerId(int manufacturer) {
        this.manufacturerId = manufacturer;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    @Override
    public String toString() {
        return "id=" + id + ": article=" + name
                + ": price=" + price
                + ": idManufacturer=" + manufacturerId;
    }

}