package com.tkachev.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role {
    USER(Set.of(
            Permission.SERVICES_READ,
            Permission.ROOMS_READ
    )),
    ADMIN(Set.of(
            Permission.USERS_READ,
            Permission.USERS_WRITE,
            Permission.ROOMS_WRITE,
            Permission.ROOMS_READ,
            Permission.SERVICES_WRITE,
            Permission.SERVICES_READ,
            Permission.RESERVATIONS_READ,
            Permission.RESERVATIONS_WRITE,
            Permission.ORDERS_WRITE,
            Permission.ORDERS_READ
    ));

    private final Set<Permission> permissions;

    Role(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
