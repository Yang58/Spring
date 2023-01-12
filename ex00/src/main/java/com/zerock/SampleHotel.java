package com.zerock;

import org.springframework.stereotype.Component;

import com.zerock.sample.Chef;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Component
@ToString
@Getter
@RequiredArgsConstructor
public class SampleHotel {
	// 단일 생성자일 경우 묵시적 자동 의존성 주입으로 Setter메서드를 사용하지 않아도 
	// 자동 생성 되어 값이 초기화 된다 .
	@NonNull
	private Chef chef;
	
	private String name;
	
}
