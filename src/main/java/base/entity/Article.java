package base.entity;

import javax.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "id_article")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "article")
    private String name;

    @Column(name = "price")
    private double price;

    //тепер хібернейт дає прикольну можливість,
    // можна щоб сюди з бази зразу підтягувався кокуретний виробник цього товару
    //почитай про анотації OneToOne, OneToMany, ManyToMany
    //реалізуй те, щоб тут був виробник
    //скоріше всього після цього вюшки ляжуть, того треба буде перевірити все
    @Column(name = "id_manufacturer")
    private int manufacturerId;

    public Article() {
    }

    public Article(String name, double price, int manufacturerId) {
        this.name = name;
        this.price = price;
        this.manufacturerId = manufacturerId;
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