package duolingo.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import duolingo.panel.AdministrarCursos;

import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static Toolkit toolkit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.pack();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setLocationRelativeTo(null);
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
	public MainFrame() {
		toolkit = getToolkit();
		setTitle("Duolingo");
		setIconImage(new ImageIcon("src/images/duolingo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.5)));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setContentPane(contentPane);
		
		JPanel menuPanel = new JPanel();
		contentPane.add(menuPanel);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
		JPanel titlePanel = new JPanel();
		menuPanel.add(titlePanel);
		
		JLabel titleLabel = new JLabel("DUOLINGO");
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		titlePanel.add(titleLabel);
		
		JPanel selectionPanel = new JPanel();
		menuPanel.add(selectionPanel);
		
		ArrayList<JButton> buttons = new ArrayList<>();
		selectionPanel.setLayout(new GridLayout(2, 1, 25, 15));
		
		JButton cursos = new JButton("Administrar Cursos"); buttons.add(cursos);
		selectionPanel.add(cursos);
		
		cursos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(new AdministrarCursos());
				repaint();
				revalidate();
			}
		});
		
		JButton otros = new JButton("Otros (WIP)"); buttons.add(otros);
		selectionPanel.add(otros);
		
		for (JButton j : buttons) {
			j.setPreferredSize(new Dimension(150, 30));
			j.setBackground(Color.WHITE);
			j.setFocusPainted(false);
			j.setFocusable(false);
		}
	}

}
