package com.soma.coupon.user.repository;

import com.soma.coupon.coupon.entity.Coupon;
import com.soma.coupon.user.entity.User;
import com.soma.coupon.user.entity.UserCoupon;
import java.util.Optional;

public interface UserCouponRepository {

    void save(UserCoupon userCoupon);

    Optional<UserCoupon> findByUserAndCoupon(User user, Coupon coupon);
}
