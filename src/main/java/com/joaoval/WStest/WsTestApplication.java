package com.joaoval.WStest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import java.io.IOException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class WsTestApplication {

	public static void main(String[] args) throws IOException{
		SpringApplication.run(WsTestApplication.class, args);
	}

}
