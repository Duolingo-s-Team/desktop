package duolingo.main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import duolingo.panel.AdministrarCursos;
import implementations.UserImpl;
import interfaces.IUser;

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
					IUser userManager = new UserImpl();
					userManager.getAllUsers();
					MainFrame frame = new MainFrame();
					frame.pack();
					frame.setMinimumSize(new Dimension((int) (toolkit.getScreenSize().getWidth() / 1.5), (int) (toolkit.getScreenSize().getHeight() / 1.75 + 200)));
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
		setIconImage(new ImageIcon("src/resources/images/duolingo40.png").getImage());
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
		
		JLabel titleLabel = new JLabel();
		titleLabel.setFont(new Font("Ubuntu", Font.PLAIN, 24));
		titleLabel.setIcon(new ImageIcon("src/resources/images/duolingoLogo256.png"));
		titleLabel.setBorder(BorderFactory.createEmptyBorder(50, 25, 50, 25));
		titlePanel.add(titleLabel);
		
		JPanel selectionPanel = new JPanel();
		menuPanel.add(selectionPanel);
		
		ArrayList<JButton> buttons = new ArrayList<>();
		selectionPanel.setLayout(new GridLayout(2, 1, 0, 20));
		
		JButton cursos = new JButton("ADMINISTRAR CURSOS"); buttons.add(cursos);
		selectionPanel.add(cursos);
		
		cursos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setContentPane(new AdministrarCursos());
				repaint();
				revalidate();
			}
		});
				
		JButton otros = new JButton("OTROS (WIP)"); buttons.add(otros);
		selectionPanel.add(otros);
		
		for (JButton j : buttons) {
			j.setPreferredSize(new Dimension(150, 40));
			j.setBackground(Color.WHITE);
			j.setBorder(BorderFactory.createLineBorder(new Color(120, 200, 0), 2, true));
			j.setFont(new Font("Ubuntu", 0, 19));
			j.setForeground(new Color(75, 75, 75));
			j.setFocusPainted(false);
			
			j.addMouseListener(new MouseAdapter() {
	
				@Override
				public void mouseEntered(MouseEvent e) {
					j.setBorder(BorderFactory.createLineBorder(new Color(90, 150, 0), 2, true));
					j.setForeground(new Color(90, 150, 0));
					super.mouseEntered(e);
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					j.setBorder(BorderFactory.createLineBorder(new Color(120, 200, 0), 2, true));
					j.setForeground(new Color(75, 75, 75));
					super.mouseExited(e);
				}
			});
		}
	}

}
