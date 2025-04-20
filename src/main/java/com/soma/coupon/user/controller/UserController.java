package com.soma.coupon.user.controller;

import com.soma.coupon.user.dto.UserSignInReq;
import com.soma.coupon.user.dto.UserSignUpReq;
import com.soma.coupon.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @PostMapping("/sign-up")
    public ResponseEntity<?> signUp(@RequestBody UserSignUpReq userSignUpReq) {
        userService.signUp(userSignUpReq);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("sign-in")
    public ResponseEntity<?> signIn(@RequestBody UserSignInReq userSignInReq) {
        String jwt = userService.signIn(userSignInReq);
        return ResponseEntity.ok()
            .header("token", jwt)
            .build();
    }
}
