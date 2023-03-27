package com.bankingaccount.appsecurity.dtos;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class AuthRequest {

    private static final long serialVersionUID = 1L;
    private String userName;
    private String password;


}
