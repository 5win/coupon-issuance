package com.soma.coupon.coupon.repository;

import com.soma.coupon.coupon.entity.Coupon;
import java.util.Optional;

public interface CouponRepository {

    void save(Coupon coupon);

    Optional<Coupon> findById(Long couponId);

    Optional<Coupon> findByCouponType(String couponType);
}
