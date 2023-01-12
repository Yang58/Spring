package com.zerock.sample;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class SampleTests {
	// 유니테스트 
	// 롬북에서 값을 초기화할때 사용하는 메서드 setter메서드랑 동일한 역할 ( 자동 주입  )
   @Setter(onMethod_ = @Autowired)
   private Restaurant restaurant;
   
   // 테스트용 메서드 
   @Test
   public void testExist() {
      assertNotNull(restaurant);
      log.info(restaurant);
      log.info("----------------------------------");
      log.info(restaurant.getChef());
   }
   
   
}













