package task3;

public class Product {
    private String productNumber;
    private String title;
    private long cost;
    private Manufacturer manufacturer;

    public Product(String productNumber, String title,
                   long cost, Manufacturer manufacturer) {
        this.productNumber = productNumber;
        this.title = title;
        this.cost = cost;
        this.manufacturer = manufacturer;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public String getTitle() {
        return title;
    }

    public long getCost() {
        return cost;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }
}
