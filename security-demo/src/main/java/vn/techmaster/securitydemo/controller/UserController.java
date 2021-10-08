package vn.techmaster.securitydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import lombok.RequiredArgsConstructor;
import vn.techmaster.securitydemo.Service.*;
import vn.techmaster.securitydemo.entities.*;
import vn.techmaster.securitydemo.repository.ProductRepo;
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsers(){
        return ResponseEntity.ok().body(userService.getUser());
    }
    @GetMapping("product")
    public ResponseEntity<List<Product>> getProducts(){
        return ResponseEntity.ok().body(productRepo.findAll());
    }
}
