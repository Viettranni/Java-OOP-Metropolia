import java.util.List;
import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Double> cart = new HashMap<>();
    private double totalPrice = 0.0;
    private int itemCount = 0;

    public void addItem(String item, double price) {
        cart.put(item, price);
    }

    public int getItemCount() {
        itemCount = cart.size();
        return itemCount;
    }

    public void removeItem(String name) {
        cart.remove(name);
    }

    public double calculateTotal() {
        for (double value : cart.values()) {
            totalPrice += value;
        }
        return Math.round(totalPrice * 100.0) / 100.0; // Round to 2 decimal places
    }

}
