package task4;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Документ отгрузки со склада.
 * Бывает двух типов: перемещение (на другой склад) и продажа (покупателю).
 */
@SuppressWarnings("unused")
public abstract class ShipmentDocument2 {
    public static final int DEFAULT_AMOUNT = 0;

    /**
     * GUID документа
     */
    protected UUID documentId;
    /**
     * дата документа
     */
    protected LocalDate documentDate;
    /**
     * склад отгрузки
     */
    protected Storage senderStorage;
    /**
     * набор товаров
     */
    protected Item[] items;

    public ShipmentDocument2(UUID documentId, LocalDate documentDate,
                             Storage senderStorage, Item... items) {
        this.documentId = documentId;
        this.documentDate = documentDate;
        this.senderStorage = senderStorage;
        this.items = items;
    }

    /**
     * Суммарная стоимость товаров в документе.
     */
    public double totalAmount() {
        double sum = 0;
        for (Item item : items) {
            sum += item.amount();
        }
        return sum;
    }

    /**
     * Стоимость товара с переданным id.
     */
    public double itemAmount(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item.amount();
            }
        }
        return DEFAULT_AMOUNT;
    }

    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    protected double promoSum(String[] promoArticles, double discount) {
        double sum = 0;
        for (var item : items) {
            for (var promoArticle : promoArticles) {
                if (item.getArticle().equals(promoArticle)) {
                    sum += getAmount(item, discount);
                    break;
                }
            }
        }

        return sum;
    }

    protected abstract double getAmount(Item item, double discount);

    public static class Item {
        private final UUID id;          // GUID товара
        private final String article;   // артикул товара
        private final String title;     // название товара
        private final double quantity;  // количество шт. товара
        private final double price;     // цена товара

        public Item(UUID id, String article, String title, double quantity, double price) {
            this.id = id;
            this.article = article;
            this.title = title;
            this.quantity = quantity;
            this.price = price;
        }

        public double amount() {
            return Math.round(quantity * price * 100) / 100.0;
        }

        public UUID getId() {
            return id;
        }

        public String getArticle() {
            return article;
        }

        public String getTitle() {
            return title;
        }

        public double getQuantity() {
            return quantity;
        }

        public double getPrice() {
            return price;
        }
    }

    public static class Storage {
        private final String title;
        private final String owner;

        public Storage(String title, String owner) {
            this.title = title;
            this.owner = owner;
        }

        public String getTitle() {
            return title;
        }

        public String getOwner() {
            return owner;
        }

    }

    public Item[] getItems() {
        return items;
    }

    public LocalDate getDocumentDate() {
        return documentDate;
    }

    public Storage getSenderStorage() {
        return senderStorage;
    }

    public UUID getDocumentId() {
        return documentId;
    }
}