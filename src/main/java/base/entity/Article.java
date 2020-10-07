package base.entity;

public class Article {
    private int id;
    private String article;
    private double price;
    private int manufacturerId;

    //зараз ідея каже, що ти не використовуєш цей метод, видали його, поки він не треба
    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //зараз ідея каже, що ти не використовуєш цей метод, видали його, поки він не треба
    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    //зараз ідея каже, що ти не використовуєш цей метод, видали його, поки він не треба
    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    //зараз ідея каже, що ти не використовуєш цей метод, видали його, поки він не треба
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