package com.tkachev.entity;

public enum Permission {
    USERS_READ("users:read"),
    USERS_WRITE("users:write"),
    SERVICES_READ("services:read"),
    SERVICES_WRITE("services:write"),
    ROOMS_READ("rooms:read"),
    ROOMS_WRITE("rooms:write"),
    ORDERS_READ("orders:read"),
    ORDERS_WRITE("orders:write"),
    RESERVATIONS_READ("reservations:read"),
    RESERVATIONS_WRITE("reservations:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
