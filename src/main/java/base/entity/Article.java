package base.entity;

public class Article {

    private int id;
    private String article;
    private double price;
    private int manufacturerId;

    public void setId(int id) {
        this.id = id;
    }

    public void setArticle(String article) {
        this.article = article;
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

    public String getArticle() {
        return article;
    }

    public double getPrice() {
        return price;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    @Override
    public String toString() {
        String string = "id=" + id + ": article=" + article + ": price="
                + price + ": idManufacturer=" + manufacturerId;
        return string;
    }
}