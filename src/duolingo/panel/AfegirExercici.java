package duolingo.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import exercisesForms.TestTypeForm;
import exercisesForms.openTraductForm;
import implementations.ExerciseImpl;
import implementations.LevelImpl;
import interfaces.IExercise;
import interfaces.ILevel;

public class AfegirExercici extends JPanel {

	ILevel levelManager = new LevelImpl();
	IExercise exerciseManager = new ExerciseImpl();
	
	public AfegirExercici(String[] labels) {

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
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Caracteristicas.add(lblNewLabel, "2, 4");
		
		JLabel cursolbl = new JLabel(labels[0]);
		cursolbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Caracteristicas.add(cursolbl, "4, 6");
		
		JLabel lblNewLabel_1 = new JLabel("Categorias:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Caracteristicas.add(lblNewLabel_1, "2, 8");
		
		JLabel categoriaslbl = new JLabel(labels[1]);
		categoriaslbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Caracteristicas.add(categoriaslbl, "4, 10");
		
		JLabel lblNewLabel_2 = new JLabel("Nivel");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Caracteristicas.add(lblNewLabel_2, "2, 12");
		
		JLabel nivellbl = new JLabel(labels[2]);
		nivellbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Caracteristicas.add(nivellbl, "4, 14");
		
		JLabel lblNewLabel_3 = new JLabel("Arbol de categorias y niveles del curso");
		Caracteristicas.add(lblNewLabel_3, "2, 18, 3, 1");
		
		JTree tree = new JTree();
		Caracteristicas.add(tree, "2, 22, 3, 1, fill, fill");
		Botones.setLayout(new GridLayout(4, 2, 10, 10));
		
		ArrayList<JButton> buttons = new ArrayList<>();
		
		JButton tipusTest = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/TIPUS_TEST.png")));
		buttons.add(tipusTest);
		
		tipusTest.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				TestTypeForm ttf = new TestTypeForm(labels[2]);
				ttf.setVisible(true);
			}
		});
		
		JButton traduccioOberta = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/TRADUCCIO_OBERTA.png")));
		buttons.add(traduccioOberta);
		
		traduccioOberta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				openTraductForm otf = new openTraductForm(labels[2]);
				otf.setVisible(true);
			}
		});
		
		JButton listeningObert = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/LISTENING_OBERT.png")));
		buttons.add(listeningObert);
		
		JButton traduccioReordena = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/TRADUCCIO_REORDENA_PARAULES.png")));
		buttons.add(traduccioReordena);
		
		JButton listeningReordena = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/LISTENING_REORDENA.png")));
		buttons.add(listeningReordena);
		
		JButton ompleParaula = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/OMPLE_UNA_PARAULA.png")));
		buttons.add(ompleParaula);
		
		JButton aparellaParaula = new JButton(new ImageIcon(this.getToolkit().getImage("src/resources/images/TRADUCCIO_REORDENA_PARAULES.png")));
		buttons.add(aparellaParaula);
		
		
		for (JButton j : buttons) {
			j.setFocusable(false);
			j.setOpaque(true);
			j.setBackground(Color.WHITE);
			Botones.add(j);
		}
		
		setLayout(groupLayout);
		
	}
}
