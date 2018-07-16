package com.hngd.vmns.data;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages={"com.hngd"})
@MapperScan(value={"com.hngd.dao","com.hngd.common.dao"})
@EnableTransactionManagement
public class HnvmnsBaseDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(HnvmnsBaseDataApplication.class, args);
	}
}
