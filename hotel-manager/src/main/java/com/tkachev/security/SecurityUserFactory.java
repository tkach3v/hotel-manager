package com.tkachev.security;

import com.tkachev.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface SecurityUserFactory {

    UserDetails fromUser(User user);
}
