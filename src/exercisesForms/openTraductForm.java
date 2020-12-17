package exercisesForms;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import exercisesTemplates.OpenTraductTemplate;
import implementations.ExerciseImpl;
import implementations.LevelImpl;
import interfaces.IExercise;
import interfaces.ILevel;
import json.JsonEncode;
import models.Exercise;
import models.Level;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.management.openmbean.OpenDataException;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JList;

public class openTraductForm extends JFrame {

	private JPanel contentPane;
	private ArrayList<JList<String>> listThirdPanel = new ArrayList<>();
	private ArrayList<String> sentencesArray = new ArrayList<>();
	String[] sentences;
	/**
	 * Create the frame.
	 */
	public openTraductForm(String levelName) {
		setSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.5)));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() ), (int) (this.getToolkit().getScreenSize().getHeight())));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth()), (int) (this.getToolkit().getScreenSize().getHeight())));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		
		// Primer panel
		JPanel firstPanel = new JPanel();
		contentPane.add(firstPanel);
		firstPanel.setPreferredSize(new Dimension(this.getWidth(), (int) (this.getToolkit().getScreenSize().getHeight() / 3.5)));
		
		JLabel phraseToTraduct = new JLabel("Frase a traducir: ");
		phraseToTraduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JTextArea sentence = new JTextArea();
		sentence.setColumns(80);
		GroupLayout gl_firstPanel = new GroupLayout(firstPanel);
		gl_firstPanel.setHorizontalGroup(
			gl_firstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addGap(65)
					.addComponent(phraseToTraduct)
					.addGap(35)
					.addComponent(sentence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(510, Short.MAX_VALUE))
		);
		gl_firstPanel.setVerticalGroup(
			gl_firstPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_firstPanel.createSequentialGroup()
					.addContainerGap(156, Short.MAX_VALUE)
					.addGroup(gl_firstPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(phraseToTraduct)
						.addComponent(sentence, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(57))
		);
		firstPanel.setLayout(gl_firstPanel);
		
		// Segundo Panel
		JPanel secondPanel = new JPanel();
		contentPane.add(secondPanel);
		secondPanel.setPreferredSize(new Dimension((int)(this.getWidth()/1.6)+72,(int) (this.getToolkit().getScreenSize().getHeight() / 3.5)));
		secondPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 50, 50));
		
		JLabel correctOptionLbl = new JLabel("Opcion correcta: ");
		correctOptionLbl.setFont(new Font("Tahoma", Font.PLAIN, 16));
		secondPanel.add(correctOptionLbl);
		
		JTextArea translateSentence = new JTextArea();
		translateSentence.setColumns(80);
		secondPanel.add(translateSentence);
		
		JButton addSentence = new JButton("Añadir frase");
		addSentence.setFont(new Font("Tahoma", Font.PLAIN, 16));
		secondPanel.add(addSentence);
		
		JButton saveInDatabase = new JButton("Guardar");
		saveInDatabase.setFont(new Font("Tahoma", Font.PLAIN, 16));
		secondPanel.add(saveInDatabase);
		
		// Tercer panel
		JPanel thirdPanel = new JPanel();
		contentPane.add(thirdPanel);
		thirdPanel.setPreferredSize(new Dimension( (int)(this.getWidth()/3.5), (int) (this.getToolkit().getScreenSize().getHeight() / 1.75)));
		thirdPanel.setLayout(new FlowLayout(FlowLayout.CENTER, FlowLayout.CENTER, 100));
		
		JButton deleteSentence = new JButton("Eliminar frase");
		deleteSentence.setFont(new Font("Tahoma", Font.PLAIN, 16));
		thirdPanel.add(deleteSentence);
		
		JList<String> correctOptionsList = new JList<>(); listThirdPanel.add(correctOptionsList);
		correctOptionsList.setVisibleRowCount(12);
		correctOptionsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		thirdPanel.add(correctOptionsList);
		
		for (JList<String> j : listThirdPanel) {
			j.setPreferredSize(new Dimension((int)(this.getWidth()/4), 300));
			j.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
			j.setDragEnabled(false);
		}
		
		// Funciones de Boton yJList
		addSentence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (!translateSentence.getText().equals("")) {
					sentencesArray.add(translateSentence.getText());
					updateJList(correctOptionsList, sentencesArray);
					translateSentence.setText("");
				}
				
			}
		});
		
		saveInDatabase.addActionListener(new ActionListener() {
			
			Level level;
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				ILevel levelManager = new LevelImpl();
				IExercise exerciseManager = new ExerciseImpl();
				
				level = levelManager.getLevelByName(levelName);
				
				if (!translateSentence.equals("") && sentencesArray.size() > 0) {
					String content = ""; //JsonEncode.jsonContentInsertOpenTraduct("TRADUCCIO_OBERTA", 25, 10, sentence.getText(), llenarFrases(sentencesArray));
					
					exerciseManager.insertExercise(new Exercise("TRADUCCIO_OBERTA", content, level));
					
					setVisible(false);
				}
			}
		});
		
		deleteSentence.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (correctOptionsList.getSelectedValue() != null){
					sentencesArray.remove(correctOptionsList.getSelectedIndex());
					updateJList(correctOptionsList, sentencesArray);
				}
			}
		});
		
	}
	
	public static void updateJList(JList<String> list, ArrayList<String> data) {
		list.setModel(new AbstractListModel<String>() {

			@Override
			public int getSize() {
				return data.size();
			}

			@Override
			public String getElementAt(int index) {
				return data.get(index);
			}
			
		});
	}
	
	public static String[] llenarFrases(ArrayList<String> sentencesArray) {
		
		String[] frasesStrings = new String[sentencesArray.size()];
		
		for (int i = 0; i < sentencesArray.size(); i++) {
			frasesStrings[i] = sentencesArray.get(i);
		}
		
		return frasesStrings;
	}

}
