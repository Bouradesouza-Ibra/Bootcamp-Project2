 package clientorders;
import java.util.List;
// This thread reads client orders from the CSV file
public class ClientReaderThread extends Thread {
    private List<ClientOrder> clients;  // Stores the list of client orders
    @Override
    public void run() {
        try {
            // Read client orders from the CSV file
            clients = ClientOrderReader.readClientOrders("client_orders.csv");
            System.out.println("Finished reading client orders");
        } catch (Exception e) {
            // Show error if reading fails
            System.out.println("Error reading client orders: " + e.getMessage());
        } }
    // Method to return the list of client orders
    public List<ClientOrder> getClients() {
        return clients;
   }}
