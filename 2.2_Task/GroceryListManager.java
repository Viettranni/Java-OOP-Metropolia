import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, Double> groceryList = new HashMap<>();

    public void addItem(String item, Double price) {
        if (groceryList.containsKey(item)) {
            System.out.println("The item is duplicate, we won't be adding the item!");
        } else {
            groceryList.put(item, price);
            System.out.println("The " + item + " added to the list successfully");
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            groceryList.remove(item);
            System.out.println("Removed the " + item + " successfully");
        } else {
            System.out.println("Removing failed, the " + item + " is not in the basket!");
        }
    }

    public void displayList() {
        System.out.println("Opening the Grocery List:");
        for (String item : groceryList.keySet()) {
            System.out.println(item + ": $" + groceryList.get(item));
        }
    }

    public boolean checkItem(String item) {
        if (groceryList.containsKey(item)) {
            System.out.println( "The grocery list does contain the " + item );
            return true;
        } else {
            System.out.println("The grocery list doesn't include the " + item );
            return false; 
        }
    }

    public void calculateTotalCost() {
        double totalCost = 0;

        for ( String getPrice : groceryList.keySet()) {
            double cost = groceryList.get(getPrice);
            totalCost += cost;
        }

        System.out.println("The total cost of the List: $" + totalCost);
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Grocery List!");
        System.out.println("Let's add a few items to the grocery list: ");

        GroceryListManager groceryList = new GroceryListManager();

        // Adding some random items
        groceryList.addItem("ironman", 500.52);
        groceryList.addItem("hulk", 42.21);
        groceryList.addItem("captain", 63.23);

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

    }
}