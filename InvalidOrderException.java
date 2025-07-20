package clientorders;

// This is a custom exception for invalid orders
public class InvalidOrderException extends Exception {

    // Constructor that sends the error message to the parent class (Exception)
    public InvalidOrderException(String message) {
        super(message);  // Pass the message to the Exception class
    }
}
