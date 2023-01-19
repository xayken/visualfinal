package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setTitle("Student Form");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(130, 130, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(22, 30, 46, 14);
		contentPane.add(lblName);
		
		txtName = new JTextField();
		txtName.setBounds(95, 27, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(22, 68, 77, 14);
		contentPane.add(lblSurname);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(95, 65, 86, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		final JComboBox cbAge = new JComboBox();
		cbAge.setBounds(95, 109, 46, 20);
		contentPane.add(cbAge);
		for (int i = 18; i < 66; i++) {
			cbAge.addItem(i);
		}
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(95, 150, 109, 23);
		contentPane.add(rdbtnMale);
		rdbtnMale.setActionCommand("Male");
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(95, 173, 109, 23);
		contentPane.add(rdbtnFemale);
		rdbtnFemale.setActionCommand("Female");
		
		final ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(rdbtnMale);
		genderGroup.add(rdbtnFemale);
		
		JCheckBox chckbxEnglish = new JCheckBox("English");
		chckbxEnglish.setBounds(219, 26, 97, 23);
		contentPane.add(chckbxEnglish);
		chckbxEnglish.setActionCommand("English");
		
		JCheckBox chckbxSpanish = new JCheckBox("Spanish");
		chckbxSpanish.setBounds(219, 52, 97, 23);
		contentPane.add(chckbxSpanish);
		chckbxSpanish.setActionCommand("Spanish");
		
		JCheckBox chckbxFrench = new JCheckBox("French");
		chckbxFrench.setBounds(219, 79, 97, 23);
		contentPane.add(chckbxFrench);
		chckbxFrench.setActionCommand("French");
		
		final ArrayList<JCheckBox> boxes = new ArrayList<JCheckBox>();
		boxes.add(chckbxEnglish);
		boxes.add(chckbxSpanish);
		boxes.add(chckbxFrench);
		
		final JComboBox cbDept = new JComboBox();
		cbDept.setBounds(219, 122, 97, 20);
		contentPane.add(cbDept);
		for (Department d : MainPage.departments) {
			cbDept.addItem(d.title);
		}
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnStudentList = new JButton("Student list");
		btnStudentList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentList stulist = new StudentList();
				stulist.setVisible(true);
				dispose();
			}
		});
		btnStudentList.setBounds(206, 227, 124, 23);
		contentPane.add(btnStudentList);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = txtName.getText();
				String surname = txtSurname.getText();
				int age = Integer.parseInt( cbAge.getSelectedItem().toString() );
				String gender = genderGroup.getSelection().getActionCommand();
				String languages="";
				for (JCheckBox c : boxes) {
					if(c.isSelected()){
						languages+=c.getActionCommand()+" ";
					}
				}
				Student stu = new Student(name, surname, languages, gender, age);
				
				String deptString = cbDept.getSelectedItem().toString();
				for (Department d : MainPage.departments) {
					if(d.title.equals(deptString)){
						stu.setDepartment(d);
					}
				}
				MainPage.students.add(stu);
				JOptionPane.showMessageDialog(contentPane, "Student saved!");
			}
		});
		btnSave.setBounds(206, 201, 124, 23);
		contentPane.add(btnSave);
	}
}
