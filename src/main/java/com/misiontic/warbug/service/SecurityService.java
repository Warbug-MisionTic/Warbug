package com.misiontic.warbug.service;

public interface SecurityService {
    boolean isAuthenticated();
    void autoLogin(String username, String password);
}

