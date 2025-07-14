package Clientorders;

import java.io.*;

import java.util.*;

import java.util.logging.Logger;


public class ClientOrderReader {

	 private static final Logger logger = Logger.getLogger("TradeLogger");


    public static List<ClientOrder> readClientOrders(String fileName) throws IOException {

        List<ClientOrder> orders = new ArrayList<>();

       try( BufferedReader br = new BufferedReader(new FileReader(fileName))){

        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {

            String[] parts = line.split(",");

            String id = parts[0].trim();

            String symbol = parts[1].trim();

            String side = parts[2].trim();

            int quantity = Integer.parseInt(parts[3].trim());

            ClientOrder order = new ClientOrder (id, symbol, side, quantity);

            orders.add(order);

        }

        logger.info("Successfully read 3 client orders from client_orders.csv");

       } catch (Exception e) {

           logger.severe("Failed to read client orders from " + fileName + ": " + e.getMessage());

           throw e;  

       }

       return orders;

   }

}