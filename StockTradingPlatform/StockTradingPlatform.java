import java.util.*;

public class StockTradingPlatform {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Market stocks
        HashMap<String, Stock> market = new HashMap<>();
        market.put("TCS", new Stock("TCS", 3500));
        market.put("INFY", new Stock("INFY", 1500));
        market.put("WIPRO", new Stock("WIPRO", 500));

        // User with initial balance
        User user = new User(10000);

        int choice;

        do {
            System.out.println("\n=====  STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n Market Data:");
                    for (Stock s : market.values()) {
                        s.displayStock();
                    }
                    break;

                case 2:
                    System.out.print("Enter stock name: ");
                    String buyName = sc.next().toUpperCase();

                    if (market.containsKey(buyName)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        user.buyStock(buyName, market.get(buyName).price, qty);
                    } else {
                        System.out.println(" Stock not found!");
                    }
                    break;

                case 3:
                    System.out.print("Enter stock name: ");
                    String sellName = sc.next().toUpperCase();

                    if (market.containsKey(sellName)) {
                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        user.sellStock(sellName, market.get(sellName).price, qty);
                    } else {
                        System.out.println(" Stock not found!");
                    }
                    break;

                case 4:
                    user.showPortfolio(market);
                    break;

                case 5:
                    System.out.println(" Exiting... Thank you!");
                    break;

                default:
                    System.out.println(" Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}