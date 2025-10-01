package dev.handballgoalkeeper.accountinglite.enums;

import lombok.Getter;

@Getter
public enum ErrorMessage {
    UNHANDLED_EXCEPTION("Something went wrong, please try again later or contact support.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

}
