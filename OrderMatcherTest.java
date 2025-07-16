package Clientorders;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class OrderMatcherTest {

    @Test
    public void testReconcileOrdersFullyFilled() {
        ClientOrder client = new ClientOrder("CO1", "AAPL", "BUY", 100);
        ChildOrder child1 = new ChildOrder("C1", "CO1", "AAPL", "BUY", 50, 50);
        ChildOrder child2 = new ChildOrder("C2", "CO1", "AAPL", "BUY", 50, 50);

        List<ClientOrder> clientList = Arrays.asList(client);
        List<ChildOrder> childList = Arrays.asList(child1, child2);

        // Capture printed output using a stream
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        OrderMatcher.reconcileOrders(clientList, childList);

        String output = outContent.toString().trim();
        assertTrue(output.contains("FULLY FILLED"));
    }

    @Test
    public void testReconcileOrdersPartiallyFilled() {
        ClientOrder client = new ClientOrder("CO2", "AAPL", "BUY", 100);
        ChildOrder child1 = new ChildOrder("C3", "CO2", "AAPL", "BUY", 100, 60);

        List<ClientOrder> clientList = Arrays.asList(client);
        List<ChildOrder> childList = Arrays.asList(child1);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        OrderMatcher.reconcileOrders(clientList, childList);

        String output = outContent.toString().trim();
        assertTrue(output.contains("PARTIALLY FILLED"));
    }

    @Test
    public void testReconcileOrdersOverfilled() {
        ClientOrder client = new ClientOrder("CO3", "AAPL", "BUY", 100);
        ChildOrder child1 = new ChildOrder("C4", "CO3", "AAPL", "BUY", 120, 120);

        List<ClientOrder> clientList = Arrays.asList(client);
        List<ChildOrder> childList = Arrays.asList(child1);

        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        OrderMatcher.reconcileOrders(clientList, childList);

        String output = outContent.toString().trim();
        assertTrue(output.contains("OVERFILLED"));
    }
}
