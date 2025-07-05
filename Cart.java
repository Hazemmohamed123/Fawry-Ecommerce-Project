import java.util.*;

public class Cart {
    private Map<Product, Integer> items = new HashMap<>();

    public void add(Product product, int qty) {
        if (!product.isAvailable(qty)) {
            throw new IllegalArgumentException("Not enough quantity for product: " + product.getName());
        }
        items.put(product, items.getOrDefault(product, 0) + qty);
    }

    public void checkout(Customer customer) {
        if (items.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        double subtotal = 0;
        double shipping = 0;
        List<Shippable> toShip = new ArrayList<>();

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product p = entry.getKey();
            int qty = entry.getValue();

            if (p instanceof ExpirableProduct && ((ExpirableProduct) p).isExpired()) {
                throw new IllegalStateException("Product expired: " + p.getName());
            }

            subtotal += p.getPrice() * qty;

            if (p instanceof Shippable) {
                for (int i = 0; i < qty; i++) {
                    toShip.add((Shippable) p);
                    shipping += 10;
                }
            }
        }

        double total = subtotal + shipping;

        if (!customer.canAfford(total)) {
            throw new IllegalStateException("Insufficient balance");
        }

        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            entry.getKey().reduceQuantity(entry.getValue());
        }

        customer.pay(total);

        if (!toShip.isEmpty()) {
            ShippingService.printShippingNotice(toShip);
        }

        System.out.println("\n** Checkout receipt **");
        for (Map.Entry<Product, Integer> entry : items.entrySet()) {
            System.out.printf("%dx %-10s %.0f%n", entry.getValue(), entry.getKey().getName(),
                    entry.getKey().getPrice() * entry.getValue());
        }
        System.out.println("----------------------");
        System.out.println("Subtotal       " + subtotal);
        System.out.println("Shipping       " + shipping);
        System.out.println("Amount         " + total);
        System.out.println("Customer Balance " + customer.getBalance());
    }
}