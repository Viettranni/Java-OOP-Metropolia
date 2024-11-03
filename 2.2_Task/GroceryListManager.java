import java.util.ArrayList;
import java.util.List;

public class GroceryListManager {
    
    private List<GroceryItem> groceryList = new ArrayList<>();

    public void addItem(String itemName, double price, String category, int quantity) {
        // Check for duplicates
        for (GroceryItem item : groceryList) {
            if (item.getItemName().equals(itemName) && item.getCategory().equals(category)) {
                // Update quantity if item already exists
                item.setQuantity(item.getQuantity() + quantity);
                System.out.println("The item '" + itemName + "' already exists in category '" + category + "'. Quantity updated.");
                return;
            }
        }
        // Add new item
        groceryList.add(new GroceryItem(itemName, price, category, quantity));
        System.out.println("The item '" + itemName + "' added to the category '" + category + "' successfully with quantity: " + quantity);
    }

    public void updateQuantity(String itemName, int newQuantity) {
        for (GroceryItem item : groceryList) {
            if (item.getItemName().equals(itemName)) {
                item.setQuantity(newQuantity);
                System.out.println("Updated the quantity of item '" + itemName + "' to " + newQuantity + ".");
                return;
            }
        }
        System.out.println("Updating failed, the item '" + itemName + "' is not in the grocery list!");
    }

    public void displayList() {
        System.out.println("Opening the Grocery List:");
        for (GroceryItem item : groceryList) {
            System.out.println("Item: " + item.getItemName() + ", Price: $" + item.getPrice() + ", Category: " + item.getCategory() + ", Quantity: " + item.getQuantity());
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available items in the grocery list:");
        boolean found = false;
        for (GroceryItem item : groceryList) {
            if (item.getQuantity() > 0) {
                System.out.println("  " + item.getItemName() + ": $" + item.getPrice() + ", Quantity: " + item.getQuantity());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No available items in the grocery list.");
        }
    }

    public boolean checkItem(String itemName) {
        for (GroceryItem item : groceryList) {
            if (item.getItemName().equals(itemName)) {
                System.out.println("The grocery list does contain the item '" + itemName + "'.");
                return true;
            }
        }
        System.out.println("The grocery list doesn't include the item '" + itemName + "'.");
        return false;
    }

    public void calculateTotalCost() {
        double totalCost = 0;
        for (GroceryItem item : groceryList) {
            totalCost += item.getPrice() * item.getQuantity(); // Total cost based on quantity
        }
        System.out.println("The total cost of the grocery list: $" + totalCost);
    }

    public void displayByCategory(String category) {
        System.out.println("Items in category '" + category + "':");
        boolean found = false;
        for (GroceryItem item : groceryList) {
            if (item.getCategory().equals(category)) {
                System.out.println("  " + item.getItemName() + ": $" + item.getPrice() + ", Quantity: " + item.getQuantity());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No items found in category '" + category + "'.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Grocery List!");
        GroceryListManager groceryList = new GroceryListManager();

        // Adding some items
        groceryList.addItem("ironman", 500.52, "Hero", 5);
        groceryList.addItem("hulk", 42.21, "Villain", 2);
        groceryList.addItem("captain", 63.23, "Hero", 0);

        // Displaying the entire list
        groceryList.displayList();

        // Displaying available items
        groceryList.displayAvailableItems();

        // Checking if an item is in the list
        groceryList.checkItem("ironman");

        // Updating quantity of an item
        groceryList.updateQuantity("hulk", 4);

        // Displaying the list again
        groceryList.displayList();

        // Calculating the total cost
        groceryList.calculateTotalCost();

        // Displaying items by category
        groceryList.displayByCategory("Hero");
        groceryList.displayByCategory("Villain");
        groceryList.displayByCategory("Fruits"); // Non-existent category
    }
}