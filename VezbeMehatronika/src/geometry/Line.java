package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint,boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
		if(selected) {
			g.setColor(Color.BLUE);
			g.drawRect(startPoint.getX()-3, startPoint.getY()-3, 6, 6);
			g.drawRect(endPoint.getX()-3, endPoint.getY()-3, 6, 6);
		}
		
	}
	
	@Override
	public void moveTo(int x, int y) {
		
	}

	@Override
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);	
	}
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	@Override
	public String toString() {
		return "(" + startPoint.getX() + "," + startPoint.getY() + ")"
				+ "---> (" + endPoint.getX() + "," + endPoint.getY() + ")";  
	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			Line temp = (Line) o;
			return (int) (length() - temp.length());
		}
		return 0;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Line) {
			Line temp = (Line) o;
			if(startPoint.equals(temp.getStartPoint()) && endPoint.equals(temp.getEndPoint())) {
				return true;
			}
		}
		return false;
	}
	
	public boolean contains(int x, int y) {
		return (length() - startPoint.distance(new Point(x,y)) - 
				endPoint.distance(new Point(x,y))) <= 3;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

	
	
}
