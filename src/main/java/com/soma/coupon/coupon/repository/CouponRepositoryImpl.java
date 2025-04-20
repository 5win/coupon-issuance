package com.soma.coupon.coupon.repository;

import com.soma.coupon.coupon.entity.Coupon;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class CouponRepositoryImpl implements CouponRepository {

    private final CouponJpaRepository couponJpaRepository;

    @Override
    public void save(Coupon coupon) {
        couponJpaRepository.save(coupon);
    }

    @Override
    public Optional<Coupon> findById(Long couponId) {
        return couponJpaRepository.findById(couponId);
    }

    @Override
    public Optional<Coupon> findByCouponType(String couponType) {
        return couponJpaRepository.findByCouponType(couponType);
    }
}
