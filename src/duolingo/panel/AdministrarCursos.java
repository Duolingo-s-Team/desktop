package duolingo.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import duolingo.util.languageList;

public class AdministrarCursos extends JPanel {

	/**
	 * Create the panel.
	 */
	public AdministrarCursos() {
		this.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.75), (int) (this.getToolkit().getScreenSize().getHeight() / 1.75)));
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
		
		// ===== PANEL PRINCIPAL =====
		JPanel mainVerticalPanel = new JPanel();
		mainVerticalPanel.setPreferredSize(this.getPreferredSize());
		mainVerticalPanel.setBorder(BorderFactory.createEmptyBorder(30, 0, 0, 0));
		mainVerticalPanel.setLayout(new BoxLayout(mainVerticalPanel, BoxLayout.Y_AXIS));
		add(mainVerticalPanel);
		
		
		// ===== PRIMERA SECCION =====
		
		JPanel firstSection = new JPanel();
		mainVerticalPanel.add(firstSection);
		firstSection.setLayout(new BoxLayout(firstSection, BoxLayout.Y_AXIS));
		
		JPanel titleFirstSectionPanel = new JPanel();
		firstSection.add(titleFirstSectionPanel);
		titleFirstSectionPanel.setPreferredSize(new Dimension(this.getWidth(), 20));
		titleFirstSectionPanel.setLayout(new BoxLayout(titleFirstSectionPanel, BoxLayout.X_AXIS));
		
		JLabel titleFirstSection = new JLabel("Cursos existentes (filtrar por origen y/o destino)");
		titleFirstSectionPanel.add(titleFirstSection);
		titleFirstSection.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel contentFirstSection = new JPanel();
		contentFirstSection.setBorder(BorderFactory.createDashedBorder(Color.DARK_GRAY, 1f, 1f, 1f, true));
		firstSection.add(contentFirstSection);
		contentFirstSection.setLayout(new FlowLayout(FlowLayout.CENTER, 75, 25));
		
		JPanel originLanguage = new JPanel();
		contentFirstSection.add(originLanguage);
		originLanguage.setPreferredSize(new Dimension(200, 45));
		originLanguage.setLayout(new BoxLayout(originLanguage, BoxLayout.Y_AXIS));
		
		JLabel originLabel = new JLabel("Idioma de origen");
		originLabel.setAlignmentX(0.5f);
		originLabel.setPreferredSize(new Dimension(originLanguage.getWidth(), 15));
		originLabel.setHorizontalAlignment(SwingConstants.CENTER);
		originLanguage.add(originLabel);
		
		JComboBox<String> comboBox = new JComboBox<>(languageList.getLanguagesFromFile("src/resources/data/languages.txt"));
		originLabel.setLabelFor(comboBox);
		originLanguage.add(comboBox);
		
		JPanel destinationLanguage = new JPanel();
		contentFirstSection.add(destinationLanguage);
		destinationLanguage.setPreferredSize(new Dimension(200, 45));
		destinationLanguage.setLayout(new BoxLayout(destinationLanguage, BoxLayout.Y_AXIS));
		
		JLabel destinationLabel = new JLabel("Idioma de destino");
		destinationLabel.setAlignmentX(0.5f);
		destinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		destinationLanguage.add(destinationLabel);
		
		JComboBox<String> comboBox_1 = new JComboBox<>(languageList.getLanguagesFromFile("src/resources/data/languages.txt"));
		destinationLabel.setLabelFor(comboBox_1);
		destinationLanguage.add(comboBox_1);
		
		JPanel buttonLanguageContainer = new JPanel();
		contentFirstSection.add(buttonLanguageContainer);
		buttonLanguageContainer.setLayout(new BoxLayout(buttonLanguageContainer, BoxLayout.Y_AXIS));
		
		ArrayList<JButton> buttonsFirstSection = new ArrayList<>();
		
		JPanel buttonLanguagePanel = new JPanel();
		buttonLanguageContainer.add(buttonLanguagePanel);
		buttonLanguagePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonLanguagePanel.setLayout(new GridLayout(2, 1, 0, 15));
		
		JButton createCourse = new JButton("Crear curso"); 
		buttonLanguagePanel.add(createCourse);
		buttonsFirstSection.add(createCourse);
		
		JButton applyFilter = new JButton("Aplicar filtro"); 
		buttonLanguagePanel.add(applyFilter);
		buttonsFirstSection.add(applyFilter);
		
		for (JButton j : buttonsFirstSection) {
			j.setPreferredSize(new Dimension(250, 30));
			j.setBackground(Color.WHITE);
			j.setFocusPainted(false);
			j.setFocusable(false);
		}
		
		// ===== SEGUNDA SECCION =====
		
		JPanel secondSection = new JPanel();
		mainVerticalPanel.add(secondSection);
		secondSection.setBorder(new EmptyBorder(50, 0, 50, 0));
		secondSection.setLayout(new GridLayout(1, 3, 50, 0));
		
		JPanel coursesSecondSection = new JPanel();
		secondSection.add(coursesSecondSection);
		coursesSecondSection.setBorder(new EmptyBorder(10, 50, 0, 50));
		coursesSecondSection.setLayout(new BoxLayout(coursesSecondSection, BoxLayout.Y_AXIS));
		
		JLabel titleCourses = new JLabel("Cursos");
		titleCourses.setAlignmentX(Component.CENTER_ALIGNMENT);
		coursesSecondSection.add(titleCourses);
		
		ArrayList<JList<String>> listsSecondSection = new ArrayList<>();
		
		JPanel courseListPanel = new JPanel();
		coursesSecondSection.add(courseListPanel);
		courseListPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		courseListPanel.setPreferredSize(new Dimension(400, 225));
		courseListPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JList<String> courseList = new JList<>(); listsSecondSection.add(courseList);
		courseList.setVisibleRowCount(12);
		courseList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		courseListPanel.add(courseList);
		
		JPanel categoriesSecondSection = new JPanel();
		secondSection.add(categoriesSecondSection);
		categoriesSecondSection.setBorder(new EmptyBorder(10, 50, 0, 50));
		categoriesSecondSection.setLayout(new BoxLayout(categoriesSecondSection, BoxLayout.Y_AXIS));
		
		JLabel titleCategories = new JLabel("Categorias del curso seleccionado");
		titleCategories.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoriesSecondSection.add(titleCategories);
		
		JPanel categoryListPanel = new JPanel();
		categoryListPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		categoriesSecondSection.add(categoryListPanel);
		categoryListPanel.setPreferredSize(new Dimension(400, 225));
		categoryListPanel.setLayout(new GridLayout(1, 1, 0, 15));
		
		JList<String> categoryList = new JList<>(); listsSecondSection.add(categoryList);
		categoryList.setVisibleRowCount(12);
		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryListPanel.add(categoryList);
		
		JButton addCategoryButton = new JButton("Agregar Categoria");
		addCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		categoriesSecondSection.add(addCategoryButton);
		
		JPanel levelsSecondSection = new JPanel();
		secondSection.add(levelsSecondSection);
		levelsSecondSection.setBorder(new EmptyBorder(10, 50, 0, 50));
		levelsSecondSection.setLayout(new BoxLayout(levelsSecondSection, BoxLayout.Y_AXIS));
		
		JLabel titleLevels = new JLabel("Niveles de la categoria seleccionada");
		titleLevels.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelsSecondSection.add(titleLevels);
		
		JPanel levelListPanel = new JPanel();
		levelListPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
		levelsSecondSection.add(levelListPanel);
		levelListPanel.setPreferredSize(new Dimension(400, 225));
		levelListPanel.setLayout(new GridLayout(1, 1, 0, 0));
		
		JList<String> levelList = new JList<>(); listsSecondSection.add(levelList);
		levelList.setVisibleRowCount(12);
		levelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		levelListPanel.add(levelList);
		
		JButton addLevelButton = new JButton("Agregar Nivel");
		addLevelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		levelsSecondSection.add(addLevelButton);
		
		ArrayList<JButton> buttonsSecondSection = new ArrayList<>();
		buttonsSecondSection.add(addCategoryButton);
		buttonsSecondSection.add(addLevelButton);
		
		for (JList<String> j : listsSecondSection) {
			j.setPreferredSize(new Dimension(80, 100));
			j.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));
			j.setDragEnabled(false);
		}
		
		for (JButton j : buttonsSecondSection) {
			j.setBackground(Color.WHITE);
			j.setFocusPainted(false);
			j.setFocusable(false);
		}
		
		courseList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// PENDIENTE (Spec 19: Seleccionar una curso de la JList)
				
			}
		});
		
		categoryList.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// Sprint 3? (Seleccionar una categoria de la JList)
				
			}
		});
		
		addCategoryButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// PENDIENTE (Spec 20: Pulsar el boton de "Agregar categoria")
				
			}
		});
		
		
		// ===== TERCERA SECCION =====
		
		JPanel thirdSection = new JPanel();
		mainVerticalPanel.add(thirdSection);
		
		JPanel buttonsThirdSectionContainer = new JPanel();
		buttonsThirdSectionContainer.setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.75), 80));
		buttonsThirdSectionContainer.setLayout(new BoxLayout(buttonsThirdSectionContainer, BoxLayout.X_AXIS));
		thirdSection.add(buttonsThirdSectionContainer);
		
		ArrayList<JButton> buttonsThirdSection = new ArrayList<>();
		thirdSection.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		JPanel buttonsThirdSectionPanel = new JPanel();
		buttonsThirdSectionContainer.add(buttonsThirdSectionPanel);
		buttonsThirdSectionPanel.setLayout(new GridLayout(2, 1, 0, 15));
		
		JButton addQuestion = new JButton("Agregar pregunta"); buttonsThirdSection.add(addQuestion);
		buttonsThirdSectionPanel.add(addQuestion);
		
		JButton viewQuestions = new JButton("Visualizar pregunta"); buttonsThirdSection.add(viewQuestions);
		buttonsThirdSectionPanel.add(viewQuestions);
		
		for (JButton j : buttonsThirdSection) {
			j.setBackground(Color.WHITE);
			j.setFocusPainted(false);
			j.setFocusable(false);
		}

	}
	
	// -----------------------> TESTEO <--------------------------- \\
	
