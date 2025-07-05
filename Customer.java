public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    public boolean canAfford(double amount) {
        return balance >= amount;
    }

    public void pay(double amount) {
        balance -= amount;
    }

    public double getBalance() {
        return balance;
    }
}