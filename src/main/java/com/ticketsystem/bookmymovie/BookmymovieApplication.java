/*
This file contains the root class of the application that is instantiated on server start.
*/
package com.ticketsystem.bookmymovie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookmymovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookmymovieApplication.class, args);
	}

}
