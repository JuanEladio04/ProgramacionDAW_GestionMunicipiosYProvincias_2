package jepm.es.proyect.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

import jepm.es.proyect.controller.EstudianteController;
import jepm.es.proyect.controller.MateriaController;
import jepm.es.proyect.controller.ProfesorController;
import jepm.es.proyect.controller.ValoracionMateriaController;
import jepm.es.proyect.model.Estudiante;
import jepm.es.proyect.model.Materia;
import jepm.es.proyect.model.Profesor;
import jepm.es.proyect.model.Valoracionmateria;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JComboBox jcb_MateriaChooser;
	private JComboBox jcb_ProfessorChooser;
	private JComboBox jcb_ValorationChooser;
	private JList jl_AllStudents;
	private JList jl_SelectedStudents;
	private DefaultListModel<Estudiante> jlm_AllStudents = new DefaultListModel<Estudiante>();
	private DefaultListModel<Estudiante> jlm_SelectedStudents = new DefaultListModel<Estudiante>(); 
	private List<Estudiante> allStudentsList = EstudianteController.getController().findAll();
	private List<Estudiante> selectedStudents = new ArrayList<>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setTitle("Gestion de estudiantes por listas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Materia:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		jcb_MateriaChooser = new JComboBox();
		GridBagConstraints gbc_jcb_materiaChooser = new GridBagConstraints();
		gbc_jcb_materiaChooser.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_materiaChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_materiaChooser.gridx = 1;
		gbc_jcb_materiaChooser.gridy = 0;
		panel.add(jcb_MateriaChooser, gbc_jcb_materiaChooser);
		addValuesToMateriaCombo();
		
		JLabel lblNewLabel_1 = new JLabel("Profesor:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		
		jcb_ProfessorChooser = new JComboBox();
		GridBagConstraints gbc_jcb_ProfessorChooser = new GridBagConstraints();
		gbc_jcb_ProfessorChooser.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_ProfessorChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_ProfessorChooser.gridx = 1;
		gbc_jcb_ProfessorChooser.gridy = 1;
		panel.add(jcb_ProfessorChooser, gbc_jcb_ProfessorChooser);
		addValuesToProfesorCombo();
		
		JLabel lblNewLabel_2 = new JLabel("Nota:");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		jcb_ValorationChooser = new JComboBox();
		GridBagConstraints gbc_jcb_ValorationChooser = new GridBagConstraints();
		gbc_jcb_ValorationChooser.insets = new Insets(0, 0, 5, 0);
		gbc_jcb_ValorationChooser.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcb_ValorationChooser.gridx = 1;
		gbc_jcb_ValorationChooser.gridy = 2;
		panel.add(jcb_ValorationChooser, gbc_jcb_ValorationChooser);
		addValuesToValorationCombo();
		
		JButton updateStudentMenu = new JButton("Botón actualizar alumnado");
		updateStudentMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValuesToLists();
			}
		});
		GridBagConstraints gbc_updateStudentMenu = new GridBagConstraints();
		gbc_updateStudentMenu.anchor = GridBagConstraints.EAST;
		gbc_updateStudentMenu.gridx = 1;
		gbc_updateStudentMenu.gridy = 3;
		panel.add(updateStudentMenu, gbc_updateStudentMenu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(20, 0, 20, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		contentPane.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Alumnado no seleccionado:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Alumnado seleccionado:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 0;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		jl_AllStudents = new JList<Estudiante>(getDefaultListModel(true));
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 0, 5);
		gbc_list.fill = GridBagConstraints.BOTH;
		gbc_list.gridx = 0;
		gbc_list.gridy = 1;
		panel_1.add(jl_AllStudents, gbc_list);
		this.jl_AllStudents.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); 
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 128, 0));
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 1;
		panel_1.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
