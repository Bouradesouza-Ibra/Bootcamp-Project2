package Clientorders;

public class ChildOrder {
    String childOrderId;
    String parentId;
    String symbol;
    String side;
    int quantity;
    int filledQuantity;

    public ChildOrder(String childOrderId, String parentId, String symbol, String side, int quantity, int filledQuantity) {
        this.childOrderId = childOrderId;
        this.parentId = parentId;
        this.symbol = symbol;
        this.side = side;
        this.quantity = quantity;
        this.filledQuantity = filledQuantity;
    }
}
