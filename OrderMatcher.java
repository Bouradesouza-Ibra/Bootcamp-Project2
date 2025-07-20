package clientorders;
import java.util.*;

public class OrderMatcher {
    // This method matches client and child orders to check how much was filled
    public static void reconcileOrders(List<ClientOrder> clients, List<ChildOrder> children) {
        // Loop through each client order
        for (ClientOrder client : clients) {
            int totalFilled = 0;  // Track how much is filled
            // Loop through child orders to find matches
            for (ChildOrder child : children) {
                // If child belongs to this client order
                if (child.parentId.equals(client.clientOrderId)) {
                    totalFilled += child.filledQuantity;  // Add filled amount
                }
            }
            // Check the fill status
            String status;
            if (totalFilled < client.quantity) {
                status = "PARTIALLY FILLED";
            } else if (totalFilled == client.quantity) {
                status = "FULLY FILLED";
            } else {
                status = "OVERFILLED";
            }
            // Show the result
            System.out.println("Client Order " + client.clientOrderId +
                               " | Symbol: " + client.symbol +
                               " | Filled: " + totalFilled + " / " + client.quantity +
                               " | Status: " + status);
        }
    }
}
