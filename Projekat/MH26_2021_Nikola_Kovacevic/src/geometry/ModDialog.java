package geometry;


import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.util.Stack;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JColorChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class ModDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	public static final int point = 0;
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rectangle = 3;
	public static final int donut = 4;
	private String name;
	private final JPanel contentPanel = new JPanel();
	private String lbl1;
	private String lbl2;
	private String lbl3;
	private String lbl4;
	private String lbl5;
	private String lbl6;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private Color borderColor = Color.BLACK;
	private Color fillColor = Color.WHITE;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		try {
			ModDialog dialog = new ModDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	/**
	 * Create the dialog.
	 */
	public ModDialog(int selectedID, Stack <Shape>stack, PnlDrawing pnl) {
		int shape = stack.get(selectedID).getShape();
		stack.get(selectedID).getClass();
		switch (shape) {
		case point: {
			name = "point";
			lbl1 = "X: ";
			lbl2 = "Y: ";
			lbl3 = "Color: ";
			borderColor = ((Point)stack.get(selectedID)).getColor();
			break;
		}
		case line: {
			name = "line";
			lbl1 = "Starting point X: ";
			lbl2 = "Starting point Y: ";
			lbl3 = "Color: ";
			lbl4 = "Ending point X: ";
			lbl5 = "Ending point Y: ";
			borderColor = ((Line)stack.get(selectedID)).getColor();
			break;
		}
		case circle: {
			name = "circle";
			lbl1 = "Center X: ";
			lbl2 = "Center Y: ";
			lbl3 = "Border color: ";
			lbl4 = "Fill color: ";
			lbl5 = "Radius: ";
			borderColor = ((Circle)stack.get(selectedID)).getBorderColor();
			fillColor = ((Circle)stack.get(selectedID)).getFillColor();
			break;
		}
		case rectangle: {
			name = "rectangle";
			lbl1 = "Top left point X: ";
			lbl2 = "Top left point Y: ";
			lbl5 = "Width: ";
			lbl6 = "Height: ";
			lbl3 = "Border color: ";
			lbl4 = "Fill color";
			borderColor = ((Rectangle)stack.get(selectedID)).getBorderColor();
			fillColor = ((Rectangle)stack.get(selectedID)).getFillColor();
			break;
		}
		case donut: {
			name = "donut";
			lbl1 = "Center X: ";
			lbl2 = "Center Y: ";
			lbl3 = "Border color: ";
			lbl4 = "Fill color: ";
			lbl5 = "Inner radius: ";
			lbl6 = "Outer radius: ";
			borderColor = ((Donut)stack.get(selectedID)).getBorderColor();
			fillColor = ((Donut)stack.get(selectedID)).getFillColor();
			break;
		}
		}
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.WEST);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0};
			gbl_panel.rowHeights = new int[]{0};
			gbl_panel.columnWeights = new double[]{Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
		}	
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("Modify " + name);
				lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
				lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
				panel.add(lblNewLabel);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{153, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			
			
			
			{
				JLabel lblNewLabel_1 = new JLabel(lbl1);
				GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
				gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_1.gridx = 0;
				gbc_lblNewLabel_1.gridy = 0;
				panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
			}
			{
				textField_1 = new JTextField();
				textField_1.setText("1");
				GridBagConstraints gbc_textField_1 = new GridBagConstraints();
				gbc_textField_1.insets = new Insets(0, 0, 5, 0);
				gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_1.gridx = 1;
				gbc_textField_1.gridy = 0;
				panel.add(textField_1, gbc_textField_1);
				textField_1.setColumns(10);
			}
			{
				JLabel lblNewLabel_2 = new JLabel(lbl2);
				GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
				gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_2.gridx = 0;
				gbc_lblNewLabel_2.gridy = 1;
				panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
			}
			{
				textField_2 = new JTextField();
				textField_2.setText("2");
				GridBagConstraints gbc_textField_2 = new GridBagConstraints();
				gbc_textField_2.insets = new Insets(0, 0, 5, 0);
				gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_2.gridx = 1;
				gbc_textField_2.gridy = 1;
				panel.add(textField_2, gbc_textField_2);
				textField_2.setColumns(10);
			}
			{
				JLabel lblNewLabel_3 = new JLabel(lbl3);
				GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
				gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_3.gridx = 0;
				gbc_lblNewLabel_3.gridy = 2;
				panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
			}
			{
				textField_3 = new JTextField();
				textField_3.setEditable(false);
				textField_3.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						borderColor = JColorChooser.showDialog(ModDialog.this, "Choose border color", borderColor);
						textField_3.setText(borderColor.toString());
					}
				});
		
				textField_3.setText(borderColor.toString());
				GridBagConstraints gbc_textField_3 = new GridBagConstraints();
				gbc_textField_3.insets = new Insets(0, 0, 5, 0);
				gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_3.gridx = 1;
				gbc_textField_3.gridy = 2;
				panel.add(textField_3, gbc_textField_3);
				textField_3.setColumns(10);
			}
			{
				JLabel lblNewLabel_4 = new JLabel(lbl4);
				GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
				gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_4.gridx = 0;
				gbc_lblNewLabel_4.gridy = 3;
				panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
			}
			{
				textField_4 = new JTextField();
				textField_4.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						fillColor = JColorChooser.showDialog(ModDialog.this, "Choose fill color", fillColor);
						textField_4.setText(fillColor.toString());
					}
				});
				textField_4.setEditable(false);
				textField_4.setText("4");
				GridBagConstraints gbc_textField_4 = new GridBagConstraints();
				gbc_textField_4.insets = new Insets(0, 0, 5, 0);
				gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_4.gridx = 1;
				gbc_textField_4.gridy = 3;
				panel.add(textField_4, gbc_textField_4);
				textField_4.setColumns(10);
			}
			{
				JLabel lblNewLabel_5 = new JLabel(lbl5);
				GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
				gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
				gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_5.gridx = 0;
				gbc_lblNewLabel_5.gridy = 4;
				panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
			}
			{
				textField_5 = new JTextField();
				textField_5.setText("5");
				GridBagConstraints gbc_textField_5 = new GridBagConstraints();
				gbc_textField_5.insets = new Insets(0, 0, 5, 0);
				gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_5.gridx = 1;
				gbc_textField_5.gridy = 4;
				panel.add(textField_5, gbc_textField_5);
				textField_5.setColumns(10);
			}
			{
				JLabel lblNewLabel_6 = new JLabel(lbl6);
				GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
				gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
				gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
				gbc_lblNewLabel_6.gridx = 0;
				gbc_lblNewLabel_6.gridy = 5;
				panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
			}
			{
				textField_6 = new JTextField();
				GridBagConstraints gbc_textField_6 = new GridBagConstraints();
				gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
				gbc_textField_6.gridx = 1;
				gbc_textField_6.gridy = 5;
				panel.add(textField_6, gbc_textField_6);
				textField_6.setColumns(10);
			}
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.SOUTH);
		}
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.EAST);
		}
		
		switch (shape) {
		case point: {
			textField_1.setText("" + ((Point)stack.get(selectedID)).getX());
			textField_2.setText("" + ((Point)stack.get(selectedID)).getY());
			textField_3.setText("" + ((Point)stack.get(selectedID)).getColor().toString());
			textField_4.setVisible(false);
			textField_5.setVisible(false);
			textField_6.setVisible(false);
			break;
		}
		case line: {
			textField_1.setText("" + ((Line)stack.get(selectedID)).getStartPoint().getX());
			textField_2.setText("" + ((Line)stack.get(selectedID)).getStartPoint().getY());
			textField_3.setText("" + ((Line)stack.get(selectedID)).getColor().toString());
			textField_4.setText("" + ((Line)stack.get(selectedID)).getEndPoint().getX());
			textField_5.setText("" + ((Line)stack.get(selectedID)).getEndPoint().getY());
			textField_6.setVisible(false);
			break;
		}
		case circle: {
			textField_1.setText("" + ((Circle)stack.get(selectedID)).getCenter().getX());
			textField_2.setText("" + ((Circle)stack.get(selectedID)).getCenter().getY());
			textField_3.setText("" + ((Circle)stack.get(selectedID)).getBorderColor().toString());
			textField_4.setText("" + ((Circle)stack.get(selectedID)).getFillColor().toString());
			textField_5.setText("" + ((Circle)stack.get(selectedID)).getRadius());
			textField_6.setVisible(false);
			break;
		}
		case rectangle: {
			textField_1.setText("" + ((Rectangle)stack.get(selectedID)).getUpperLeft().getX());
			textField_2.setText("" + ((Rectangle)stack.get(selectedID)).getUpperLeft().getY());
			textField_3.setText("" + ((Rectangle)stack.get(selectedID)).getBorderColor().toString());
			textField_4.setText("" + ((Rectangle)stack.get(selectedID)).getFillColor().toString());
			textField_5.setText("" + ((Rectangle)stack.get(selectedID)).getWidth());
			textField_6.setText("" + ((Rectangle)stack.get(selectedID)).getHeight());
			break;
		}
		case donut: {
			textField_1.setText("" + ((Donut)stack.get(selectedID)).getCenter().getX());
			textField_2.setText("" + ((Donut)stack.get(selectedID)).getCenter().getY());
			textField_3.setText("" + ((Donut)stack.get(selectedID)).getBorderColor().toString());
			textField_4.setText("" + ((Donut)stack.get(selectedID)).getFillColor().toString());
			textField_5.setText("" + ((Donut)stack.get(selectedID)).getInnerRadius());
			textField_6.setText("" + ((Donut)stack.get(selectedID)).getRadius());
			break;
		}
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						switch (shape) {
						case point: {
							stack.get(selectedID).moveTo(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText()));
							((Point)stack.get(selectedID)).setColor(borderColor);
							pnl.update();
							dispose();
							break;
						}
						case line: {
							((Line)stack.get(selectedID)).setStartPoint(new Point(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText())));
							((Line)stack.get(selectedID)).setEndPoint(new Point(Integer.parseInt(textField_4.getText()), Integer.parseInt(textField_5.getText())));
							((Line)stack.get(selectedID)).setColor(borderColor);
							pnl.update();
							dispose();
							break;
						}
						case circle: {
							((Circle)stack.get(selectedID)).setCenter(new Point(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText())));
							((Circle)stack.get(selectedID)).setRadius(Integer.parseInt(textField_5.getText()));
							((Circle)stack.get(selectedID)).setBorderColor(borderColor);
					        ((Circle)stack.get(selectedID)).setFillColor(fillColor);
							pnl.update();
							dispose();
							break;
						}
						case rectangle: {
							((Rectangle)stack.get(selectedID)).setUpperLeft(new Point(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText())));
							((Rectangle)stack.get(selectedID)).setWidth(Integer.parseInt(textField_5.getText()));
							((Rectangle)stack.get(selectedID)).setHeight(Integer.parseInt(textField_6.getText()));
							((Rectangle)stack.get(selectedID)).setBorderColor(borderColor);
					        ((Rectangle)stack.get(selectedID)).setFillColor(fillColor);
							pnl.update();
							dispose();
							break;
						}
						case donut: {
							((Donut)stack.get(selectedID)).setCenter(new Point(Integer.parseInt(textField_1.getText()), Integer.parseInt(textField_2.getText())));
							((Donut)stack.get(selectedID)).setRadius(Integer.parseInt(textField_6.getText()));
							((Donut)stack.get(selectedID)).setInnerRadius(Integer.parseInt(textField_5.getText()));
							((Donut)stack.get(selectedID)).setBorderColor(borderColor);
					        ((Donut)stack.get(selectedID)).setFillColor(fillColor);
							pnl.update();
							dispose();
							break;
						}
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
