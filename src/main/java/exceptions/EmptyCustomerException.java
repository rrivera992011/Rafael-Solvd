package main.java.exceptions;

public class EmptyCustomerException extends Exception {
    private String description;
    public EmptyCustomerException(String message, String description) {
        super(message);
        this.description = description;
    }

}
