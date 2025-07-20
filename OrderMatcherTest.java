package clientorders;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderMatcherTest {

    @Test
    public void testReconcileOrders() {
        List<ClientOrder> clients = new ArrayList<>();
        List<ChildOrder> children = new ArrayList<>();

        // Client C1 needs 500
        clients.add(new ClientOrder("C1", "AAPL", "BUY", 500));
        children.add(new ChildOrder("CH1", "C1", "AAPL", "BUY", 200, 200));
        children.add(new ChildOrder("CH2", "C1", "AAPL", "BUY", 300, 150));

        // Client C2 needs 400
        clients.add(new ClientOrder("C2", "MSFT", "SELL", 300));
        children.add(new ChildOrder("CH3", "C2", "MSFT", "SELL", 300, 300));

        // Client C3 needs 1000
        clients.add(new ClientOrder("C3", "TSLA", "BUY", 1000));
        children.add(new ChildOrder("CH4", "C3", "TSLA", "BUY", 400, 100));
        children.add(new ChildOrder("CH5", "C3", "TSLA", "BUY", 600, 500));

        assertDoesNotThrow(() -> OrderMatcher.reconcileOrders(clients, children));
    }
}
