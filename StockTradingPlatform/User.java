import java.util.HashMap;

public class User {
    double balance;
    HashMap<String, Integer> portfolio;

    public User(double balance) {
        this.balance = balance;
        portfolio = new HashMap<>();
    }

    public void buyStock(String stockName, double price, int quantity) {
        double totalCost = price * quantity;

        if (balance >= totalCost) {
            balance -= totalCost;
            portfolio.put(stockName, portfolio.getOrDefault(stockName, 0) + quantity);
            System.out.println("Bought " + quantity + " shares of " + stockName);
        } else {
            System.out.println(" Insufficient balance!");
        }
    }

    public void sellStock(String stockName, double price, int quantity) {
        if (portfolio.containsKey(stockName) && portfolio.get(stockName) >= quantity) {
            portfolio.put(stockName, portfolio.get(stockName) - quantity);
            balance += price * quantity;
            System.out.println(" Sold " + quantity + " shares of " + stockName);
        } else {
            System.out.println(" Not enough shares to sell!");
        }
    }

    public void showPortfolio(HashMap<String, Stock> market) {
        System.out.println("\n Your Portfolio:");
        double totalValue = 0;

        for (String stockName : portfolio.keySet()) {
            int qty = portfolio.get(stockName);
            double price = market.get(stockName).price;
            double value = qty * price;
            totalValue += value;

            System.out.println(stockName + " - " + qty + " shares (Rs." + value + ")");
        }

        System.out.println(" Balance: Rs." + balance);
        System.out.println(" Total Portfolio Value: Rs." + (totalValue + balance));
    }
}