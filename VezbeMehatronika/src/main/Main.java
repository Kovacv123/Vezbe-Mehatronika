package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
//		System.out.println("Unesite zeljenu operaciju");
//		Scanner scanner = new Scanner(System.in);
//		char operacija = scanner.next().charAt(0);
//		
//		if(operacija == '+') {
//			System.out.println(24+12);
//		}else if (operacija == '-') {
//			System.out.println(24-12);
//		}else if (operacija == '*') {
//			System.out.println(24*12);
//		}else if (operacija == '/') {
//			System.out.println(24/12);
//		}else {
//			System.out.println("Uneta je nepoznata operacija");
//		}
		
		// FOR PETLJA
//		for(int i = 1; i <=10; i++) {
//			System.out.println(i);
//		}
		
		// WHILE PETLJA
//		int i = 1;
//		while(i<=10) {
//			System.out.println(i);
//			i++;
//		}
		
		// DO WHILE PETLJA
//		int k = 1;
//		do {
//			System.out.println(k);
//			k++;
//		}while(k<=10);
		
		//ZADATAK 1 - Zbir parnih brojeva
//		System.out.println("Unesite broj od 1 do 200");
//		Scanner scanner = new Scanner(System.in);
//		int broj = scanner.nextInt();
//		
//		int zbir = 0;
//		if(broj <= 200) {
//			for(int i = 0; i<=broj; i += 2) {
//				//zbir = zbir + i;
//				zbir += i;
//			}
//		}else {
//			System.out.println("Nevalidna vrednost");
//		}
//		System.out.println(zbir);
		
		//ZADATAK 2 - Parne godine
		for(int godina = 2023; godina<=2100; godina+=4) {
			if(godina == 2023) {
				godina++;
			}
			else if(godina%100 == 0) {
				if(!(godina%400 == 0)) {
					continue;
				}
			}
			System.out.println(godina);
		}

	}

}
