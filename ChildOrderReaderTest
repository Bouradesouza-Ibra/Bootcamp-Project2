package clientorders;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class ChildOrderReaderTest {

    @Test
    public void testValidChildOrders() throws Exception {
        // Test reading valid child orders
        List<ChildOrder> orders = ChildOrderReader.readChildOrders("testdata/childorders/test_valid_child_orders.csv");
        assertNotNull(orders);
        assertEquals(2, orders.size());
    }

    @Test
    public void testInvalidChildOrders() throws Exception {
        // Test reading file with only invalid child orders
        List<ChildOrder> orders = ChildOrderReader.readChildOrders("testdata/childorders/test_invalid_child_orders.csv");
        assertNotNull(orders);
        assertEquals(0, orders.size());
    }

    @Test
    public void testMixedChildOrders() throws Exception {
        // Test reading file with a mix of valid and invalid child orders
        List<ChildOrder> orders = ChildOrderReader.readChildOrders("testdata/childorders/test_mixed_child_orders.csv");
        assertNotNull(orders);
        assertEquals(2, orders.size());
    }

    @Test
    public void testFileNotFound() {
        // Test when file doesn't exist
        Exception exception = assertThrows(Exception.class, () -> {
            ChildOrderReader.readChildOrders("testdata/childorders/non_existing_file.csv");
        });
        assertTrue(exception.getMessage().contains("non_existing_file"));
    }
}
