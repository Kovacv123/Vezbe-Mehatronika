package geometry;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawing extends JPanel {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); // Prozor u kom se nalazi panel
		Drawing drawing = new Drawing(); // Instanca panela
		frame.setContentPane(drawing); // Postavljanje panela u prozor
		frame.setSize(900,600); // Velicina prozora
		frame.setLocationRelativeTo(null); // Centriranje prozora na ekranu
		frame.setVisible(true); // Prikazivanje prozora - obavezno
	}
	
	
	public void paint(Graphics g) {
		Point p1 = new Point(500,200);
		Line l1 = new Line(p1, new Point(500,500));
		Rectangle r1 = new Rectangle(new Point(600,200), 100, 100);
		Circle c1 = new Circle(new Point(550,200),50);
		Donut d1 = new Donut(new Point(400,300),50,false,30);
		
//		g.setColor(Color.BLUE);
		//p1.draw(g);
		//l1.draw(g);
		//r1.draw(g);
		//c1.draw(g);
		//d1.draw(g);
		
		//Zadatak 5
		int innerRadius = (int) ((r1.getWidth()*Math.sqrt(2))/2);
		int radius = 80;
		Point center = new Point(r1.getUpperLeft().getX() + r1.getWidth()/2 , 
				r1.getUpperLeft().getY() + r1.getHeight()/2);
		d1.setInnerRadius(innerRadius);
		try {
			d1.setRadius(radius);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		d1.setCenter(center);
//		r1.draw(g);
//		d1.draw(g);
		
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(p1);
		shapes.add(l1);
		shapes.add(r1);
		shapes.add(c1);
		shapes.add(d1);
		
//		for(Shape s: shapes) {
//			g.setColor(Color.BLUE);
//			s.draw(g);
//			g.setColor(Color.RED);
//			s.moveBy(10, 0);
//			s.draw(g);
//		}
		
//		shapes.get(2).draw(g);
//		shapes.get(shapes.size()-1).draw(g);
//		shapes.remove(1);
//		shapes.get(1).draw(g);
//		shapes.add(3, l1);
		
//		for(Shape s: shapes) {
//			if(s instanceof Circle
//				&& !(s instanceof Donut)) {
//				s.draw(g);
//			}
//			
//			if(s instanceof Circle ||
//					s instanceof Rectangle) {
//				s.draw(g);
//			}
//		}
		
		
		//Zadatak 7
		HashMap<String,Shape> hmShapes = new HashMap<String,Shape>();
		for(Shape s: shapes) {
			if(s instanceof Point) {
				hmShapes.put("Point", s);
			}
			else if(s instanceof Line) {
				hmShapes.put("Line", s);
			}
			else if(s instanceof Rectangle) {
				hmShapes.put("Rectangle", s);
			}
			else if(s instanceof Donut) {
				hmShapes.put("Donut", s);
			}
			else if(s instanceof Circle) {
				hmShapes.put("Circle", s);
			}else {
				System.out.println(s + " is an unknown Shape");
				//continue;
			}
			
			//s.draw(g);
			
		}
		
		for(Map.Entry<String, Shape> es : hmShapes.entrySet()) {
			System.out.println("Object is: " + es.getKey());
			es.getValue().draw(g);
		}
		
	}
	
	

}
