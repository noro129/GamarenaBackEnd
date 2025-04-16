package com.gamarena.GameArenaBackend.service;


import com.gamarena.GameArenaBackend.controller.request.SignInRequest;
import com.gamarena.GameArenaBackend.controller.request.SignUpRequest;
import com.gamarena.GameArenaBackend.controller.response.SignInUpResponse;
import com.gamarena.GameArenaBackend.entity.User;
import com.gamarena.GameArenaBackend.exception.EmailAlreadyUsedException;
import com.gamarena.GameArenaBackend.exception.UsernameAlreadyUsedException;
import com.gamarena.GameArenaBackend.repository.UserRepository;
import com.gamarena.GameArenaBackend.security.service.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationService(UserRepository userRepository,
                                 PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }


    public SignInUpResponse signIn(SignInRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        if (userRepository.findByUsername(request.getUsername()).isEmpty()) throw new UsernameNotFoundException("Username Not Found!");

        String token = jwtService.generateToken(request.getUsername());

        return new SignInUpResponse(token);
    }


    public SignInUpResponse signUp(SignUpRequest request) throws UsernameAlreadyUsedException, EmailAlreadyUsedException {
        if (userRepository.findByUsername(request.getUsername()).isPresent()) throw new UsernameAlreadyUsedException("Username Already Used!");
        if (userRepository.findByEmail(request.getEmail()).isPresent()) throw new EmailAlreadyUsedException("Username Already Used!");

        User user = new User();

        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setEmail(request.getEmail());
        user.setDateOfBirth(request.getDateOfBirth());

        userRepository.save(user);

        String token = jwtService.generateToken(user.getUsername());

        return new SignInUpResponse(token);
    }
}
