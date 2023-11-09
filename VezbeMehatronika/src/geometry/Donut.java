package geometry;

public class Donut extends Circle {

	private int innerRadius;
	
	public Donut() {
		
	}
	
	public Donut(Point center, int radius, boolean selected, int innerRadius) {
		super(center, radius, selected);
		this.innerRadius = innerRadius;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
}
