package com.infosys.exceptions;

public class TaskListEmptyException extends NullPointerException {
    public TaskListEmptyException(String message) {
        super(message);
    }
}
