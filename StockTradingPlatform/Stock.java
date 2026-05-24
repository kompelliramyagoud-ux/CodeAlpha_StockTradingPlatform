public class Stock {
    String name;
    double price;

    public Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void displayStock() {
        System.out.println(name + " - Rs." + price);
    }
}