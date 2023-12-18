package ru.skypro.homework.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.login.LoginDTO;
import ru.skypro.homework.dto.register.RegisterDTO;
import ru.skypro.homework.service.AuthService;


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
     *
     * @param login
     * @return
     */
    @Tag(name = "Авторизация")
    @Operation(summary = "Авторизация пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content),
            @ApiResponse(responseCode = "401", content = @Content)
    })
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {
        if (authService.login(login)) {
            log.info("Эндпоинт входа выполнен");
            return ResponseEntity.ok().build();
        }
        else {
            log.info("Эндпоинт входа не выполнен");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


        /**
         * Регистрация пользователя
         * @param register
         * @return
         */
        @Tag(name = "Регистрация")
        @Operation(summary = "Регистрация пользователя")
        @ApiResponses(value = {
                @ApiResponse(responseCode = "201", content = @Content),
                @ApiResponse(responseCode = "400", content = @Content)
        })
        @PostMapping("/register")
        public ResponseEntity<?> register (@RequestBody RegisterDTO register){
            if (authService.register(register)) {
                log.info("Эндпоинт регистрации выполнен");
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } else {
                log.info("Эндпоинт регистрации не выполнен");
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    }
