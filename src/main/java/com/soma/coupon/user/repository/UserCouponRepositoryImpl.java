package com.soma.coupon.user.repository;

import com.soma.coupon.coupon.entity.Coupon;
import com.soma.coupon.user.entity.User;
import com.soma.coupon.user.entity.UserCoupon;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class UserCouponRepositoryImpl implements UserCouponRepository {

    private final UserCouponJpaRepository userCouponJpaRepository;

    @Override
    public void save(UserCoupon userCoupon) {
        userCouponJpaRepository.save(userCoupon);
    }

    @Override
    public Optional<UserCoupon> findByUserAndCoupon(User user, Coupon coupon) {
        return userCouponJpaRepository.findByUserAndCoupon(user, coupon);
    }
}
