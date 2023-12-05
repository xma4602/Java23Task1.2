package task4;

import java.time.LocalDate;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        MovingShipmentDocument2 movingShipmentDocument2 = new MovingShipmentDocument2(UUID.randomUUID(), LocalDate.now(),
                new ShipmentDocument2.Storage("склад1", "владелец1"),
                new ShipmentDocument2.Storage("склад2", "владелец2"),
                new ShipmentDocument2.Item(UUID.randomUUID(), "42364", "товар1", 10, 25),
                new ShipmentDocument2.Item(UUID.randomUUID(), "87422", "товар2", 5, 789)
        );
        System.out.println("totalAmount " + movingShipmentDocument2.totalAmount());
        System.out.println("itemAmount" + movingShipmentDocument2.itemAmount("42364"));
        System.out.println("isInternalMovement " + movingShipmentDocument2.isInternalMovement());
        System.out.println("promoSum " + movingShipmentDocument2.promoSum(new String[]{"87422"}));
        System.out.println();


        SaleShipmentDocument2 saleShipmentDocument2 = new SaleShipmentDocument2(UUID.randomUUID(), LocalDate.now(),
                new ShipmentDocument2.Storage("склад3", "владелец3"),
                "покупатель1",
                new ShipmentDocument2.Item(UUID.randomUUID(), "323453", "товар3", 867, 123),
                new ShipmentDocument2.Item(UUID.randomUUID(), "872342", "товар4", 453, 123)
        );
        System.out.println("totalAmount " + saleShipmentDocument2.totalAmount());
        System.out.println("itemAmount" + saleShipmentDocument2.itemAmount("42364"));
        System.out.println("isWholesale " + saleShipmentDocument2.isWholesale(1000));
        System.out.println("promoSum " + saleShipmentDocument2.promoSum(new String[]{"87422"}, 50));
    }
}
