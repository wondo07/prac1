package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {

    RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();


    @Test
    @DisplayName("vip는 10% 할인율이 적용되어야 한다.")
    void vip(){
        //given
        Member member = new Member(1L,"member1", Grade.VIP);

        //when
        int discount = rateDiscountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(1000);
    }

    @Test
    void vip_x(){
        //given
        Member member = new Member(2L,"member1", Grade.BASIC);

        //when
        int discount = rateDiscountPolicy.discount(member,10000);

        //then
        assertThat(discount).isEqualTo(0);
    }



}