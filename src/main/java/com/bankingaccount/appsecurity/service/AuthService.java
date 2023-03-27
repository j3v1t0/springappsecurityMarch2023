package com.bankingaccount.appsecurity.service;

import com.bankingaccount.appsecurity.model.AccessModel;

import java.util.List;

public interface AuthService {
    List<AccessModel> getAccess();

    Boolean validatedCredentials(String userName, String password);
}
