import java.util.HashMap;

class ShoppingList {
    private String name;
    private HashMap<String, Integer> items; // Store items with their quantities

    public ShoppingList(String name) {
        this.name = name;
        this.items = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    // Add item with quantity
    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
        System.out.println("Added " + quantity + " of " + item + " to " + name + " list.");
    }

    // Remove item from the list
    public void removeItem(String item) {
        if (items.containsKey(item)) {
            items.remove(item);
            System.out.println("Removed " + item + " from " + name + " list.");
        } else {
            System.out.println("Item " + item + " not found in " + name + " list.");
        }
    }

    // Display all items in the list with quantities
    public void displayList() {
        System.out.println("Items in the " + name + " shopping list:");
        for (String item : items.keySet()) {
            System.out.println("  " + item + " - Quantity: " + items.get(item));
        }
    }
}