//	public static String[] getCourseNames() {
//		ICourse courseManager = new CourseImpl();
//		List<Course> courses = courseManager.getAllCourses();
//		String[] courseNames = new String[courses.size()];
//		
//		for (int i = 0; i < courseNames.length; i++) {
//			courseNames[i] = courses.get(i).getCourse_lang_from() + "-" + courses.get(i).getCourse_lang_to();
//		}
//		
//		return courseNames;
//	}
//	
//	public static String[] getCategoryNamesByCourseId(long course_id) {
//		ICategory categoryManager = new CategoryImpl();
//		List<Category> categories = categoryManager.getCategoriesByCourseId(course_id);
//		String[] categoryNames = new String[categories.size()];
//		
//		for (int i = 0; i < categoryNames.length; i++) {
//			categoryNames[i] = categories.get(i).getCategory_name();
//		}
//		
//		return categoryNames;
//	}
//	
//	public static String[] getLevelNamesByCategoryId(long category_id) {
//		ILevel levelManager = new LevelImpl();
//		List<Level> levels = levelManager.getLevelsByCategoryId(category_id);
//		String[] levelNames = new String[levels.size()];
//		
//		for (int i = 0; i < levelNames.length; i++) {
//			levelNames[i] = levels.get(i).getLevel_name();
//		}
//		
//		return levelNames;
//	}

}
