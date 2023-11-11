package com.dmb.coffee.shop.system.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/signup")
    ResponseEntity<String> signUp(@RequestBody Map<String,String> requestMap);
    @PostMapping(path = "/login")
    ResponseEntity<String> login(@RequestBody Map<String,String> requestMap);
}
