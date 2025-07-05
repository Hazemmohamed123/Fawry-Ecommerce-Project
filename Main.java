import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Hazem", 1000);

        ExpirableProduct cheese = new ExpirableProduct("Cheese", 100, 5, LocalDate.of(2025, 8, 1));
        ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150, 3, LocalDate.of(2025, 7, 30));
        ShippableProduct tv = new ShippableProduct("TV", 200, 2, 1.5);
        Product scratchCard = new Product("ScratchCard", 50, 10);

        Cart cart = new Cart();
        cart.add(cheese, 2);
        cart.add(biscuits, 1);
        cart.add(tv, 1);
        cart.add(scratchCard, 1);

        cart.checkout(customer);
    }
}