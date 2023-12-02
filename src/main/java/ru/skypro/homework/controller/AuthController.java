package ru.skypro.homework.controller;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext;
import io.swagger.v3.oas.annotations.headers.Header;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.login.LoginDTO;
import ru.skypro.homework.dto.register.RegisterDTO;
import ru.skypro.homework.service.AuthService;

import javax.persistence.Basic;
import javax.websocket.RemoteEndpoint;
import java.util.Collections;

/**
 * Контроллер для авторизации и регистрации.
 */
@Slf4j
@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    /**
     * Авторизация пользователя
     * @param login
     * @return
     */
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
        HttpHeaders response = new HttpHeaders();
        response.setAccessControlAllowOrigin("*");
//        response.add("Authorization Basic base64Encode(user:password)", login.getUsername());
        if (authService.login(login.getUsername(), login.getPassword())) {
            return ResponseEntity.ok().headers(response).build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /**
     * Регистрация пользователя
     * @param register
     * @return
     */
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO register) {
        HttpHeaders response = new HttpHeaders();
        response.setAccessControlAllowOrigin("*");
        if (authService.register(register)) {
            return ResponseEntity.status(HttpStatus.CREATED).headers(response).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
