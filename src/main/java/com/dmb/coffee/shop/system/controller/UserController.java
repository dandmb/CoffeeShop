package com.dmb.coffee.shop.system.controller;


import com.dmb.coffee.shop.system.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/signup")
    ResponseEntity<String> signUp(@RequestBody Map<String,String> requestMap);
    @PostMapping(path = "/login")
    ResponseEntity<String> login(@RequestBody Map<String,String> requestMap);

    @GetMapping(path = "/get")
    ResponseEntity<List<UserWrapper>> getUsers();

    @PostMapping("/update")
    ResponseEntity<String> update(@RequestBody Map<String,String> requestMap);

    @GetMapping(path = "/checkToken")
    ResponseEntity<String> checkToken();





}
