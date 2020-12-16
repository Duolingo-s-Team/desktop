package duolingo.panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import implementations.ExerciseImpl;
import interfaces.IExercise;
import json.JsonDecode;
import models.Exercise;
import models.Level;

public class ScrollExercise extends JFrame {

	/**
	 * Create the frame.
	 */
	public ScrollExercise(Level level) {
		setTitle("Exercise list of level: " + level.getLevel_name());
		setSize(350, 400);
		setIconImage(Toolkit.getDefaultToolkit().getImage("src/resources/images/duolingo40.png"));
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		ArrayList<Exercise> exercises = (ArrayList<Exercise>) new ExerciseImpl().getExercisesByLevelId(level.getLevel_id());
		
		ArrayList<JButton> buttons = new ArrayList<>();
		
		JPanel container = new JPanel();
		
		JPanel buttonList = new JPanel(); buttonList.setLayout(new GridLayout(exercises.size(), 1, 0, 15));
		
		for (int i = 0; i < exercises.size(); i++) {
			buttons.add(new JButton(exercises.get(i).getExercise_name() + " - " + JsonDecode.JsonGetContent(exercises.get(i).getContent()).get("exerciseType")));
		}
		
		for (JButton j : buttons) {
			j.setPreferredSize(new Dimension(300, 40));
			j.setName(j.getText());
			j.setBackground(Color.WHITE);
			j.setFocusPainted(false);
			j.setFocusable(false);
			
			j.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					IExercise exerciseManager = new ExerciseImpl();
					
					JButton b = (JButton) e.getSource();
					
					Exercise selected = exerciseManager.getExerciseByName(b.getName().substring(0, b.getName().indexOf(" -")));
					
					// new ExercisePreviewFrame(selected); // <------------------------------------------------------------------------------------------------ SPEC 40
				}
			});
			
			
			buttonList.add(j);
		}
		
		container.add(buttonList);
		
		JScrollPane scrollPane = new JScrollPane(container, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);
							
		
		setContentPane(scrollPane);
		setVisible(true);
		
	}
	
	
}
