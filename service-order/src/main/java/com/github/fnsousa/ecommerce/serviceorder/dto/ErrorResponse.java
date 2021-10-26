package com.github.fnsousa.ecommerce.serviceorder.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse 
{
    public ErrorResponse(String message, String detail) {
        super();
        this.message = message;
        this.detail = detail;
    }
 
    private String message;
 
    private String detail;
}