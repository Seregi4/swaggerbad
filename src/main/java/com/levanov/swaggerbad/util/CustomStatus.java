package com.levanov.swaggerbad.util;

import lombok.Getter;

@Getter
public enum CustomStatus {
    SUCCESS(0, "Success"),
    NOT_FOUND(1, " not found"),
    EXCEPTION(2, "exception");

    private final int code;
    private final String message;

    CustomStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
