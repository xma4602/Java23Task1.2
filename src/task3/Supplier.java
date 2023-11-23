package task3;

public abstract class Supplier {
    protected int inn;
    protected String title;
    protected String address;

    public int getInn() {
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

    public void setInn(int inn) {
        this.inn = inn;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
