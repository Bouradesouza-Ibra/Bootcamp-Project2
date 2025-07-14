package Clientorders;

import java.util.List;


public class ClientReaderThread extends Thread {

    private List<ClientOrder> clients;


    @Override

    public void run() {

        try {

            clients = ClientOrderReader.readClientOrders("client_orders.csv");

            System.out.println(" Finished reading client orders");

        } catch (Exception e) {

            System.out.println(" Error reading client orders: " + e.getMessage());

        }

    }


    public List<ClientOrder> getClients() {

        return clients;

    }

}