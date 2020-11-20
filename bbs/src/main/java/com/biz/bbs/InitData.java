package com.biz.bbs;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InitData {

	@Bean
	public CommandLineRunner initDataMethod() {
		// 스프링 부트가 실행되면서 자동으로 수행되는
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {

				System.out.println("요기능 초기화 method");
			}
		};
	}
}
