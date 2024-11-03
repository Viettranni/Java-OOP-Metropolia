
class GroceryItem {
    private String itemName;
    private double price;
    private String category;
    private int quantity;

    public GroceryItem(String itemName, double price, String category, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}