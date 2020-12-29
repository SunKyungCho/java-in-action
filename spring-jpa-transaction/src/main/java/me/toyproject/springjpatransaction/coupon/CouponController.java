package me.toyproject.springjpatransaction.coupon;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @GetMapping("/coupons")
    public ResponseEntity<List<Coupon>> fetchAll() {
        List<Coupon> coupons = couponService.findAll();
        return ResponseEntity.ok(coupons);
    }


    @PostMapping("/coupons/{id}")
    public ResponseEntity<String> create(@PathVariable String id) {
        String coupon = couponService.createCoupon(id);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping("/coupons/{id}/all/{user}")
    public ResponseEntity<List<Coupon>> takeAllCoupon(@PathVariable String id, @PathVariable String user) {
        List<Coupon> coupon = couponService.takeAllCoupon(id, user);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping("/coupons/{id}/{user}")
    public ResponseEntity<String> takeCoupon(@PathVariable String id, @PathVariable String user) {
        String coupon = couponService.takeCoupon(id, user);
        return ResponseEntity.ok(coupon);
    }

    @PostMapping("/coupons/{id}/intercept/{user}")
    public ResponseEntity<String> interceptCoupon(@PathVariable String id, @PathVariable String user) {
        String coupon = couponService.interceptTakingCoupon(id, user);
        return ResponseEntity.ok(coupon);
    }
}
