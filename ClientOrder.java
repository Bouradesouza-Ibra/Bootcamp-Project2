package Clientorders;

public class ClientOrder {

    // These are the columns in the CSV

    String clientOrderId;

    String symbol;

    String side;

    int quantity;


    // Constructor 

    public ClientOrder(String clientOrderId, String symbol, String side, int quantity) {

        this.clientOrderId = clientOrderId;

        this.symbol = symbol;

        this.side = side;

        this.quantity = quantity;

    }


    // This method will help us print it nicely

    public String toString() {

        return "Client Order " + clientOrderId + 

               " | Symbol: " + symbol + 

               " | Side: " + side + 

               " | Quantity: " + quantity;

    }

}