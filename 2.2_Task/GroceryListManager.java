import java.util.HashMap;

public class GroceryListManager {
    private HashMap<String, ShoppingList> shoppingLists;

    public GroceryListManager() {
        this.shoppingLists = new HashMap<>();
    }

    // Create a new shopping list
    public void createShoppingList(String name) {
        if (shoppingLists.containsKey(name)) {
            System.out.println("A shopping list with the name '" + name + "' already exists.");
        } else {
            shoppingLists.put(name, new ShoppingList(name));
            System.out.println("Created new shopping list: " + name);
        }
    }

    // Add item to a specific shopping list
    public void addItemToShoppingList(String listName, String item, int quantity) {
        ShoppingList list = shoppingLists.get(listName);
        if (list != null) {
            list.addItem(item, quantity);
        } else {
            System.out.println("Shopping list '" + listName + "' does not exist.");
        }
    }

    // Remove item from a specific shopping list
    public void removeItemFromShoppingList(String listName, String item) {
        ShoppingList list = shoppingLists.get(listName);
        if (list != null) {
            list.removeItem(item);
        } else {
            System.out.println("Shopping list '" + listName + "' does not exist.");
        }
    }

    // Display items in a specific shopping list
    public void displayShoppingList(String listName) {
        ShoppingList list = shoppingLists.get(listName);
        if (list != null) {
            list.displayList();
        } else {
            System.out.println("Shopping list '" + listName + "' does not exist.");
        }
    }

    // Display all shopping lists
    public void displayAllShoppingLists() {
        System.out.println("All Shopping Lists:");
        for (String listName : shoppingLists.keySet()) {
            System.out.println("  - " + listName);
        }
    }

    public static void main(String[] args) {
        GroceryListManager manager = new GroceryListManager();

        // Create shopping lists
        manager.createShoppingList("Backyard BBQ");
        manager.createShoppingList("Weekend Camping");

        // Add items to Backyard BBQ list
        manager.addItemToShoppingList("Backyard BBQ", "Steak", 4);
        manager.addItemToShoppingList("Backyard BBQ", "Charcoal", 1);
        manager.addItemToShoppingList("Backyard BBQ", "Lemonade", 2);

        // Add items to Weekend Camping list
        manager.addItemToShoppingList("Weekend Camping", "Tent", 1);
        manager.addItemToShoppingList("Weekend Camping", "Sleeping Bag", 2);
        manager.addItemToShoppingList("Weekend Camping", "Marshmallows", 3);

        // Display all lists
        manager.displayAllShoppingLists();

        // Display items in a specific shopping list
        System.out.println("\nDisplaying Backyard BBQ List:");
        manager.displayShoppingList("Backyard BBQ");

        System.out.println("\nDisplaying Weekend Camping List:");
        manager.displayShoppingList("Weekend Camping");

        // Remove item from a list and display again
        manager.removeItemFromShoppingList("Backyard BBQ", "Charcoal");
        System.out.println("\nDisplaying Backyard BBQ List after removing Charcoal:");
        manager.displayShoppingList("Backyard BBQ");
    }
}
