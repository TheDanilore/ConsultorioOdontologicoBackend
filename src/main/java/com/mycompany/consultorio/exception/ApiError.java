package com.mycompany.consultorio.exception;

public class ApiError {
    private int status;
    private String message;
    private String timestamp;

    public ApiError(int status, String message, String timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
