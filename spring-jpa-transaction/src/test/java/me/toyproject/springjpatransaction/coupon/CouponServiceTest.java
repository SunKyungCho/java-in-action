package me.toyproject.springjpatransaction.coupon;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CouponServiceTest {

    @Autowired
    private CouponService couponService;

    @Test
    @DisplayName("동시에 가져가기")
    void take_duplicate() {
        String coupon = couponService.createCoupon("AAA");
        System.out.println("Create Coupone::: " + coupon);
        System.out.println(">>>>>>>>>>>>>TAKE KIM<<<<<<<<<<<<");
        couponService.takeCoupon(coupon, "Kim");
        System.out.println("================================");
        System.out.println(">>>>>>>>>>>>>TAKE PARK<<<<<<<<<<<<");
        couponService.interceptTakingCoupon(coupon, "park");

        Coupon byCoupon = couponService.findByCoupon(coupon);
        System.out.println(byCoupon.toString());
    }

    @Test
    @DisplayName("동시에 가져가기")
    void intercept() {
        String coupon = "AAA";
        System.out.println("Create Coupone::: " + coupon);
        System.out.println(">>>>>>>>>>>>>TAKE KIM<<<<<<<<<<<<");
        couponService.takeCoupon(coupon, "Kim");
        System.out.println("================================");
        System.out.println(">>>>>>>>>>>>>TAKE PARK<<<<<<<<<<<<");
        couponService.interceptTakingCoupon(coupon, "park");

        Coupon byCoupon = couponService.findByCoupon(coupon);
        System.out.println(byCoupon.toString());
    }
}
