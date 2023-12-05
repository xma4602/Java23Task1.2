package task4;

import java.time.LocalDate;
import java.util.UUID;

@SuppressWarnings("unused")
public class MovingShipmentDocument2 extends ShipmentDocument2 {
    protected Storage movingStorage;      // склад получения

    public MovingShipmentDocument2(UUID documentId, LocalDate documentDate, Storage senderStorage, Storage movingStorage, Item... items) {
        super(documentId, documentDate, senderStorage, items);
        this.movingStorage = movingStorage;
    }

    /**
     * Является ли перемещение внутренним (между складами одного владельца).
     */
    public boolean isInternalMovement() {
        return senderStorage.getOwner().equals(movingStorage.getOwner());
    }

    /**
     * Суммарная стоимость товаров, попадающих в список промо-акции.
     */
    public double promoSum(String[] promoArticles) {
        return super.promoSum(promoArticles, 1.0);
    }

    @Override
    protected double getAmount(Item item, double discount) {
        return Math.round(item.amount() * 100) / 100.0;
    }
}
