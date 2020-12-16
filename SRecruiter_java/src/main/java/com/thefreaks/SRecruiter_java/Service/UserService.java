package com.thefreaks.SRecruiter_java.Service;

import com.thefreaks.SRecruiter_java.Model.User;
import com.thefreaks.SRecruiter_java.Service.web.web_dto.UserRegistrationDto;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    User saveUser(UserRegistrationDto userRegistrationDto);
    int getMaxUserCount();
}
