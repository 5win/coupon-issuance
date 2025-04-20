package com.soma.coupon.coupon.repository;

import com.soma.coupon.coupon.entity.Coupon;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponJpaRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCouponType(String couponType);
}
