package com.soma.coupon.coupon.controller;

import com.soma.coupon.coupon.dto.SaveCouponReq;
import com.soma.coupon.coupon.service.CouponService;
import com.soma.coupon.user.Role;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/coupon")
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public ResponseEntity<?> saveCoupon(@RequestBody SaveCouponReq saveCouponReq, HttpServletRequest request) {
        Role role = (Role) request.getAttribute("role");
        couponService.saveCoupon(saveCouponReq, role);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
