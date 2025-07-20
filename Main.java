package clientorders;

import java.util.List;
public class Main {
    private static final MyLogger logger = MyLogger.getInstance(); //  Singleton logger

    public static void main(String[] args) {
        try {
            logger.info("Starting order reconciliation program");

            // Create threads to read client and child orders
            logger.info("Launching reader threads...");
            ClientReaderThread clientThread = new ClientReaderThread();
            ChildReaderThread childThread = new ChildReaderThread();

            // Start both threads
            clientThread.start();
            childThread.start();

            // Wait for both threads to finish
            clientThread.join();
            childThread.join();
            logger.info("Reader threads completed successfully.");

            // Get the results from both threads
            List<ClientOrder> clients = clientThread.getClients();
            List<ChildOrder> children = childThread.getChildren();

            // Start matching
            logger.info("Matching orders...");
            OrderMatcher.reconcileOrders(clients, children);
            logger.info("Order matching complete.");

        } catch (Exception e) {
            // Log error if anything goes wrong
            logger.error("Something went wrong in Main: " + e.getMessage());
        }
    }
}
