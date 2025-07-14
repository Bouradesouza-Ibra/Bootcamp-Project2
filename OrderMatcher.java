package Clientorders;

import java.util.*;


public class OrderMatcher {

    public static void reconcileOrders(List<ClientOrder> clients, List<ChildOrder> children) {

        for (ClientOrder client : clients) {

            int totalFilled = 0;


            for (ChildOrder child : children) {

                if (child.parentId.equals(client.clientOrderId)) {

                    totalFilled += child.filledQuantity;

                }

            }


            String status;

            if (totalFilled < client.quantity) {

                status = "PARTIALLY FILLED";

            } else if (totalFilled == client.quantity) {

                status = "FULLY FILLED";

            } else {

                status = "OVERFILLED";

            }


            System.out.println("Client Order " + client.clientOrderId +

                               " | Symbol: " + client.symbol +

                               " | Filled: " + totalFilled + " / " + client.quantity +

                               " | Status: " + status);

        }

    }

}