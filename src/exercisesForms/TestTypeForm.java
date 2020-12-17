package exercisesForms;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.hibernate.engine.spi.ExecutableList;
import org.json.simple.JSONObject;

import implementations.ExerciseImpl;
import implementations.LevelImpl;
import implementations.UserImpl;
import interfaces.IExercise;
import interfaces.ILevel;
import interfaces.IUser;
import json.JsonDecode;
import json.JsonEncode;
import models.Exercise;
import models.Level;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import exercisesTemplates.TestTypeTemplate;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class TestTypeForm extends JFrame {

	private JPanel contentPane;
	private JTextField questionField;
	private JLabel correctLabel;
	private JTextField correctField;
	private JLabel incorrect1Label;
	private JTextField incorrect1Field;
	private JLabel incorrect2Label;
	private JTextField incorrect2Field;
	private JButton saveExerciseButton;

	public TestTypeForm(String levelName) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.75 + 200)));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.75 + 200)));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),},
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
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel questionLabel = new JLabel("Frase a traduir:");
		contentPane.add(questionLabel, "14, 8");
		
		questionField = new JTextField();
		contentPane.add(questionField, "18, 8, fill, default");
		questionField.setColumns(11);
		
		correctLabel = new JLabel("Frase traduïda correcta:");
		contentPane.add(correctLabel, "14, 12");
		
		correctField = new JTextField();
		contentPane.add(correctField, "18, 12, fill, default");
		correctField.setColumns(10);
		
		incorrect1Label = new JLabel("Frase incorrecta 1:");
		contentPane.add(incorrect1Label, "14, 16");
		
		incorrect1Field = new JTextField();
		contentPane.add(incorrect1Field, "18, 16, fill, default");
		incorrect1Field.setColumns(10);
		
		incorrect2Label = new JLabel("Frase incorrecta 2:");
		contentPane.add(incorrect2Label, "14, 20");
		
		incorrect2Field = new JTextField();
		contentPane.add(incorrect2Field, "18, 20, fill, default");
		incorrect2Field.setColumns(10);
		
		saveExerciseButton = new JButton("Guardar exercici");
		contentPane.add(saveExerciseButton, "18, 24");
		
		saveExerciseButton.addActionListener(new ActionListener() {
			
			Level level;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ILevel levelManager = new LevelImpl();
				IExercise exerciseManager = new ExerciseImpl();
				
				level = levelManager.getLevelByName(levelName);
				
				if (!questionField.equals("") || !correctField.equals("") || !incorrect1Field.equals("") || !incorrect2Field.equals("")) {
					String content = JsonEncode.jsonContentInsertTest("TIPUS_TEST", 25, 10, questionField.getText(), 
							correctField.getText(), incorrect1Field.getText()+";"+incorrect2Field.getText());
					
					exerciseManager.insertExercise(new Exercise("TEST_EX", content, level));
					
					setVisible(false);
				}
				
			}
		});
		
		
		
	}

}
