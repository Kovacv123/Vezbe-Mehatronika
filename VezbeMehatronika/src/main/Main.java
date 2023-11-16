package main;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

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
//		for(int godina = 2023; godina<=2100; godina+=4) {
//			if(godina == 2023) {
//				godina++;
//			}
//			else if(godina%100 == 0) {
//				if(!(godina%400 == 0)) {
//					continue;
//				}
//			}
//			System.out.println(godina);
//		}
		
		
		
		
		//VEZBE 3 - Osnove objektnog programiranja
//		Point p1 = new Point(); //slozena promenljiva - referenca
//		System.out.println(p1);
//		System.out.println(p1.getX());
//		System.out.println(p1.getY());
//		System.out.println(p1.isSelected());
//		// p1 -> x(0),y(0),selected(false) Objekat 1
//		p1.setX(20); // p1 -> x(20),y(0),selected(false) Objekat 1
//		Point p2 = new Point(); // p2 -> x(0), y(0), selected(false) Objekat 2
//		p1.setY(10);
//		p2.setX(10);
//		p2.setY(10);
//		//p1 -> x(20),y(10),selected(false) Objekat 1
//		// p2 -> x(10), y(10), selected(false) Objekat 2
//		double udaljenost = p1.distance(p2);
//		System.out.println("Udaljenost izmedju p1 i p2 je: " + udaljenost);
//		p1 = p2; // p1,p2 -> x(10), y(10), selected(false) Objekat 2
//		System.out.println(p1.getX());
//		p2.setSelected(true);
//		System.out.println(p1.isSelected());
//		
//		Line l1 = new Line();
//		System.out.println(l1.getStartPoint());
//		l1.setStartPoint(p1); // startPoint,p1,p2 -> x(10), y(10), selected(false) Objekat 2
//		p2.setX(50); // startPoint,p1,p2 -> x(50), y(10), selected(false) Objekat 2
//		System.out.println(l1.getStartPoint().getX());
//		
//		//Vezbe 4
//		
//		System.out.println("Izvrsavanje toString metode: " + p1.toString());
//		
//		int prviBroj = 50;
//		int drugiBroj = 50;
//		String prviString = "prvi";
//		String kopija = "prvi";
//		Rectangle r1 = new Rectangle(new Point(10,10), 40,40);
//		Rectangle r2 = new Rectangle(new Point(10,10), 40,40);
//		
//		System.out.println("Znak jednakosti kod primitiva: " + (prviBroj == drugiBroj));
//		System.out.println("Znak jednakosti kod Stringova: " + prviString == kopija);
//		System.out.println("Znak jednakosti kod referenci: " + (r1==r2));
		
		
		//VEZBE 5 - Nasledjivanje
		Donut d1 = new Donut(new Point(50,50), 30, true, 20);
		System.out.println(d1);
		System.out.println(d1 instanceof Donut);
		System.out.println(d1 instanceof Circle);
		System.out.println(d1 instanceof Object);
	}

}
