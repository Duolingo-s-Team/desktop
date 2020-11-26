package frame;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AdministrarCursos extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdministrarCursos() {
		
		JPanel mainVerticalPanel = new JPanel();
		mainVerticalPanel.setPreferredSize(MainFrame.toolkit.getScreenSize());
		add(mainVerticalPanel);
		mainVerticalPanel.setLayout(new BoxLayout(mainVerticalPanel, BoxLayout.X_AXIS));

	}

}
