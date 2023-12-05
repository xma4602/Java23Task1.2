package task3;

public abstract class Supplier {
    protected String inn;
    protected String title;
    protected String address;

    public Supplier(String inn, String title, String address) {
        this.inn = inn;
        this.title = title;
        this.address = address;
    }

    public String getInn() {
        return inn;
    }

    public String getAddress() {
        return address;
    }

    public String getTitle() {
        return title;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
