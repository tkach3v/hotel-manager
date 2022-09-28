package com.tkachev.security.impl;

import com.tkachev.entity.User;
import com.tkachev.entity.UserStatus;
import com.tkachev.security.SecurityUserFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SecurityUserFactoryImpl implements SecurityUserFactory {
    public UserDetails fromUser(User user) {
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                user.getStatus().equals(UserStatus.ACTIVE),
                user.getStatus().equals(UserStatus.ACTIVE),
                user.getStatus().equals(UserStatus.ACTIVE),
                user.getStatus().equals(UserStatus.ACTIVE),
                user.getRole().getAuthorities()
        );
    }
}
