package com.gamarena.GameArenaBackend.controller;


import com.gamarena.GameArenaBackend.controller.request.SignInRequest;
import com.gamarena.GameArenaBackend.controller.request.SignUpRequest;
import com.gamarena.GameArenaBackend.controller.response.SignInUpResponse;
import com.gamarena.GameArenaBackend.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/authentication")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @PostMapping("/signin")
    public ResponseEntity<SignInUpResponse> signIn(@RequestBody SignInRequest request){
        return ResponseEntity.ok(authenticationService.signIn(request));
    }

    @PostMapping("/signup")
    public ResponseEntity<SignInUpResponse> signup(@RequestBody SignUpRequest request) {
        System.out.println(request);
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

}
