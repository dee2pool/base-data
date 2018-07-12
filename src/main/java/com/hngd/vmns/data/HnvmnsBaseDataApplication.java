package com.hngd.vmns.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.hngd"})
@MapperScan("com.hngd.dao")
public class HnvmnsBaseDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(HnvmnsBaseDataApplication.class, args);
	}
}
