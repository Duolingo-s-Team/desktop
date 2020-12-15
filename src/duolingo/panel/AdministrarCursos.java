package duolingo.panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import duolingo.main.MainFrame;
import duolingo.util.implementation.LanguageListImpl;
import implementations.CategoryImpl;
import implementations.CourseImpl;
import implementations.LevelImpl;
import interfaces.ICategory;
import interfaces.ICourse;
import interfaces.ILevel;
import models.Category;
import models.Course;
import models.Level;

public class AdministrarCursos extends JPanel {
	
	private JList<String> courseList;
	private JList<String> categoryList;
	private JList<String> levelList;
	
	private ArrayList<String> filteredCourses = new ArrayList<>();
	private ArrayList<String> filteredCategories = new ArrayList<>();
	private ArrayList<String> filteredLevel = new ArrayList<>();
	
	ICourse courseManager = new CourseImpl();
	ICategory categoryManager = new CategoryImpl();
	ILevel levelManager = new LevelImpl();
	
	private String categorySelection;
	private String levelSelection;

	private Vector<String> languages = new LanguageListImpl().getLanguagesFromFile("src/resources/data/languages.txt");

	
	/**
	 * Create the panel.
	 */
	public AdministrarCursos(MainFrame jf) {
		setPreferredSize(new Dimension((int) (this.getToolkit().getScreenSize().getWidth() / 1.75), (int) (this.getToolkit().getScreenSize().getHeight() / 1.75) + 100));
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
		
		JComboBox<String> originLanguageCombo = new JComboBox<>(languages);
		originLabel.setLabelFor(originLanguageCombo);
		originLanguage.add(originLanguageCombo);
		
		JPanel destinationLanguage = new JPanel();
		contentFirstSection.add(destinationLanguage);
		destinationLanguage.setPreferredSize(new Dimension(200, 45));
		destinationLanguage.setLayout(new BoxLayout(destinationLanguage, BoxLayout.Y_AXIS));
		
		JLabel destinationLabel = new JLabel("Idioma de destino");
		destinationLabel.setAlignmentX(0.5f);
		destinationLabel.setHorizontalAlignment(SwingConstants.CENTER);
		destinationLanguage.add(destinationLabel);
		
		JComboBox<String> destinationLanguageCombo = new JComboBox<>(languages);
		destinationLabel.setLabelFor(destinationLanguageCombo);
		destinationLanguage.add(destinationLanguageCombo);
		
		JPanel buttonLanguageContainer = new JPanel();
		contentFirstSection.add(buttonLanguageContainer);
		buttonLanguageContainer.setLayout(new BoxLayout(buttonLanguageContainer, BoxLayout.Y_AXIS));
		
		ArrayList<JButton> buttonsFirstSection = new ArrayList<>();
		
		JPanel buttonLanguagePanel = new JPanel();
		buttonLanguageContainer.add(buttonLanguagePanel);
		buttonLanguagePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
		buttonLanguagePanel.setLayout(new GridLayout(2, 1, 0, 15));
		
		JButton createCourse = new JButton("Crear curso"); 
		createCourse.setEnabled(false);
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
		
		destinationLanguageCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createCourse.setEnabled(false);
			}
		});
		
		originLanguageCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				createCourse.setEnabled(false);
			}
		});
		
		applyFilter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 
				if (!((String) originLanguageCombo.getSelectedItem()).equals(((String) destinationLanguageCombo.getSelectedItem()))) {
					
					String origin_language = ((String) originLanguageCombo.getSelectedItem()).substring(0, ((String) originLanguageCombo.getSelectedItem()).lastIndexOf(" "));
					String destination_language = ((String) destinationLanguageCombo.getSelectedItem()).substring(0, ((String) destinationLanguageCombo.getSelectedItem()).lastIndexOf(" "));
					
					Course course = courseManager.getCourseByLanguage(origin_language, destination_language);
					
					if (course == null) {
						createCourse.setEnabled(true);
					} else {
						if (!filteredCourses.contains(course.getCourse_lang_from() + " - " + course.getCourse_lang_to())) {
							filteredCourses.clear();
							filteredCourses.add(course.getCourse_lang_from() + " - " + course.getCourse_lang_to());
						}
						
						updateJList(courseList, filteredCourses);
					}
					
				}
			}
		});
		
		createCourse.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				courseManager.insertCourse(new Course(((String) originLanguageCombo.getSelectedItem()).substring(0, ((String) originLanguageCombo.getSelectedItem()).lastIndexOf(" "))
						, ((String) destinationLanguageCombo.getSelectedItem()).substring(0, ((String) destinationLanguageCombo.getSelectedItem()).lastIndexOf(" "))));
				
				filteredCourses.add(((String) originLanguageCombo.getSelectedItem()).substring(0, ((String) originLanguageCombo.getSelectedItem()).lastIndexOf(" "))
						+ " - " +((String) destinationLanguageCombo.getSelectedItem()).substring(0, ((String) destinationLanguageCombo.getSelectedItem()).lastIndexOf(" ")));
				
				updateJList(courseList, filteredCourses);
				
				createCourse.setEnabled(false);
			}
		});
		

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
		
		courseList = new JList<>(); listsSecondSection.add(courseList);
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
		
		categoryList = new JList<>(); listsSecondSection.add(categoryList);
		categoryList.setVisibleRowCount(12);
		categoryList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		categoryListPanel.add(categoryList);
		
		JButton addCategoryButton = new JButton("Agregar Categoria");
		addCategoryButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addCategoryButton.setEnabled(false);
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
		
		levelList = new JList<>(); listsSecondSection.add(levelList);
		levelList.setVisibleRowCount(12);
		levelList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		levelListPanel.add(levelList);
		
		JButton addLevelButton = new JButton("Agregar Nivel");
		addLevelButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addLevelButton.setEnabled(false);
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
				
                categorySelection = courseList.getSelectedValue();
                
                if (categorySelection != null) {
                	filteredCategories = getCategoryNamesByCourseId(courseManager.getCourseByLanguage(categorySelection.substring(0, categorySelection.indexOf(" ")), categorySelection.substring(categorySelection.lastIndexOf(" ") + 1, categorySelection.length())).getCourse_id());
                     updateJList(categoryList, filteredCategories);
                     
                     addCategoryButton.setEnabled(true);
				}
                
            }
        });
		
		categoryList.addListSelectionListener(new ListSelectionListener() {
			
			
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				
				categorySelection = categoryList.getSelectedValue();
				
				if (categorySelection != null) {
					
					Category selectedCategory = categoryManager.getCategoryByName(categoryList.getSelectedValue().toString());
					filteredLevel = getLevelNamesByCategoryId(selectedCategory.getCategory_id());
					
					updateJList(levelList, filteredLevel);
					addLevelButton.setEnabled(true);
				}
			}
		});
		
		addCategoryButton.addActionListener(new ActionListener() {
			
			Course course;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ICourse courseManager = new CourseImpl();
				ICategory categoryManager = new CategoryImpl();
				course = courseManager.getCourseByLanguage(courseList.getSelectedValue().substring(0, courseList.getSelectedValue().indexOf(" "))
						, courseList.getSelectedValue().substring(courseList.getSelectedValue().lastIndexOf(" ") + 1, courseList.getSelectedValue().length()));
				categoryManager.insertCategory(new Category(JOptionPane.showInputDialog(AdministrarCursos.this, "Inserte una nueva categoria:", "Categorias", JOptionPane.DEFAULT_OPTION), course));
				
				filteredCategories = getCategoryNamesByCourseId(course.getCourse_id());
				
				updateJList(categoryList, filteredCategories);
			}
		});
		
		addLevelButton.addActionListener(new ActionListener() {
			
			Category category;
			@Override
			public void actionPerformed(ActionEvent e) {
				
				category = categoryManager.getCategoryByName(categoryList.getSelectedValue());
				levelManager.insertLevel(new Level(JOptionPane.showInputDialog(AdministrarCursos.this, "Inserte un nuevo nivel:", "Nivel", JOptionPane.DEFAULT_OPTION), category));
				filteredLevel = getLevelNamesByCategoryId(category.getCategory_id());
				
				updateJList(levelList, filteredLevel);
			}
		});
		
		levelList.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent arg0) {
				addLevelButton.setEnabled(false);				
			}
			
			@Override
			public void focusGained(FocusEvent arg0) {
				// TODO Auto-generated method stub
				
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
		
		addQuestion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {				
				
				levelSelection = levelList.getSelectedValue();
				
				if (levelSelection != null) {
					String[] labels = new String[3];
					labels[0] = courseList.getSelectedValue();
					labels[1] = categoryList.getSelectedValue();
					labels[2] = levelList.getSelectedValue();
					jf.CambiarPanel(new AfegirExercici(labels));
				}
			}
		});

	}
	
	// Methods
	
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
	
	public static ArrayList<String> getCategoryNamesByCourseId(long course_id) {
		ICategory categoryManager = new CategoryImpl();
		List<Category> categories = categoryManager.getCategoriesByCourseId(course_id);
		ArrayList<String> categoryNames = new ArrayList<>();
		
		for (Category c : categories) {
			categoryNames.add(c.getCategory_name());
		}
		
		return categoryNames;
	}
	
	public static String[] getCategoryName() {
	ICategory categoryManager = new CategoryImpl();
	List<Category> categories = categoryManager.getAllCategories();
	String[] categoryNames = new String[categories.size()];
	
	for (int i = 0; i < categoryNames.length; i++) {
		categoryNames[i] = categories.get(i).getCategory_name();
	}
	
	return categoryNames;
}
	
	public static ArrayList<String> getLevelNamesByCategoryId(long category_id) {
		ILevel levelManager = new LevelImpl();
		List<Level> levels = levelManager.getLevelsByCategoryId(category_id);
		ArrayList<String> levelNames = new ArrayList<>();
		
		for (Level l : levels) {
			levelNames.add(l.getLevel_name());
		}
		
		return levelNames;
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
//	
	

}
