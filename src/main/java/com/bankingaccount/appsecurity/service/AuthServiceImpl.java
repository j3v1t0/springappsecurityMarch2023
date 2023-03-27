package com.bankingaccount.appsecurity.service;

import com.bankingaccount.appsecurity.model.AccessModel;
import com.bankingaccount.appsecurity.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService{
    @Autowired
    AuthRepository authRepository;

    @Override
    public List<AccessModel> getAccess(){
        return (List<AccessModel>) authRepository.findAll();
    }
    @Override
    public Boolean validatedCredentials(String userName, String password){
        List<AccessModel> result = (List<AccessModel>) authRepository.findAll();
        List<AccessModel> resultFilter = result.stream()
                .filter(t -> t.getUserName().equals(userName) && t.getPassword().equals(password))
                .collect(Collectors.toList());
        if (null == resultFilter || resultFilter.isEmpty()){
            return false;
        }
        return true;
    }
}
