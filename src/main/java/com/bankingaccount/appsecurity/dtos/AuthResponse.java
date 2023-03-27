package com.bankingaccount.appsecurity.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
@Getter
@AllArgsConstructor
public class AuthResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String token;
    private final String userName;
    private final String accessTokenExpiration;

}
