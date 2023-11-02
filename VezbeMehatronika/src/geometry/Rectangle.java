package geometry;

public class Rectangle {

	private Point upperLeft;
	private int width;
	private int height;
	private boolean selected;
	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeft, int width, int heigth) {
		this.upperLeft = upperLeft;
		this.width = width;
		this.height = heigth;
	}
	
	public Rectangle(Point upperLeft, int width, int heigth,boolean selected) {
		this(upperLeft, width, heigth);
		this.selected = selected;
	}

	public int area() {
		return width * height;
	}

	public int circumference() {
		return 2 * width + 2 * height;
	}
	
	@Override
	public String toString() {
		return "Upper left: (" + upperLeft.getX() + "," + upperLeft.getY() + "), "
				+ "width = " + width + ", height = " + height; 
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Rectangle) {
			Rectangle temp = (Rectangle) o;
			if(width == temp.getWidth() && height == temp.getHeight()) {
				return true;
			}
		}
		return false;
	}

	public Point getUpperLeft() {
		return upperLeft;
	}

	public void setUpperLeft(Point upperLeft) {
		this.upperLeft = upperLeft;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

}
