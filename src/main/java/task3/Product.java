package task3;

public class Product {
    private String productNumber;
    private String title;
    private long cost;
    private Supplier supplier;

    public Product(String productNumber, String title,
                   long cost, Supplier supplier) {
        this.productNumber = productNumber;
        this.title = title;
        this.cost = cost;
        this.supplier = supplier;
    }

    public Supplier getSupplier() {
        return supplier;
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
