package clientorders;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;
public class ChildOrderReader {
    private static final MyLogger logger = MyLogger.getInstance();

    // Reads child orders from a CSV file and returns a list of valid child orders
    public static List<ChildOrder> readChildOrders(String fileName) throws IOException {
        List<ChildOrder> childOrders = new ArrayList<>();

        // Try to open and read the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = br.readLine(); // Skip the header row

            // Read each line from the file
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");// split into pieces based on commas

                try {
                    // Get each value from the line
                    String childId = parts[0].trim();
                    String parentId = parts[1].trim();
                    String symbol = parts[2].trim();
                    String side = parts[3].trim();
                    int quantity = Integer.parseInt(parts[4].trim());
                    int filled = Integer.parseInt(parts[5].trim());
                    //  Validate the data
                    if (symbol.isEmpty() || side.isEmpty()) {
                        throw new InvalidOrderException("Missing symbol or side in child order: " + childId);
                    }
                    if (!side.equalsIgnoreCase("BUY") && !side.equalsIgnoreCase("SELL")) {
                        throw new InvalidOrderException("Invalid side value in child order: " + childId);
                    }
                    if (quantity <= 0 || filled < 0) {
                        throw new InvalidOrderException("Invalid quantity or filled value in child order: " + childId);
                    }
                    //  Create and add the valid child order to the list
                    ChildOrder order = new ChildOrder(childId, parentId, symbol, side, quantity, filled);
                    childOrders.add(order);

                } catch (InvalidOrderException ex) {
                    //️ Skip invalid row and log warning
                    logger.warning("Skipping invalid child order: " + ex.getMessage());
                }
            }
            //  Log the total number of valid orders read
            logger.info("Successfully read " + childOrders.size() + " valid child orders from " + fileName);

        } catch (Exception e) {
            //  Log and re throw if the file could not be read
            logger.error("Failed to read child orders from " + fileName + ": " + e.getMessage());
            throw e;
        }
        //  Return the list of valid child orders
        return childOrders;
    }
}
