package com.infnet.appvenda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AppvendaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppvendaApplication.class, args);
	}

}
