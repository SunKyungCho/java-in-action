package me.toyproject.springjpatransaction.coupon;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, String> {

    List<Coupon> findAllByName(String name);
    Coupon findByName(String name);
}
