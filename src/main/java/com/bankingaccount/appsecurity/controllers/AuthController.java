package com.bankingaccount.appsecurity.controllers;

import com.bankingaccount.appsecurity.dtos.AuthRequest;
import com.bankingaccount.appsecurity.dtos.AuthResponse;
import com.bankingaccount.appsecurity.jwt.JwtToken;
import com.bankingaccount.appsecurity.model.AccessModel;
import com.bankingaccount.appsecurity.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/auth")
public class AuthController {
    @Autowired
    AuthService authService;
    @Autowired
    private JwtToken jwtToken;
    Logger logger = LoggerFactory.getLogger(AuthController.class);

    @GetMapping
    public List<AccessModel> get(){
        return authService.getAccess();
    }

    @PostMapping()
    public ResponseEntity<?>post(@RequestBody AuthRequest request) throws Exception{
        logger.info("Post: UserName{} - Password {}", request.getUserName(), request.getPassword());

        if(!authService.validatedCredentials(request.getUserName(), request.getPassword())){
            return new ResponseEntity<String>("INVALID_CREDENTIALS", HttpStatus.UNAUTHORIZED);
        }
        AuthResponse response = new AuthResponse(jwtToken.generateToken(request),
                request.getUserName(),
                "1d");
        return ResponseEntity.ok(response);
    }
}
