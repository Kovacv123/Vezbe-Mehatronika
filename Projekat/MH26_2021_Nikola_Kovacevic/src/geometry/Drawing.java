package geometry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Drawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static final int point = 0;
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rectangle = 3;
	public static final int donut = 4;
	public static final int nothing = 5;
	private static int shape=5;
	private static int selectedID=-1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Drawing frame = new Drawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Drawing() {
		setTitle("Paint");
		Stack <Shape> stack = new Stack<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 583, 306);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{72, 72, 78, 99, 72, 166, 0};
		gbl_contentPane.rowHeights = new int[]{232, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		PnlDrawing panel = new PnlDrawing(stack);
		
		panel.setVisible(true);
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.VERTICAL;
		gbc_panel_1.gridx = 5;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{65, 0};
		gbl_panel_1.rowHeights = new int[]{30, 21, 21, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnNewButton_6 = new JButton("Delete!");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int result = JOptionPane.showConfirmDialog(null,"Are you sure you want to delete the selected shape?", "Confirmation", JOptionPane.YES_NO_OPTION);
			     if (result == JOptionPane.YES_OPTION) {
		            stack.remove(selectedID);
		            panel.update();
		        }
			}
		});
		
		JButton btnNewButton = new JButton("Modify!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ModDialog md = new ModDialog(selectedID, stack, panel);
					md.setModal(true);
					md.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnNewButton.setEnabled(false);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 1;
		panel_1.add(btnNewButton, gbc_btnNewButton);
		btnNewButton_6.setEnabled(false);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.gridx = 0;
		gbc_btnNewButton_6.gridy = 2;
		panel_1.add(btnNewButton_6, gbc_btnNewButton_6);
		
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (Shape s: stack) {
					if (s.isSelected()) {
						btnNewButton.setEnabled(true);
						btnNewButton_6.setEnabled(true);
						selectedID=stack.indexOf(s);
						break;
						
					}
					
					else {
						btnNewButton.setEnabled(false);
						btnNewButton_6.setEnabled(false);
					}
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("Point");
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Line");
		btnNewButton_2.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 1;
		gbc_btnNewButton_2.gridy = 1;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Circle");
		btnNewButton_3.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 1;
		contentPane.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Rectangle");
		btnNewButton_4.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 1;
		contentPane.add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Donut");
		btnNewButton_5.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 4;
		gbc_btnNewButton_5.gridy = 1;
		contentPane.add(btnNewButton_5, gbc_btnNewButton_5);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shape != point) {
					shape = point;
					btnNewButton_1.setBackground(new Color(192, 192, 192));
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
					btnNewButton_5.setBackground(new Color(240, 240, 240));
					
				}
				else {
					shape = nothing;
					btnNewButton_1.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shape != line) {
					shape = line;
					btnNewButton_2.setBackground(new Color(192, 192, 192));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
					btnNewButton_5.setBackground(new Color(240, 240, 240));
				}
				else {
					shape = nothing;
					btnNewButton_2.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shape != circle) {
					shape = circle;
					btnNewButton_3.setBackground(new Color(192, 192, 192));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
					btnNewButton_5.setBackground(new Color(240, 240, 240));
				}
				else {
					shape = nothing;
					btnNewButton_3.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shape != rectangle) {
					shape = rectangle;
					btnNewButton_4.setBackground(new Color(192, 192, 192));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_5.setBackground(new Color(240, 240, 240));
				}
				else {
					shape = nothing;
					btnNewButton_4.setBackground(new Color(240, 240, 240));
				}
			}
		});
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (shape != donut) {
					shape = donut;
					btnNewButton_5.setBackground(new Color(192, 192, 192));
					btnNewButton_1.setBackground(new Color(240, 240, 240));
					btnNewButton_2.setBackground(new Color(240, 240, 240));
					btnNewButton_3.setBackground(new Color(240, 240, 240));
					btnNewButton_4.setBackground(new Color(240, 240, 240));
				}
				else {
					shape = nothing;
					btnNewButton_5.setBackground(new Color(240, 240, 240));
				}
			}
		});
	}
	
	public static int getS() {
		return shape;
	}
	
	
	

}
