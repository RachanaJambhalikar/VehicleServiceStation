package com.sunbeam.exception;

import java.io.IOException;

public class DataIOException extends RuntimeException {

    public DataIOException(String message) {
        super(message);
    }

    public DataIOException(String message, Throwable cause) {
        super(message, cause);
    }
}