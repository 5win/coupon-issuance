package com.soma.coupon.user.repository;

import com.soma.coupon.user.entity.User;
import java.util.Optional;

public interface UserRepository {

    void signUp(User user);

    Optional<User> findByUsername(String username);
}
