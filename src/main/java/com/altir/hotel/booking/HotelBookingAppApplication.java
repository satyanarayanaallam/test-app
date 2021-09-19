package com.altir.hotel.booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HotelBookingAppApplication implements Runnable{

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingAppApplication.class, args);
	}

	@Override
	public void run() {

	}
}
