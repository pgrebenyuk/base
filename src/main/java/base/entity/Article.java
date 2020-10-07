package base.entity;

public class Article {
    private int id;
    private String article;
    private double price;
    private int manufacturerId;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(int manufacturer) {
        this.manufacturerId = manufacturer;
    }

    @Override
    public String toString() {
        String string = "id=" + id + ": article=" + article + ": price="
                + price + ": idManufacturer=" + manufacturerId;
        return string;
    }
}