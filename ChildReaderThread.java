package Clientorders;

import java.util.List;


public class ChildReaderThread extends Thread {

    private List<ChildOrder> children;


    @Override

    public void run() {

        try {

            children = ChildOrderReader.readChildOrders("child_orders.csv");

            System.out.println(" Finished reading child orders");

        } catch (Exception e) {

            System.out.println(" Error reading child orders: " + e.getMessage());

        }

    }


    public List<ChildOrder> getChildren() {

        return children;

    }

}