package com.profinder.WorkBridgeServer.service;

import com.profinder.WorkBridgeServer.controllers.AuthenticationRequest;
import com.profinder.WorkBridgeServer.controllers.AuthenticationResponse;
import com.profinder.WorkBridgeServer.controllers.RegisterRequest;
import com.profinder.WorkBridgeServer.entity.Role;
import com.profinder.WorkBridgeServer.entity.User;
import com.profinder.WorkBridgeServer.entity.UserInfo;
import com.profinder.WorkBridgeServer.repository.UserInfoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@AllArgsConstructor

public class AuthenticationService {
    @Autowired
    private UserInfoRepository userInfoRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;
    public AuthenticationResponse Register(RegisterRequest registerRequest) {
    var user= UserInfo.builder()
            .firstname(registerRequest.getFirstname())
            .lastname(registerRequest.getLastname())
            .email(registerRequest.getEmail())
            .password(passwordEncoder.encode(registerRequest.getPassword()))
            .role(Role.USER)
            .build();
    userInfoRepository.save(user);
    var jwtToken=jwtService.generateToken(user);
    return AuthenticationResponse.builder()

            .token(jwtToken)
            .build();


    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user =userInfoRepository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken=jwtService.generateToken(user);
        return AuthenticationResponse.builder()

                .token(jwtToken)
                .build();
    }
}
