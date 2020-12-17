package exercisesTemplates;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import json.JsonDecode;
import models.Exercise;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class OpenTraductTemplate extends JFrame {

	private JPanel contentPane;
	private JTextField response;
	public OpenTraductTemplate(Exercise exercise) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth()), (int) (this.getToolkit().getScreenSize().getHeight())));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth()), (int) (this.getToolkit().getScreenSize().getHeight())));
		contentPane.setBorder(new EmptyBorder(25, 25, 25, 25));
		setContentPane(contentPane);
		
		JLabel sentence = new JLabel("");
		sentence.setFont(new Font("Arial", Font.PLAIN, 14));
		
		response = new JTextField();
		response.setFont(new Font("Arial", Font.PLAIN, 14));
		response.setColumns(10);
		
		JLabel correct = new JLabel("New label");
		correct.setFont(new Font("Arial", Font.PLAIN, 14));
		correct.setText("Result =");
		
		JButton comprovaBtn = new JButton("COMPROVA");
		comprovaBtn.setFont(new Font("Arial", Font.PLAIN, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(238)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(correct, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE)
								.addComponent(sentence, GroupLayout.PREFERRED_SIZE, 401, GroupLayout.PREFERRED_SIZE)
								.addComponent(response, GroupLayout.PREFERRED_SIZE, 615, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(490)
							.addComponent(comprovaBtn, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(619, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(88)
					.addComponent(sentence, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(59)
					.addComponent(response, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addComponent(comprovaBtn, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addComponent(correct, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(376, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
		
		JSONObject jsoncontent = JsonDecode.JsonGetContent(exercise.getContent());
		JSONArray jsonarray = (JSONArray) jsoncontent.get("traductedSentences");
		
		sentence.setText("FRASE A TRADUIR: "+jsoncontent.get("sentenceToTranslate").toString());
		
		comprovaBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (!response.getText().equals("")) {
					for (int i = 0; i < jsonarray.size(); i++) {
						if (fixInput(jsonarray.get(i).toString()).equals(fixInput(response.getText()))) {
							correct.setText("Result = CORRECT");
							break;
						} else {
							correct.setText("Result = FAILED");
						}
					}
				}
			}
		});
		
		
		setVisible(true);
	}
	
	public static String fixInput(String answer) {
	    return answer.replaceAll(".*([.:,;!\"·$%&/()=?¿¡]+).*", "").replaceAll("[\\s]+", " ").toLowerCase();
	}
}
