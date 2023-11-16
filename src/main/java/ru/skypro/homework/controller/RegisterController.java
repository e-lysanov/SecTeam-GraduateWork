package ru.skypro.homework.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.homework.dto.register.Register;
import ru.skypro.homework.service.RegisterService;

//@Slf4j
//@RestController
//@RequestMapping("/register")
//public class RegisterController {
//    private final RegisterService registerService;
//
//    public RegisterController(RegisterService registerService) {
//        this.registerService = registerService;
//    }
//
//    @PostMapping
//    public Register register(Register register) {
//        return registerService.register(register);
//    }
//}
