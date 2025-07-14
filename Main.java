package Clientorders;

import java.util.List;


public class Main {

    public static void main(String[] args) {

        try {

            ClientReaderThread clientThread = new ClientReaderThread();

            ChildReaderThread childThread = new ChildReaderThread();

            clientThread.start();

            childThread.start();

            

            clientThread.join();

            childThread.join();


            List<ClientOrder> clients = clientThread.getClients();

            List<ChildOrder> children = childThread.getChildren();


            OrderMatcher.reconcileOrders(clients, children);


        } catch (Exception e) {

            System.out.println("Oops! " + e.getMessage());

        }

    }

}