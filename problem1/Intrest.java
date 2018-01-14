package problem1;

import java.util.Scanner;

public class Intrest {

	public static void main (String[] args) {
		
		Scanner sc= new Scanner(System.in);
		
	float principle, time, rate, SI ;
	
	System.out.println("enter the pricipal");
	principle= sc.nextFloat();
	System.out.println("enter the time");
	time= sc.nextFloat();
	System.out.println("enter the rate");
	rate = sc.nextFloat();
	
	SI = (principle * rate * time) / 100;
	
	System.out.println("interest is = "+SI);

	
	
		
	}
	
}
