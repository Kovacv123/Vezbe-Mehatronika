package geometry;

import java.awt.EventQueue;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class Stek extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Stack<Circle> stack;  // Use Stack instead of DefaultListModel
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stek frame = new Stek();
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
	public Stek() {
		setTitle("Stack and Sort");
		setDefaultCloseOperation(Stek.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{200, 20, 45, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		Stack<Circle> stack = new Stack<>();
		DefaultListModel<String> dlm = new DefaultListModel<>();
		JList<String> list_1 = new JList<>(dlm);
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.gridheight = 3;
		gbc_list_1.insets = new Insets(0, 0, 0, 5);
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 0;
		contentPane.add(list_1, gbc_list_1);
		
		
		JButton btnNewButton = new JButton("Add a new circle!");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dijalog frame = new Dijalog(stack, dlm, true);
					frame.setVisible(true);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		
		
		
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		contentPane.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Remove a circle!");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Dijalog frame = new Dijalog(stack, dlm, false);
					frame.setVisible(true);
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 1;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Sort!");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=stack.size();i>0;i--) {
					for(int j=0; j<i-1;j++) {
						if(stack.elementAt(j).area()<stack.elementAt(j+1).area()) {
							Circle tempCircle = new Circle(stack.elementAt(j).getCenter(), stack.elementAt(j).getRadius());
							stack.removeElementAt(j);
							stack.insertElementAt(stack.elementAt(j), j + 1);
							stack.removeElementAt(j + 1);
							stack.insertElementAt(tempCircle, j + 1);
						}
					}
				}
				dlm.clear();
			    for (Circle crc : stack) {
			        dlm.addElement(crc.toString());
			    }
				
			   
			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 2;
		contentPane.add(btnNewButton_2, gbc_btnNewButton_2);
	}
	
	
	public void updateList() {
	       DefaultListModel<String> dlm = new DefaultListModel<>();
	       for (Circle crc : stack) {
	           dlm.addElement(crc.toString());
	       }
	      
	   }
	public void addCircle(Circle crc) {
	       stack.push(crc);
	       updateList();
	   }

}
