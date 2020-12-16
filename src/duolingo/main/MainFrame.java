package duolingo.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import duolingo.panel.AdministrarCursos;
import implementations.UserImpl;
import interfaces.IUser;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	public static Toolkit toolkit;
	
	public static JMenuBar menuBar;
	public static JMenu mainMenu;
	

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
		MainFrame mf=this;
		toolkit = getToolkit();
		setTitle("Duolingo");
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/resources/images/duolingo40.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.5)));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLabel mainIcon = new JLabel("");
		mainIcon.setHorizontalAlignment(SwingConstants.CENTER);
		mainIcon.setIcon(new ImageIcon("src/resources/images/duolingoLogo256.png"));
		contentPane.add(mainIcon, BorderLayout.CENTER);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenuItem administrarCursos = new JMenuItem("Administrar Cursos"); 

		administrarCursos.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CambiarPanel(new AdministrarCursos(mf));
			}
			
		});
		
		mainMenu = new JMenu("Duolingo");
		mainMenu.add(administrarCursos);
		
		menuBar.add(mainMenu);
	}
	
	public void CambiarPanel(JPanel panel) {
		setContentPane(panel);
		repaint();
		revalidate();
		
	}

}
