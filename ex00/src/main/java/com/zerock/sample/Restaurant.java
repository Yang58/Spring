package com.zerock.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.Setter;


@Component
@Data
@Setter
public class Restaurant {

	// 의존 주입 - @Setter메서드 사용 
	@Setter(onMethod_ = @Autowired)
	private Chef chef;
	
}
