package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmIgraci extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmIgraci frame = new FrmIgraci();
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
	public FrmIgraci() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 401);
		contentPane = new JPanel();
		contentPane.setBackground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		panelNorth.setForeground(Color.BLACK);
		panelNorth.setBackground(Color.YELLOW);
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Forma za unos igraca");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelNorth.add(lblTitle);
		
		JPanel panelSouth = new JPanel();
		panelSouth.setBackground(Color.PINK);
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnDialog = new JButton("Dijalog Igrac");
		btnDialog.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgIgrac dijalog = new DlgIgrac();
				dijalog.setVisible(true);
				listInputNoDuplicates(dijalog.getTextFieldIme().getText() + " " + dijalog.getTextFieldPrezime().getText(), dlm);
			}
		});
		btnDialog.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelSouth.add(btnDialog);
		
		JList<String> list = new JList<String>();
		
		JButton btnModify = new JButton("Modifikacija");
		btnModify.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DlgIgrac dijalog = new DlgIgrac();
				int selectedIndex = list.getSelectedIndex();
				if(selectedIndex != -1) {
					String odabraniIgrac = dlm.get(selectedIndex);
					String[] rastavljenoImeIPrezime = odabraniIgrac.split(" ");
					if(rastavljenoImeIPrezime.length > 1) {
						dijalog.getTextFieldIme().setText(rastavljenoImeIPrezime[0]);
						dijalog.getTextFieldPrezime().setText(rastavljenoImeIPrezime[1]);
					}else {
						dijalog.getTextFieldPrezime().setText(rastavljenoImeIPrezime[0]);
					}
					dijalog.setVisible(true);
					dlm.add(selectedIndex, dijalog.getTextFieldIme().getText() + " " + dijalog.getTextFieldPrezime().getText());
					dlm.remove(selectedIndex+1);
					
					
				}else {
					JOptionPane.showMessageDialog(null, "Prvo morate odabrati igraca za modifikaciju", "Greska!", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelSouth.add(btnModify);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setBackground(Color.PINK);
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{100, 300, 200, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 20, 0, 20, 0, 20, 0, 20, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblPrva = new JLabel("Dusan Vlahovic");
		JButton btnPrvi = new JButton("Vlahovic");
		btnPrvi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listInputNoDuplicates(lblPrva.getText(), dlm);
			}
		});
		btnPrvi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnPrvi = new GridBagConstraints();
		gbc_btnPrvi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnPrvi.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrvi.gridx = 0;
		gbc_btnPrvi.gridy = 0;
		panelCenter.add(btnPrvi, gbc_btnPrvi);
		
		
		lblPrva.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints gbc_lblPrva = new GridBagConstraints();
		gbc_lblPrva.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrva.gridx = 1;
		gbc_lblPrva.gridy = 0;
		panelCenter.add(lblPrva, gbc_lblPrva);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 0;
		panelCenter.add(scrollPane, gbc_scrollPane);
		
		list.setModel(dlm);
		list.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setViewportView(list);
		
		JLabel lblDruga = new JLabel("Dusan Tadic");
		JButton btnDrugi = new JButton("Tadic");
		btnDrugi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listInputNoDuplicates(lblDruga.getText(), dlm);
			}
		});
		btnDrugi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnDrugi = new GridBagConstraints();
		gbc_btnDrugi.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDrugi.insets = new Insets(0, 0, 5, 5);
		gbc_btnDrugi.gridx = 0;
		gbc_btnDrugi.gridy = 2;
		panelCenter.add(btnDrugi, gbc_btnDrugi);
		
		
		lblDruga.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints gbc_lblDruga = new GridBagConstraints();
		gbc_lblDruga.insets = new Insets(0, 0, 5, 5);
		gbc_lblDruga.gridx = 1;
		gbc_lblDruga.gridy = 2;
		panelCenter.add(lblDruga, gbc_lblDruga);
		
		JLabel lblTreca = new JLabel("Aleksandar Mitrovic");
		JButton btnTreci = new JButton("Mitrovic");
		btnTreci.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listInputNoDuplicates(lblTreca.getText(), dlm);
			}
		});
		btnTreci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_btnTreci = new GridBagConstraints();
		gbc_btnTreci.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTreci.insets = new Insets(0, 0, 5, 5);
		gbc_btnTreci.gridx = 0;
		gbc_btnTreci.gridy = 4;
		panelCenter.add(btnTreci, gbc_btnTreci);
		
		
		lblTreca.setFont(new Font("Verdana", Font.BOLD, 15));
		GridBagConstraints gbc_lblTreca = new GridBagConstraints();
		gbc_lblTreca.insets = new Insets(0, 0, 5, 5);
		gbc_lblTreca.gridx = 1;
		gbc_lblTreca.gridy = 4;
		panelCenter.add(lblTreca, gbc_lblTreca);
		
		JCheckBox checkBox = new JCheckBox("Unos");
		checkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkBox.isSelected()) {
					textField.setEnabled(true);
				}else {
					textField.setEnabled(false);
				}
			}
		});
		checkBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		checkBox.setBackground(Color.PINK);
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.insets = new Insets(0, 0, 5, 5);
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 6;
		panelCenter.add(checkBox, gbc_checkBox);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if( (c >= 'A' && c<='Z') || (c >= 'a' && c<= 'z') || c==KeyEvent.VK_ENTER || c==KeyEvent.VK_BACK_SPACE || c==KeyEvent.VK_SPACE ) {
					if(c == KeyEvent.VK_ENTER) {
						listInputNoDuplicates(textField.getText(), dlm);
						textField.setText("");
					}
				}else {
					e.consume();
				}
			}
		});
		textField.setEnabled(false);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		panelCenter.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblIgraci = new JLabel("Igraci");
		lblIgraci.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblIgraci = new GridBagConstraints();
		gbc_lblIgraci.insets = new Insets(0, 0, 0, 5);
		gbc_lblIgraci.gridx = 0;
		gbc_lblIgraci.gridy = 8;
		panelCenter.add(lblIgraci, gbc_lblIgraci);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem() != null) {
					listInputNoDuplicates(comboBox.getSelectedItem().toString(), dlm);
				}
				
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Milinkovic Savic", "Gudelj", "Pavlovic"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 8;
		panelCenter.add(comboBox, gbc_comboBox);
	}
	
	public void listInputNoDuplicates(String input, DefaultListModel<String> dlm ) {
		if(dlm.contains(input) || input.isBlank()) {
			return;
		}else {
			dlm.add(0, input);
		}
	}

}
