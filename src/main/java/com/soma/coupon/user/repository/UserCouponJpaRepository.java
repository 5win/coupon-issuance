package com.soma.coupon.user.repository;

import com.soma.coupon.coupon.entity.Coupon;
import com.soma.coupon.user.entity.User;
import com.soma.coupon.user.entity.UserCoupon;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCouponJpaRepository extends JpaRepository<UserCoupon, Long> {

    Optional<UserCoupon> findByUserAndCoupon(User user, Coupon coupon);
}
