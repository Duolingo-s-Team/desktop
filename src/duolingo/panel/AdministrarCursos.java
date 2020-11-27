package duolingo.panel;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import duolingo.main.MainFrame;

public class AdministrarCursos extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdministrarCursos() {
		this.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.5)));

		
		JPanel mainVerticalPanel = new JPanel();
		mainVerticalPanel.setPreferredSize(MainFrame.toolkit.getScreenSize());
		add(mainVerticalPanel);
		mainVerticalPanel.setLayout(new BoxLayout(mainVerticalPanel, BoxLayout.X_AXIS));
		
		JPanel firstSection = new JPanel();
		mainVerticalPanel.add(firstSection);
		
		JPanel secondSection = new JPanel();
		mainVerticalPanel.add(secondSection);
		
		JPanel thirdSection = new JPanel();
		mainVerticalPanel.add(thirdSection);

	}

}
