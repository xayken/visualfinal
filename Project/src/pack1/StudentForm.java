package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private JTextField txtSurname;
	private JList list;
	private JTextField txtFile;
	private JButton btnReadfile;

	public void saveStudent(Student stu) throws IOException{
		
		File file = new File("C:/Users/selcuksener/workspace/Project/students.txt");
		FileWriter fwrite = new FileWriter(file,true);
		BufferedWriter bfwrite = new BufferedWriter(fwrite);
		
		bfwrite.write(stu.name);
		bfwrite.newLine();
		bfwrite.write(stu.surname);
		bfwrite.newLine();
		bfwrite.write( String.valueOf( stu.age) );
		bfwrite.newLine();
		bfwrite.close();
		
	}
	
	public ArrayList<Student> getStudents(String filename) throws FileNotFoundException{
		ArrayList<Student> students = new ArrayList<Student>();
		File file = new File("C:/Users/selcuksener/workspace/Project/"+filename);
		Scanner scan = new Scanner(file);
		
		while(scan.hasNext()){
			Student stu = new Student(scan.nextLine(),
									  scan.nextLine(),
									  Integer.parseInt( scan.nextLine()) );
			students.add(stu);
		}
		return students;
	}
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtName = new JTextField();
		txtName.setBounds(10, 24, 86, 20);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtSurname = new JTextField();
		txtSurname.setBounds(10, 57, 86, 20);
		contentPane.add(txtSurname);
		txtSurname.setColumns(10);
		
		final JComboBox cbAge = new JComboBox();
		cbAge.setBounds(10, 90, 42, 20);
		contentPane.add(cbAge);
		for (int i = 18; i < 66; i++) {
			cbAge.addItem(i);
		}
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String name = txtName.getText();
				String surname = txtSurname.getText();
				int age = Integer.parseInt( cbAge.getSelectedItem().toString() );
				Student stu = new Student(name, surname, age);
				try {
					saveStudent(stu);
					txtName.setText("");
					txtSurname.setText("");
					cbAge.setSelectedIndex(0);
					JOptionPane.showMessageDialog(contentPane, "Student Saved!");
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		btnSave.setBounds(10, 132, 89, 23);
		contentPane.add(btnSave);
		
		final DefaultListModel<String> model = new DefaultListModel<String>();
		
		list = new JList();
		list.setModel(model);
		list.setBounds(152, 26, 144, 172);
		contentPane.add(list);
		
		txtFile = new JTextField();
		txtFile.setBounds(317, 24, 86, 20);
		contentPane.add(txtFile);
		txtFile.setColumns(10);
		
		btnReadfile = new JButton("ReadFile");
		btnReadfile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					ArrayList<Student> tempList = getStudents(txtFile.getText());
					model.removeAllElements();
					for (Student s : tempList) {
						model.addElement(s.name+" "+s.surname+" "+s.age);
					}
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
				
			}
		});
		btnReadfile.setBounds(314, 56, 89, 23);
		contentPane.add(btnReadfile);
	}

}
