package base.entity;

//клас має називатись в однині Article
public class Articles {
    //використовуй примітиви
    //тут можна і простий int використовувати
    private Integer id;
    private String article;
    //тут можна і простий double використовувати
    private Double price;
    //тут можна і простий int використовувати
    //правильніша назва буде звуати як manufacturerId
    //коли будеш переназивати, то нажми правою клавішою -> Refactor -> Rename
    //воно покаже всі пмісця, де ця штука використовується
    private Integer idManufacturer;

    public Articles() {
    }

    //краще видалити, бо не використовується
    public Articles(String article, Double price, int idManufacturer) {
        this.article = article;
        this.price = price;
        this.idManufacturer = idManufacturer;
    }

    //краще видалити, бо не використовується
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

    // гетери і сетери, конструктори і ту стрінг зазвичай ніхто вручну не робить, їх генерують
    //нажимають правою клавішою в місці де хоч щоб створився код -> Generate
    //вискочить менюшка де можна вибрати, що генерувати
    public Integer getManufacturer() {
        return idManufacturer;
    }

    public void setManufacturer(int manufacturer) {
        this.idManufacturer = manufacturer;
    }

    @Override
    public String toString() {
        String string = "id=" + id + ": article=" + article + ": price="
                + price + ": idManufacturer=" + idManufacturer;
        return string;
    }
}