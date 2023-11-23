package task3;

public class Dealer extends Supplier {

    private Manufacturer manufacturer;
    private double margin;

    public Dealer(int inn, String title, String address) {
        this.inn = inn;
        this.title = title;
        this.address = address;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public double getMargin() {
        return margin;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setMargin(double margin) {
        this.margin = margin;
    }
}
