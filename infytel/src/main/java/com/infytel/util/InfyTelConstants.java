package com.infytel.util;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum InfyTelConstants {

    //Exception message constants
    CUSTOMER_NOT_FOUND("customer.not.found"),
    GENERAL_EXCEPTION_MESSAGE("general.exception"),

    //Success message constants

    CUSTOMER_UPDATE_SUCCESS("customer.update.success"),
    CUSTOMER_DELETE_SUCCESS("customer.delete.success");

    private final String type;


    @Override
    public String toString() {
        return this.type;
    }
}
