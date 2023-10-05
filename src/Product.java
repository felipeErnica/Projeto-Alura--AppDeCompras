import java.util.Comparator;

public class Product implements Comparable<Product> {

    private String itemName;
    private double price;

    public double getPrice() {
        return price;
    }

    public Product(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    public String toString(){
        return itemName + String.format(": R$ %.2f",price);
    }

    @Override
    public int compareTo(Product o) {
        return Double.compare(this.price,o.price);
    }
}
