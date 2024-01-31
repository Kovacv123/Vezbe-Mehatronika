package geometry;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Dijalog extends Stek {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldx;
	private JTextField textFieldy;
	private JTextField textFieldr;

	/**
	 * Create the frame.
	 * @param jFrame 
	 */
	public Dijalog(Stack <Circle> stack, DefaultListModel<String> dlm, boolean create) {
		super();
		boolean cr = create;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{132, 194, 115, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel = new JLabel("X:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		textFieldx = new JTextField();
		textFieldx.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c<'0' || c>'9') {
					e.consume();
				}
			}
		});
		if (create == false) {
			textFieldx.setText(Integer.toString(stack.get(stack.size()-1).getCenter().getX()));
		}
		textFieldx.setEnabled(create);
		textFieldx.setEditable(create);
		GridBagConstraints gbc_textFieldx = new GridBagConstraints();
		gbc_textFieldx.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldx.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldx.gridx = 1;
		gbc_textFieldx.gridy = 1;
		contentPane.add(textFieldx, gbc_textFieldx);
		textFieldx.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Y:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textFieldy = new JTextField();
		textFieldy.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c<'0' || c>'9') {
					e.consume();	
				}
			}
		});
		textFieldy.setEnabled(create);
		textFieldy.setEditable(create);
		if (create == false) {
			textFieldy.setText(Integer.toString(stack.get(stack.size()-1).getCenter().getY()));
		}
		GridBagConstraints gbc_textFieldy = new GridBagConstraints();
		gbc_textFieldy.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldy.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldy.gridx = 1;
		gbc_textFieldy.gridy = 2;
		contentPane.add(textFieldy, gbc_textFieldy);
		textFieldy.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Radius:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 3;
		contentPane.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldr = new JTextField();
		textFieldr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if (c<'1' || c>'9') {
					e.consume();	
				}
			}
		});
		textFieldr.setEnabled(create);
		textFieldr.setEditable(create);
		if (create == false) {
			textFieldr.setText(Integer.toString(stack.get(stack.size()-1).getRadius()));
		}
		GridBagConstraints gbc_textFieldr = new GridBagConstraints();
		gbc_textFieldr.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldr.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldr.gridx = 1;
		gbc_textFieldr.gridy = 3;
		contentPane.add(textFieldr, gbc_textFieldr);
		textFieldr.setColumns(10);
		String btnText;
		if (create == true) {
			btnText = "Create!";
		}
		else {
			btnText = "Remove!";
		}
		
		JButton btnNewButton = new JButton(btnText);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (create == true) {
						Point p1 = new Point(Integer.parseInt(textFieldx.getText()), Integer.parseInt(textFieldy.getText()));
						Circle crc = new Circle(p1, Integer.parseInt(textFieldr.getText()));
						stack.push(crc);
						dlm.clear();
						for (Circle item : stack) {
							dlm.add(0, item.toString());
						}
						dispose();
						} 
					else {
						stack.remove(stack.size()-1);
						dlm.clear();
						for (Circle item : stack) {
							dlm.add(0, item.toString());
						}
						dispose();
					}
				}
				catch(NumberFormatException ex) {
					JOptionPane.showMessageDialog(Dijalog.this, "Please enter values for X, Y, and radius.", "Input Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 4;
		contentPane.add(btnNewButton, gbc_btnNewButton);
	}

}
