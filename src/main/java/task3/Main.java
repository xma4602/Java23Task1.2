package task3;

import java.util.Scanner;

public class Main {

    private static Manufacturer[] manufacturers;
    private static Dealer[] dealers;
    private static Product[] products;

    public static void main(String[] args) {
        fillData();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Введите артикул: ");
            String productNumber = scanner.next();
            SearchResult result = search(productNumber);
            if (result == null){
                System.out.println("\tНет данных по заданному артикулу");
            }
            else {
                System.out.println("\tНаименование товара: " + result.getProductTitle());
                System.out.println("\tЦена товара: " + result.getCost());
                System.out.println("\tНазвание поставщика: " + result.getSupplierTitle());
                System.out.println("\tАдерес поставщика: " + result.getSupplierAddress());
                if (result.getManufacturerTitle() != null){
                    System.out.println("\tПроизводитель: " + result.getManufacturerTitle());
                }
            }
        }
    }

    private static SearchResult search(String productNumber) {
        SearchResult result = null;
        for (var product : products) {
            if (product.getProductNumber().equals(productNumber)) {
                result = new SearchResult();
                result.setProductTitle(product.getTitle());
                Supplier supplier = product.getSupplier();
                result.setSupplierTitle(supplier.getTitle());
                result.setSupplierAddress(supplier.getAddress());
                if (supplier instanceof Dealer dealer){
                    result.setCost(calcCostWithMargin(product.getCost(), dealer.getMargin()));
                    result.setManufacturerTitle(dealer.getManufacturer().getTitle());
                }
                else {
                    result.setCost(product.getCost());
                    result.setManufacturerTitle(null);
                }
                break;
            }
        }

        return result;
    }

    private static double calcCostWithMargin(long cost, double margin) {
        return Math.round(cost * (100 + margin)) / 100.0;
    }

    private static void fillData() {
        manufacturers = new Manufacturer[]{
                new Manufacturer("1641055972", "производитель1", "Пушкина 17"),
                new Manufacturer("9188828600", "производитель2", "Ломоносова 8"),
                new Manufacturer("1412635153", "производитель3", "Ленина 22"),
        };
        dealers = new Dealer[]{
                new Dealer("3845780362", "диллер1", "Ефимова 13", manufacturers[0], 20.3),
                new Dealer("7420594409", "диллер2", "Петрова 49", manufacturers[1], 15.5),
        };
        products = new Product[]{
                new Product("186055091515", "тарелка", 200, manufacturers[0]),
                new Product("683990262996", "вилка", 50, manufacturers[0]),
                new Product("863294823444", "ложка", 50, manufacturers[0]),

                new Product("065700830349", "стол", 2000, manufacturers[1]),
                new Product("311611768243", "стул", 1500, manufacturers[1]),
                new Product("579978100285", "кресло", 2500, manufacturers[1]),
                new Product("354627764782", "тумбочка", 2000, manufacturers[1]),

                new Product("191894991863", "сковородка", 500, dealers[0]),
                new Product("220513523832", "чайник", 500, dealers[0]),
                new Product("240884783181", "кастрюля", 400, dealers[0]),
                new Product("840750815954", "кружка", 300, dealers[0]),

                new Product("959648968807", "комод", 3000, dealers[1]),
                new Product("993407594961", "шкаф", 5000, dealers[1]),
                new Product("052674546975", "кровать", 6000, dealers[1]),
                new Product("251992611491", "табуретка", 1000, dealers[1]),
        };
    }

    static class SearchResult {
        String productTitle;
        double cost;
        String supplierTitle;
        String supplierAddress;
        String manufacturerTitle;

        public double getCost() {
            return cost;
        }

        public String getManufacturerTitle() {
            return manufacturerTitle;
        }

        public String getProductTitle() {
            return productTitle;
        }

        public String getSupplierAddress() {
            return supplierAddress;
        }

        public String getSupplierTitle() {
            return supplierTitle;
        }

        public void setCost(double cost) {
            this.cost = cost;
        }

        public void setProductTitle(String productTitle) {
            this.productTitle = productTitle;
        }

        public void setSupplierAddress(String supplierAddress) {
            this.supplierAddress = supplierAddress;
        }

        public void setManufacturerTitle(String manufacturerTitle) {
            this.manufacturerTitle = manufacturerTitle;
        }

        public void setSupplierTitle(String supplierTitle) {
            this.supplierTitle = supplierTitle;
        }
    }
}
