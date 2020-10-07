package base.entity;

public class Manufacturers {
    private Integer id;
    private String manufacturer;

    public Manufacturers() {
    }

    public Manufacturers(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Manufacturers(Integer id, String manufacturer) {
        this.id = id;
        this.manufacturer = manufacturer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturers) {
        this.manufacturer = manufacturers;
    }
}
