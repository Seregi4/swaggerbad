package com.levanov.swaggerbad.util;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Data
@NoArgsConstructor
public class CustomResponse<T> {

    private int code;

    private String message;

    private Collection<T> responseList;

    public CustomResponse(Collection<T> response, CustomStatus customStatus) {
        this.code = customStatus.getCode();
        this.message = customStatus.getMessage();
        this.responseList = response;
    }
}
