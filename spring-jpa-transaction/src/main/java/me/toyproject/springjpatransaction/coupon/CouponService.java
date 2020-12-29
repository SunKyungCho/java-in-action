package me.toyproject.springjpatransaction.coupon;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CouponService {

    private final CouponRepository couponRepository;

    @Transactional
    public String createCoupon(String id) {
        Coupon save = couponRepository.save(new Coupon(id));
        return save.getName();
    }

    @Transactional
    public List<Coupon> takeAllCoupon(String name, String user) {
        List<Coupon> coupons = couponRepository.findAllByName(name);
        for (Coupon coupon : coupons) {
            coupon.takeCoupon(user);
        }
        try {
            log.info("Sorry just sleep............" + user);
            Thread.sleep(10000);
            log.info("Wake up!! " + user);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return coupons;
    }

    @Transactional
    public String takeCoupon(String name, String user) {
        Coupon coupon = couponRepository.findByName(name);
        coupon.takeCoupon(user);
        try {
            log.info("Sorry just sleep............" + user);
            Thread.sleep(10000);
            log.info("Wake up!! " + user);
            Coupon again = couponRepository.findByName(name);
            log.info(again.toString());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return coupon.getName();
    }

    @Transactional
    public String interceptTakingCoupon(String id, String user) {
        log.info(">>>>>>>intercept :: coupon ::" + id + " user: " + user);
        Coupon coupon = couponRepository.findByName(id);
        coupon.takeCoupon(user);
        return coupon.getName();
    }

    @Transactional(readOnly = true)
    public List<Coupon> findAll() {
        return couponRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Coupon findByCoupon(String coupon) {
        return couponRepository.findByName(coupon);
    }
}
