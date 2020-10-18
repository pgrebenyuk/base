package base.entity;

public class Article {

    private int id;
    private String name;
    private double price;
    private int manufacturerId;

    public Article() {
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