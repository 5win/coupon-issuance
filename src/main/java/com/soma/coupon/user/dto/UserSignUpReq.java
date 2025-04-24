package com.soma.coupon.user.dto;

import com.soma.coupon.user.Role;
import com.soma.coupon.user.entity.User;

public record UserSignUpReq(String username, Role role) {

    public User toEntity() {
        return User.builder()
            .username(this.username)
            .role(this.role)
            .build();
    }
}
