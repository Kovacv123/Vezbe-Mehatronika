package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class TestFrame extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<String> dlm = new DefaultListModel<String>();
	private JPanel panelCenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestFrame frame = new TestFrame();
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
	public TestFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 542, 421);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNorth = new JPanel();
		contentPane.add(panelNorth, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("Prvi frejm");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		panelNorth.add(lblTitle);
		
		panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{0, 0, 0, 150, 30, 136, 40, 0};
		gbl_panelCenter.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelCenter.columnWeights = new double[]{2.0, 0.0, 1.0, 0.0, 2.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridheight = 7;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 5;
		gbc_scrollPane.gridy = 0;
		panelCenter.add(scrollPane, gbc_scrollPane);
		
		JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				
				try {
					chooseBackgroundColor(1);
					
				} catch (ArrayIndexOutOfBoundsException e2) {
					return;
				}
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				try {
					chooseBackgroundColor(0);
				} catch (ArrayIndexOutOfBoundsException e2) {
					return;
				}
			}
		});
		list.setModel(dlm);
		scrollPane.setViewportView(list);
		
		JLabel lblCrvena = new JLabel("Crvena");
		lblCrvena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 1;
		panelCenter.add(lblCrvena, gbc_lblCrvena);
		
		JButton btnCrvena = new JButton("Oboji me u crveno!");
		btnCrvena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCenter.setBackground(new Color(200,0,0));
				dlm.add(0, "Crvena");
			}
		});
		btnCrvena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnCrvena = new GridBagConstraints();
		gbc_btnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrvena.gridx = 3;
		gbc_btnCrvena.gridy = 1;
		panelCenter.add(btnCrvena, gbc_btnCrvena);
		
		JLabel lblPlava = new JLabel("Plava");
		lblPlava.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 3;
		panelCenter.add(lblPlava, gbc_lblPlava);
		
		JButton btnPlava = new JButton("Oboji me u plavo!");
		btnPlava.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCenter.setBackground(new Color(0,50,150));
				dlm.add(0, "Plava");
			}
		});
		btnPlava.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnPlava = new GridBagConstraints();
		gbc_btnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_btnPlava.gridx = 3;
		gbc_btnPlava.gridy = 3;
		panelCenter.add(btnPlava, gbc_btnPlava);
		
		JLabel lblZelena = new JLabel("Zelena");
		lblZelena.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_lblZelena = new GridBagConstraints();
		gbc_lblZelena.insets = new Insets(0, 0, 5, 5);
		gbc_lblZelena.gridx = 1;
		gbc_lblZelena.gridy = 5;
		panelCenter.add(lblZelena, gbc_lblZelena);
		
		JButton btnZelena = new JButton("Oboji me u zeleno!");
		btnZelena.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				panelCenter.setBackground(new Color(0,200,0));
				dlm.add(0, "Zelena");
			}
		});
		btnZelena.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnZelena = new GridBagConstraints();
		gbc_btnZelena.insets = new Insets(0, 0, 5, 5);
		gbc_btnZelena.gridx = 3;
		gbc_btnZelena.gridy = 5;
		panelCenter.add(btnZelena, gbc_btnZelena);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		JButton btnAntistres = new JButton("Anti-stres dugme");
		btnAntistres.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Opusti se i uzivaj! 😎");
			}
		});
		btnAntistres.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panelSouth.add(btnAntistres);
	}
	
	public void chooseBackgroundColor(int index) {
		switch(dlm.get(index)) {
		case "Crvena":
			panelCenter.setBackground(Color.RED);
			break;
		case "Plava":
			panelCenter.setBackground(Color.BLUE);
			break;
		case "Zelena":
			panelCenter.setBackground(Color.GREEN);
			break;
		default:
			return;
		}
	}

}
