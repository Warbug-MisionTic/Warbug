package com.misiontic.warbug.service;

public interface ISecurityService {
    boolean isAuthenticated();
    void autoLogin(String email, String password);
}
