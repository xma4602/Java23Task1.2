package task3;

public class Dealer extends Supplier {

    private Manufacturer manufacturer;
    private double margin;

    public Dealer(String inn, String title, String address, Manufacturer manufacturer, double margin) {
        super(inn, title, address);
        this.manufacturer = manufacturer;
        this.margin = margin;
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
