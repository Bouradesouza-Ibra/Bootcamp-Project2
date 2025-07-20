package clientorders;

import java.util.List;

// Thread class to read child orders in the background
public class ChildReaderThread extends Thread {
    private List<ChildOrder> children;  // Stores the list of child orders

    @Override
    public void run() {
        try {
            // Read child orders from the CSV file
            children = ChildOrderReader.readChildOrders("child_orders.csv");
            System.out.println("Finished reading child orders");
        } catch (Exception e) {
            // Print error if reading fails
            System.out.println("Error reading child orders: " + e.getMessage());
        }
    }

    // Getter to return the list of child orders
    public List<ChildOrder> getChildren() {
        return children;
    }
}
