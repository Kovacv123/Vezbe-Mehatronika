package geometry;

import java.awt.Graphics;

public class Circle extends Shape {

	protected int radius;
	protected Point center;
	
	public Circle() {
		
	}
	
	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}
	
	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		
	}
	
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		center.moveBy(byX, byY);
		
	}

	public double area() {
		return Math.PI * radius * radius;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}
	
	@Override
	public String toString() {
		return "Center: (" + center.getX() + "," + center.getY() + ")"
				+ ", radius = " + radius;
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle) o;
			return (int)(area() - temp.area());
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			if(radius == temp.getRadius() && center.equals(temp.getCenter())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		if(center.distance(new Point(x,y)) <= radius) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point p) {
		return contains(p.getX(), p.getY());
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}
	

}
