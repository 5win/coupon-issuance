package com.soma.coupon.user.entity;

import com.soma.coupon.coupon.entity.Coupon;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "users_coupons")
public class UserCoupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_coupon_id")
    private Long userCouponId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coupon_id")
    private Coupon coupon;

    @Column(name = "is_used")
    private boolean isUsed = false;

    @Column(name = "used_at")
    private LocalDateTime usedAt;

    @Builder
    public UserCoupon(User user, Coupon coupon, boolean isUsed) {
        this.user = user;
        this.coupon = coupon;
        this.isUsed = isUsed;
    }

    public void useCoupon() {
        if (isUsed) {
            throw new RuntimeException("Coupon is already used");
        }

        if (coupon.isExpired()) {
            throw new RuntimeException("Coupon is expired");
        }

        isUsed = true;
        usedAt = LocalDateTime.now();
    }
}
