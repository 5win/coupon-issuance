package com.soma.coupon.coupon.service;

import com.soma.coupon.coupon.dto.SaveCouponReq;
import com.soma.coupon.coupon.repository.CouponRepository;
import com.soma.coupon.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CouponService {

    private final CouponRepository couponRepository;

    public void saveCoupon(SaveCouponReq saveCouponReq, Role role) {
        if (role != Role.ADMIN) {
            throw new IllegalArgumentException();
        }
        couponRepository.findByCouponType(saveCouponReq.getCouponType())
            .ifPresent(coupon -> {
                throw new IllegalArgumentException("coupon already exists");
            });

        couponRepository.save(saveCouponReq.toEntity());
    }
}
