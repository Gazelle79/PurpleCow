package com.purplecow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@SpringBootApplication
@EnableCaching
public class PurpleCowApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(PurpleCowApplication.class, args);
	}


}
