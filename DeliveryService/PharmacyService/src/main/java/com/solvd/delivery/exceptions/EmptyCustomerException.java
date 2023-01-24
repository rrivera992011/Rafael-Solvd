package com.solvd.delivery.exceptions;

public class EmptyCustomerException extends Exception {
    public EmptyCustomerException(String description) {
        super(description);
    }

}
