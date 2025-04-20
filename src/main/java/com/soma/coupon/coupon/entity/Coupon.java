package com.soma.coupon.coupon.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name = "coupons")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "coupon_id")
    private Long couponId;

    @Column(name = "coupon_type")
    private String couponType;

    @Column(name = "amount")
    private int amount;

    @Column(name = "expire_time")
    private LocalDateTime expireTime;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @Builder
    public Coupon(String couponType, int amount, LocalDateTime expireTime) {
        this.couponType = couponType;
        this.amount = amount;
        this.expireTime = expireTime;
    }

    public void decrementAmount() {
        if (this.amount == 0) {
            throw new IllegalStateException("Cannot decrement amount of coupon");
        }
        this.amount--;
    }

    public boolean isExpired() {
        return expireTime.isBefore(LocalDateTime.now());
    }
}
