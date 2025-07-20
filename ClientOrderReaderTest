package clientorders;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

// This test class checks if the ClientOrderReader correctly reads client orders from CSV files
public class ClientOrderReaderTest {
    @Test
    public void testValidClientOrders() throws Exception {
        //  Read a file that has only valid client orders
        List<ClientOrder> orders = ClientOrderReader.readClientOrders("testdata1/clientorders/test_valid_client_orders.csv");
        //  Make sure the list is not empty or broken
        assertNotNull(orders);
        // Check that the correct number of orders were added
        assertEquals(2, orders.size()); 
    }
    @Test
    public void testInvalidClientOrders() throws Exception {
        // This file has only bad rows (missing or invalid data)
        List<ClientOrder> orders = ClientOrderReader.readClientOrders("testdata1/clientorders/test_invalid_client_orders.csv");
        assertNotNull(orders);
        assertEquals(0, orders.size());
    }
    @Test
    public void testMixedClientOrders() throws Exception {
        // This file has a mix: some valid, some invalid orders
        List<ClientOrder> orders = ClientOrderReader.readClientOrders("testdata1/clientorders/test_mixed_client_orders.csv");
        assertNotNull(orders);
        assertEquals(2, orders.size()); 
    }
    @Test
    public void testFileNotFound() {
        // This test checks if the program throws an error for a missing file
        Exception exception = assertThrows(Exception.class, () -> {
            ClientOrderReader.readClientOrders("testdata1/clientorders/non_existing_file.csv");
        });
        assertTrue(exception.getMessage().contains("non_existing_file"));
    }
}
