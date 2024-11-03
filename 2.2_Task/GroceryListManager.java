import java.util.HashMap;
import java.util.Map;

public class GroceryListManager {
    private HashMap<String, HashMap<String, Double>> groceryList = new HashMap<>();

    public void addItem(String item, Double price, String category) {
        // If the category doesn't exist, create a new inner HashMap
        groceryList.putIfAbsent(category, new HashMap<>());

        // Check for duplicates in the category before adding
        if (groceryList.get(category).containsKey(item)) {
            System.out.println("The item '" + item + "' is duplicate in category '" + category + "', we won't be adding it!");
        } else {
            // Add the item to the specified category
            groceryList.get(category).put(item, price);
            System.out.println("The item '" + item + "' added to the category '" + category + "' successfully.");
        }
    }

    public void removeItem(String item) {
        // Loop through categories to find and remove the item
        boolean found = false;
        for (String category : groceryList.keySet()) {
            if (groceryList.get(category).containsKey(item)) {
                groceryList.get(category).remove(item);
                System.out.println("Removed the item '" + item + "' successfully from category '" + category + "'.");
                found = true;
                break; 
            }
        }
        if (!found) {
            System.out.println("Removing failed, the item '" + item + "' is not in the grocery list!");
        }
    }

    public void displayList() {
        System.out.println("Opening the Grocery List:");
        for (String category : groceryList.keySet()) {
            System.out.println("Category: " + category);
            for (Map.Entry<String, Double> entry : groceryList.get(category).entrySet()) {
                System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
            }
        }
    }

    public boolean checkItem(String item) {
        for (String category : groceryList.keySet()) {
            if (groceryList.get(category).containsKey(item)) {
                System.out.println("The grocery list does contain the item '" + item + "' in category '" + category + "'.");
                return true;
            }
        }
        System.out.println("The grocery list doesn't include the item '" + item + "'.");
        return false;
    }

    public void calculateTotalCost() {
        double totalCost = 0;

        for (String category : groceryList.keySet()) {
            for (double cost : groceryList.get(category).values()) {
                totalCost += cost;
            }
        }

        System.out.println("The total cost of the grocery list: $" + totalCost);
    }

    public void displayByCategory(String category) {
        if (groceryList.containsKey(category)) {
            System.out.println("Items in category '" + category + "':");
            for (Map.Entry<String, Double> entry : groceryList.get(category).entrySet()) {
                System.out.println("  " + entry.getKey() + ": $" + entry.getValue());
            }
        } else {
            System.out.println("No items found in category '" + category + "'.");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Grocery List!");
        System.out.println("Let's add a few items to the grocery list:");

        GroceryListManager groceryList = new GroceryListManager();

        // Adding some random items
        groceryList.addItem("ironman", 500.52, "Hero");
        groceryList.addItem("hulk", 42.21, "Villain");
        groceryList.addItem("captain", 63.23, "Hero");

        // Displaying the entire list
        groceryList.displayList();

        // Checking if the apple is in the list
        groceryList.checkItem("ironman");

        // Removing an item from the list
        groceryList.removeItem("captain");

        // Displaying the list again
        groceryList.displayList();

        // Calculating the total cost
        System.out.println("Calculating the total cost...");
        groceryList.calculateTotalCost();

        // Displaying items by category
        System.out.println("Displaying items in the 'Hero' category:");
        groceryList.displayByCategory("Hero");

        System.out.println("Displaying items in the 'Villain' category:");
        groceryList.displayByCategory("Villain");

        // Shouldn't return anything
        System.out.println("Displaying items in the 'Fruits' category (non-existent):");
        groceryList.displayByCategory("Fruits");
    }
}
