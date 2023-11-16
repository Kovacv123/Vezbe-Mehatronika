package geometry;

import java.awt.Color;
import java.awt.Graphics;

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
		//Point p1 = new Point(500,200);
		//Line l1 = new Line(p1, new Point(500,500));
		Rectangle r1 = new Rectangle(new Point(600,200), 100, 100);
		//Circle c1 = new Circle(new Point(550,200),50);
		Donut d1 = new Donut(new Point(400,300),50,false,30);
		
		g.setColor(Color.BLUE);
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
		d1.setRadius(radius);
		d1.setCenter(center);
		r1.draw(g);
		d1.draw(g);
		
		}
	
	

}
