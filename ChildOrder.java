package clientorders;

// Represents a child order linked to a client order
public class ChildOrder {
    String childOrderId;     // ID of the child order
    String parentId;         // ID of the parent (client) order
    String symbol;           // Stock symbol
    String side;             // BUY or SELL
    int quantity;            // Quantity requested
    int filledQuantity;      // Quantity actually filled

    // Getter for child order ID
    public String getId() {
        return childOrderId;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Constructor to create a child order
    public ChildOrder(String childOrderId, String parentId, String symbol, String side, int quantity, int filledQuantity) {
        this.childOrderId = childOrderId;
        this.parentId = parentId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = filledQuantity;
    }

    // Returns a string summary of the order
    public String toString() {
        return "Child Order " + childOrderId + 
               " | Parent: " + parentId + 
               " | Symbol: " + symbol + 
               " | Side: " + side + 
               " | Quantity: " + quantity + 
               " | Filled: " + filledQuantity;
    }
}
