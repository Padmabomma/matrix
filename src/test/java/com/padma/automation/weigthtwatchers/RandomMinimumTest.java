package com.padma.automation.weigthtwatchers;

import java.util.Random;

import org.testng.annotations.Test;

public class RandomMinimumTest {

	@Test
	public  void printRandomMinimum() {
		int min = (new Random()).nextInt(10000);
		//System.out.println(min);
		for(int i=1; i<500; i++){
			Random r = new Random();
			int next = r.nextInt(10000);
			//System.out.println(next);
			if(next<min){
				min = next;
			}
		}
		
		System.out.println("Final Min Random is ="+ min);

	}

}
