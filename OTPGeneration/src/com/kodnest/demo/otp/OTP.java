package com.kodnest.demo.otp;

import java.util.Random;

public class OTP {
	
	public static void main(String[] args) {
		
		Random rd = new Random();
		int val = rd.nextInt(100000, 1000000);
		System.out.println(val);
	}

}