//		gbl_panel_2.columnWidths = new int[]{0, 0};
//		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
//		gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
//		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JButton btnNewButton = new JButton("<<");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jlm_SelectedStudents.getSize(); i++) {
					jlm_AllStudents.addElement(jlm_SelectedStudents.getElementAt(i));
				}
				jlm_SelectedStudents.removeAllElements();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel_2.add(btnNewButton, gbc_btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlm_AllStudents.addElement((Estudiante) jl_SelectedStudents.getSelectedValue());
				jlm_SelectedStudents.removeElement(jl_SelectedStudents.getSelectedValue());
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton(">");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jlm_SelectedStudents.addElement((Estudiante) jl_AllStudents.getSelectedValue());
				jlm_AllStudents.removeElement(jl_AllStudents.getSelectedValue());
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_3.gridx = 0;
		gbc_btnNewButton_3.gridy = 2;
		panel_2.add(btnNewButton_3, gbc_btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton(">>");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jlm_AllStudents.getSize(); i++) {
					jlm_SelectedStudents.addElement(jlm_AllStudents.getElementAt(i));
				}
				jlm_AllStudents.removeAllElements();

			}
		});
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridx = 0;
		gbc_btnNewButton_2.gridy = 3;
		panel_2.add(btnNewButton_2, gbc_btnNewButton_2);
		
		jl_SelectedStudents = new JList<Estudiante>(getDefaultListModel(false));
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.fill = GridBagConstraints.BOTH;
		gbc_list_1.gridx = 2;
		gbc_list_1.gridy = 1;
		panel_1.add(jl_SelectedStudents, gbc_list_1);
		
		JButton insertButton = new JButton("Guardar las notas de todos los alumnos seleccionados");
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkStudents();
			}
		});
		GridBagConstraints gbc_insertButton = new GridBagConstraints();
		gbc_insertButton.gridx = 0;
		gbc_insertButton.gridy = 2;
		contentPane.add(insertButton, gbc_insertButton);
	}

	
	/**
	 * 
	 */
	private void addValuesToProfesorCombo() {
		List<Profesor> profesores = ProfesorController.findAll();
		
		for (Profesor profesor : profesores) {
			jcb_ProfessorChooser.addItem(profesor);
		}
	}
	
	
	/**
	 * 
	 */
	private void addValuesToMateriaCombo() {
		List<Materia> materias = MateriaController.findAll();
		
		for (Materia materia : materias) {
			jcb_MateriaChooser.addItem(materia);
		}
	}
	
	
	/**
	 * 
	 */
	private void addValuesToValorationCombo() {
		for (float i = 0; i < 11; i++) {
			this.jcb_ValorationChooser.addItem(i);
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	private DefaultListModel getDefaultListModel(boolean isIzquierda) {
		if(isIzquierda) {
			this.jlm_AllStudents = new DefaultListModel<Estudiante>();
			return this.jlm_AllStudents;
		}
		else {
			this.jlm_SelectedStudents = new DefaultListModel<Estudiante>();
			return this.jlm_SelectedStudents;
		}
	}
	
	
	/**
	 * 
	 * @return
	 */
	private void setValuesToLists () {
			
			jlm_AllStudents.removeAllElements();
			jlm_SelectedStudents.removeAllElements();
		
			addStudent();
		}
		
	
	/**
	 * Add students to the JListModel
	 */
	private void addStudent () {
		for (Estudiante estudiante : allStudentsList) {
			jlm_AllStudents.addElement(estudiante);

		}
	}
	
	
	/**
	 * Check all the students from the selected students list
	 */
	private void checkStudents() {
		List<Estudiante> selectedStudents = new ArrayList<Estudiante>();
		Profesor prof = (Profesor) jcb_ProfessorChooser.getSelectedItem();
		Materia mat = (Materia) jcb_MateriaChooser.getSelectedItem();
		
		for (int i = 0; i < this.jlm_SelectedStudents.size(); i++) {
		    Estudiante e = (Estudiante) this.jlm_SelectedStudents.getElementAt(i);
		    selectedStudents.add(e);
		
		for (Estudiante estudiante : selectedStudents) {
			Valoracionmateria vm = ValoracionMateriaController.findCalification(prof.getId(), mat.getId(), estudiante.getId());
			
			if(vm != null) updateStudent(vm); 
			else insertStudentValoration(vm, prof, mat, estudiante);
			}

		}
		
	}
	
	
	/**
	 * If the student doesn't have any valoration this metod will add it to the database.
	 * @param vm
	 */
	private void insertStudentValoration(Valoracionmateria vm, Profesor p, Materia m, Estudiante student) {
		vm = new Valoracionmateria();
		vm.setValoracion((float) this.jcb_ValorationChooser.getSelectedItem());
		vm.setEstudiante(student);
		vm.setProfesor(p);
		vm.setMateria(m);
		ValoracionMateriaController.realizeInsert(vm);
	}


	/**
	 * Allow you to update the califications from the database.
	 * @param vm
	 */
	private void updateStudent(Valoracionmateria vm) {
		vm.setValoracion((float) this.jcb_ValorationChooser.getSelectedItem());
		ValoracionMateriaController.realizeUpdate(vm);
	}
	

}
