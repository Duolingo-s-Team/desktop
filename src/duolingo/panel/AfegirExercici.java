package duolingo.panel;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.LayoutStyle.ComponentPlacement;

public class AfegirExercici extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public AfegirExercici() {

		//new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.5));
		setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.75), (int) (this.getToolkit().getScreenSize().getHeight() / 1.75) + 100));

		JPanel Caracteristicas = new JPanel();
		
		JPanel Botones = new JPanel();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(Caracteristicas, GroupLayout.PREFERRED_SIZE, 256, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(Botones, GroupLayout.DEFAULT_SIZE, 583, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(Caracteristicas, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE)
						.addComponent(Botones, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 573, Short.MAX_VALUE))
					.addContainerGap())
		);
		Caracteristicas.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("max(127dlu;default):grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(111dlu;default):grow"),}));
		
		JLabel lblNewLabel = new JLabel("Curso:");
		Caracteristicas.add(lblNewLabel, "2, 4");
		
		JLabel cursolbl = new JLabel("TextoCurso");
		Caracteristicas.add(cursolbl, "4, 6");
		
		JLabel lblNewLabel_1 = new JLabel("Categor\u00EDas:");
		Caracteristicas.add(lblNewLabel_1, "2, 8");
		
		JLabel categoriaslbl = new JLabel("TextoCategor\u00EDa");
		Caracteristicas.add(categoriaslbl, "4, 10");
		
		JLabel lblNewLabel_2 = new JLabel("Nivel");
		Caracteristicas.add(lblNewLabel_2, "2, 12");
		
		JLabel nivellbl = new JLabel("TextoNivel");
		Caracteristicas.add(nivellbl, "4, 14");
		
		JLabel lblNewLabel_3 = new JLabel("Arbol de categor\u00EDas y niveles del curso");
		Caracteristicas.add(lblNewLabel_3, "4, 18");
		
		JTree tree = new JTree();
		Caracteristicas.add(tree, "4, 22, fill, fill");
		Botones.setLayout(new GridLayout(0, 2, 10, 10));
		
		JButton btnNewButton_1 = new JButton("New button");
		Botones.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		Botones.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		Botones.add(btnNewButton_4);
		
		JButton btnNewButton = new JButton("New button");
		Botones.add(btnNewButton);
		
		JButton btnNewButton_5 = new JButton("New button");
		Botones.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		Botones.add(btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("New button");
		Botones.add(btnNewButton_3);
		setLayout(groupLayout);
		
	}
}
