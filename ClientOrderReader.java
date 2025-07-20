package clientorders;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;


public class ClientOrderReader {
	private static final MyLogger logger = MyLogger.getInstance();;
	
	// Reads client orders from a CSV file and returns a list of valid orders
	public static List<ClientOrder> readClientOrders(String fileName) throws IOException {
		List<ClientOrder> orders = new ArrayList<>();

		// Try to open and read the file
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String line;
			br.readLine(); // Skip the first line (header)

			// Read each line from the file
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(",");

				try {
					// Get each value from the line
					String id = parts[0].trim();
					String symbol = parts[1].trim();
					String side = parts[2].trim();
					int quantity = Integer.parseInt(parts[3].trim());

					// Validate the data
					if (symbol.isEmpty() || side.isEmpty()) {
						throw new InvalidOrderException("Missing symbol or side in client order: " + id);
					}
					if (!side.equalsIgnoreCase("BUY") && !side.equalsIgnoreCase("SELL")) {
						throw new InvalidOrderException("Invalid side value in client order: " + id);
					}
					if (quantity <= 0) {
						throw new InvalidOrderException("Invalid quantity in client order: " + id);
					}

					// Create and add the valid order to the list
					ClientOrder order = new ClientOrder(id, symbol, side, quantity);
					orders.add(order);

				} catch (InvalidOrderException ex) {
					// If data is bad, skip the row and log the issue
					logger.warning("Skipping invalid client order: " + ex.getMessage());
				}
			}

			// Log how many valid orders were read
			logger.info("Successfully read " + orders.size() + " valid client orders from " + fileName);
		} catch (Exception e) {
			// Log and re throw if the file couldn't be read
			logger.error("Failed to read client orders from " + fileName + ": " + e.getMessage());
			throw e;
		}
		// Return the list of valid client orders
		return orders;
	}
}
