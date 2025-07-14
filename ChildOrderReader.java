package Clientorders;

import java.io.*;

import java.util.*;

import java.util.logging.Logger;


public class ChildOrderReader {

    private static final Logger logger = Logger.getLogger("TradeLogger");


    public static List<ChildOrder> readChildOrders(String fileName) throws IOException {

        List<ChildOrder> childOrders = new ArrayList<>();


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String line = br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                String[] parts = line.split(",");

                String childId = parts[0].trim();

                String parentId = parts[1].trim();

                String symbol = parts[2].trim();

                String side = parts[3].trim();

                int quantity = Integer.parseInt(parts[4].trim());

                int filled = Integer.parseInt(parts[5].trim());


                childOrders.add(new ChildOrder(childId, parentId, symbol, side, quantity, filled));

            }

            logger.info("Successfully read " + childOrders.size() + " child orders from " + fileName);

        } catch (Exception e) {

            logger.severe("Failed to read child orders from " + fileName + ": " + e.getMessage());

            throw e;

        }


        return childOrders;

    }

}