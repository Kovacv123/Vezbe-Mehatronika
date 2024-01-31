package geometry;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import java.awt.event.MouseMotionAdapter;




public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int point = 0;
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rectangle = 3;
	public static final int donut = 4;
	public static final int nothing = 5;
	private boolean started = false;
	private Stack<Shape> stack;
	private int startX, startY, endY, endX;


	/**
	 * Create the panel.
	 */
	
	public PnlDrawing(Stack <Shape> stack) {
		this.stack = stack;
		addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				switch (Drawing.getS()) {
					case point: {
						Point p1 = new Point(e.getX(), e.getY());
						stack.push(p1);
						break;
					}
					case line: {
						if (!started) {
							startX = e.getX();
							startY = e.getY();
							started = true;
						}
						else if (started){							
							endX = e.getX();
							endY = e.getY();
							Line l1 = new Line(new Point(startX, startY), new Point(endX, endY));
							stack.push(l1);
							started = false;
						}
						break;	
					}
					case rectangle: {
						try {
							RectDialog frame = new RectDialog(stack, new Point(e.getX(), e.getY()));
							frame.setModal(true);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						break;
						
					}
					case circle: {
						try {
							CircDialog frame = new CircDialog(stack, new Point(e.getX(), e.getY()));
							frame.setModal(true);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						break;
						
					}
					case donut: {
						try {
							DonutDialog frame = new DonutDialog(stack,new Point(e.getX(), e.getY()));
							frame.setModal(true);
							frame.setVisible(true);
						} catch (Exception ex) {
							ex.printStackTrace();
						}
						break;
						
					}
					case nothing: {
						boolean flag = false;
						for (int i = stack.size() - 1; i >= 0; i--) {
							Shape s = stack.get(i);
							s.setSelected(false);
							if (s.contains(e.getX(), e.getY())) {
								if (!flag) {
									s.setSelected(true);
									flag = true;
								}
							}
						}
						break;
					}
				}
				paint(getGraphics());
			}
		});
	}
	
	public void paint(Graphics g) {
		 super.paint(g);
	        for (Shape shape : stack) {
	            shape.draw(g);
	        }
	}
	
	public void update() {
		paint(getGraphics());
	}
	
	
	
	
}
