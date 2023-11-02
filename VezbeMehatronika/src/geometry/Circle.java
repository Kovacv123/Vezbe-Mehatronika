package geometry;

public class Circle {

	private int radius;
	private Point center;
	private boolean selected;
	
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
	public boolean equals(Object o) {
		if(o instanceof Circle) {
			Circle temp = (Circle)o;
			if(radius == temp.getRadius()) {
				return true;
			}
		}
		return false;
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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
