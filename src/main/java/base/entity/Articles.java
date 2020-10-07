package base.entity;

public class Articles {
    private Integer id;
    private String article;
    private Double price;
    private Integer idManufacturer;

    public Articles() {
    }

    public Articles(String article, Double price, int idManufacturer) {
        this.article = article;
        this.price = price;
        this.idManufacturer = idManufacturer;
    }

    public Articles(Integer id, String article, Double price, int idManufacturer) {
        this.id = id;
        this.article = article;
        this.price = price;
        this.idManufacturer = idManufacturer;
    }

    public Integer getId() {
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getManufacturer() {
        return idManufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.idManufacturer = manufacturer;
    }

}