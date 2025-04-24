package com.soma.coupon.coupon.dto;

import com.soma.coupon.coupon.entity.Coupon;
import java.time.LocalDateTime;

public record SaveCouponReq(String couponType, int amount, LocalDateTime expireTime) {

    public Coupon toEntity() {
        return Coupon.builder()
            .couponType(this.couponType)
            .amount(this.amount)
            .expireTime(this.expireTime)
            .build();
    }
}
