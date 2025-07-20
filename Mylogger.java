package clientorders;

public class MyLogger {
    // Create a private static instance of the class
    private static final MyLogger instance = new MyLogger();

    //Make the constructor private to prevent outside instantiation
    private MyLogger() {}

    //Provide a public method to get the only instance
    public static MyLogger getInstance() {
        return instance;
    }

    // Method to print log messages
    public void log(String message) {
        System.out.println("[LOG]: " + message);
    }

    //  Add other log levels like info, warning, error
    public void info(String message) {
        System.out.println("[INFO]: " + message);
    }

    public void warning(String message) {
        System.out.println("[WARNING]: " + message);
    }

    public void error(String message) {
        System.err.println("[ERROR]: " + message);
    }
}
