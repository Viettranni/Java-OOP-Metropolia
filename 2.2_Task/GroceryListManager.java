import java.util.ArrayList;

public class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println("The item is duplicate, we won't be adding the item!");
        } else {
            groceryList.add(item);
            System.out.println("The " + item + " added to the list successfully");
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            groceryList.remove(item);
            System.out.println("Removed the " + item + " successfully");
        } else {
            System.out.println("Removing failed, the " + item + " is not in the basket!");
        }
    }

    public void displayList() {
        System.out.println("Opening the Grocery List:");
        for (String item : groceryList) {
            System.out.println(item);
        }
    }

    public boolean checkItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println( "The grocery list does contain the " + item );
            return true;
        } else {
            System.out.println("The grocery list doesn't include the " + item );
            return false; 
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome to our Grocery List!");
        System.out.println("Let's add a few items to the grocery list: ");

        GroceryListManager groceryList = new GroceryListManager();

        // Adding some random items
        groceryList.addItem("ironman");
        groceryList.addItem("hulk");
        groceryList.addItem("ironman");

        // Displaying the entire list
        groceryList.displayList();

        // Checking if the apple is in the list
        groceryList.checkItem("Apple");

        // Removing an item from the list
        groceryList.removeItem("Pear");

        // Displaying the list again
        groceryList.displayList();

    }
}