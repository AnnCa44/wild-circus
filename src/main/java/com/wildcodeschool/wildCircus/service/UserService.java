package com.wildcodeschool.wildCircus.service;

import com.wildcodeschool.wildCircus.entity.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface UserService {

    void autoLogin(HttpServletRequest request, String email, String password);
    User getLoggedUser();
}
