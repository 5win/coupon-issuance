package com.soma.coupon.user.service;

import com.soma.coupon.coupon.entity.Coupon;
import com.soma.coupon.coupon.repository.CouponRepository;
import com.soma.coupon.user.entity.User;
import com.soma.coupon.user.entity.UserCoupon;
import com.soma.coupon.user.repository.UserCouponRepository;
import com.soma.coupon.user.repository.UserRepository;
import java.util.NoSuchElementException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserCouponService {

    private final UserRepository userRepository;
    private final CouponRepository couponRepository;
    private final UserCouponRepository userCouponRepository;

    @Transactional
    public void receiveCoupon(String username, Long couponId) {
        User user = getUser(username);
        Coupon coupon = getCoupon(couponId);
        assertReceiveDuplicate(user, coupon);

        UserCoupon userCoupon = UserCoupon.builder()
            .user(user)
            .coupon(coupon)
            .isUsed(false)
            .build();

        coupon.decrementAmount();
        userCouponRepository.save(userCoupon);
    }

    @Transactional
    public void useCoupon(String username, Long couponId) {
        User user = getUser(username);
        Coupon coupon = getCoupon(couponId);
        UserCoupon userCoupon = getUserCoupon(user, coupon);

        userCoupon.useCoupon();
    }

    private void assertReceiveDuplicate(User user, Coupon coupon) {
        userCouponRepository.findByUserAndCoupon(user, coupon)
            .ifPresent(userCoupon -> {
                throw new RuntimeException("Duplicate user coupon");
            });
    }

    private UserCoupon getUserCoupon(User user, Coupon coupon) {
        return userCouponRepository.findByUserAndCoupon(user, coupon)
            .orElseThrow(() -> new NoSuchElementException("No user coupon found"));
    }

    private Coupon getCoupon(Long couponId) {
        return couponRepository.findById(couponId)
            .orElseThrow(() -> new NoSuchElementException("No coupon found"));
    }

    private User getUser(String username) {
        return userRepository.findByUsername(username)
            .orElseThrow(() -> new NoSuchElementException("No user found"));
    }
}
