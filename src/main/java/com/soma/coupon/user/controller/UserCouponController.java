package com.soma.coupon.user.controller;

import com.soma.coupon.user.service.UserCouponService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user/coupon")
public class UserCouponController {

    private final UserCouponService userCouponService;

    @PostMapping("/{coupon-id}")
    public ResponseEntity<?> receiveCoupon(@PathVariable("coupon-id") Long couponId, HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        userCouponService.receiveCoupon(username, couponId);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{coupon-id}")
    public ResponseEntity<?> useCoupon(@PathVariable("coupon-id") Long couponId, HttpServletRequest request) {
        String username = (String) request.getAttribute("username");
        userCouponService.useCoupon(username, couponId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
