package com.zkjl.wf_clserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.zkjl.wf_clserver.core")
public class WfClserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(WfClserverApplication.class, args);
	}
}
