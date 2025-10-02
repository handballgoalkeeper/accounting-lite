package dev.handballgoalkeeper.accountinglite.exceptions;

public final class AlreadyExistsException extends RuntimeException {
    public AlreadyExistsException(String message) {
        super(message);
    }
}
