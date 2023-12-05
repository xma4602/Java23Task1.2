package task4;

import java.time.LocalDate;
import java.util.UUID;

@SuppressWarnings("unused")
public class SaleShipmentDocument2 extends ShipmentDocument2 {
    /**
     * получатель (только для продажи)
     */
    private String customer;

    public SaleShipmentDocument2(UUID documentId, LocalDate documentDate,
                                 Storage senderStorage, String customer, Item... items) {
        super(documentId, documentDate, senderStorage, items);
        this.customer = customer;
    }

    /**
     * Является ли продажа оптовой для переданного минимального объема.
     * Для перемещений неприменимо!
     */
    public boolean isWholesale(double minQuantity) {
        double sumQuantity = 0;
        for (var item : items) {
            if (item.getQuantity() >= minQuantity) {
                return true;
            }
            sumQuantity += item.getQuantity();
        }
        return sumQuantity >= minQuantity;
    }

    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    public double promoSum(String[] promoArticles, double discount) {
        return super.promoSum(promoArticles, discount);
    }

    @Override
    protected double getAmount(Item item, double discount) {
        return Math.ceil(item.amount() * (100 - discount)) / 100.0;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }
}
