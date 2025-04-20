package com.soma.coupon.user.dto;

import com.soma.coupon.user.Role;
import com.soma.coupon.user.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserSignUpReq {

    private final String username;
    private final Role role;

    public User toEntity() {
        return User.builder()
            .username(this.username)
            .role(this.role)
            .build();
    }
}
