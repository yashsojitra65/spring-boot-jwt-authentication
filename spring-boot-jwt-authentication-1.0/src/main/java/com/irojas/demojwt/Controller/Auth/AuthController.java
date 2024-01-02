package com.irojas.demojwt.Controller.Auth;

import com.irojas.demojwt.Dto.AuthResponseDto;
import com.irojas.demojwt.Auth.AuthService;
import com.irojas.demojwt.Dto.ErrorResponseDto;
import com.irojas.demojwt.Dto.LoginRequestDto;
import com.irojas.demojwt.Dto.RegisterRequestDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("login")
    public ResponseEntity login(@RequestBody LoginRequestDto request) {
        try {
            return ResponseEntity.ok(authService.login(request));
        } catch (Exception ex) {
            ErrorResponseDto response = ErrorResponseDto.builder()
                    .httpStatus(HttpStatus.BAD_REQUEST.name())
                    .errorMessage(ex.getMessage())
                    .build();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
        }
    }

    @PostMapping("register")
    public ResponseEntity<AuthResponseDto> register(@RequestBody RegisterRequestDto request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
