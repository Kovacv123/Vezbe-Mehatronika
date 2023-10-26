package geometry;

public class Circle {

	private int radius;
	private Point center;
	private boolean selected;

	public double area() {
		return Math.PI * radius * radius;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
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
