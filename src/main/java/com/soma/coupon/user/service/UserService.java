package com.soma.coupon.user.service;

import com.soma.coupon.common.JwtUtils;
import com.soma.coupon.user.dto.UserSignInReq;
import com.soma.coupon.user.dto.UserSignUpReq;
import com.soma.coupon.user.entity.User;
import com.soma.coupon.user.repository.UserRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserSignUpReq userSignUpReq) {
        userRepository.findByUsername(userSignUpReq.getUsername())
            .ifPresent(user -> {
                throw new RuntimeException("Username is already in use");
            });
        userRepository.signUp(userSignUpReq.toEntity());
    }

    public String signIn(UserSignInReq userSignInReq) {
        User user = userRepository.findByUsername(userSignInReq.getUsername())
            .orElseThrow(() -> new NoSuchElementException("User not found"));

        return JwtUtils.generateJwtToken(user);
    }
}
