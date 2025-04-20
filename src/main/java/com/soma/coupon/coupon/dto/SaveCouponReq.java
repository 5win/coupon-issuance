package com.soma.coupon.coupon.dto;

import com.soma.coupon.coupon.entity.Coupon;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SaveCouponReq {

    private final String couponType;
    private final int amount;
    private final LocalDateTime expireTime;

    public Coupon toEntity() {
        return Coupon.builder()
            .couponType(this.couponType)
            .amount(this.amount)
            .expireTime(this.expireTime)
            .build();
    }
}
