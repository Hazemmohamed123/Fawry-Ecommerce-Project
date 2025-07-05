import java.util.List;

public class ShippingService {
    public static void printShippingNotice(List<Shippable> items) {
        System.out.println("\n** Shipment notice **");
        double totalWeight = 0;
        for (Shippable s : items) {
            System.out.printf("1x %-10s %.0fg%n", s.getName(), s.getWeight() * 1000);
            totalWeight += s.getWeight();
        }
        System.out.printf("Total package weight %.1fkg%n", totalWeight);
    }
}