package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class MainPage extends JFrame {

	private JPanel contentPane;
	static ArrayList<Student> students = new ArrayList<Student>();
	static ArrayList<Department> departments = new ArrayList<Department>();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage frame = new MainPage();
					frame.setVisible(true);
					departments.add(new Department("Computing", "Engineering"));
					departments.add(new Department("Business", "Business&Economy"));
					departments.add(new Department("English", "Literature"));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainPage() {
		setTitle("Main Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudentRegistration = new JButton("Student Registration");
		btnStudentRegistration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentForm stuForm = new StudentForm();
				stuForm.setVisible(true);
			}
		});
		btnStudentRegistration.setBounds(119, 71, 207, 53);
		contentPane.add(btnStudentRegistration);
		
		JButton btnDepartmentRegistration = new JButton("Department Registration");
		btnDepartmentRegistration.setBounds(119, 133, 207, 53);
		contentPane.add(btnDepartmentRegistration);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(335, 227, 89, 23);
		contentPane.add(btnExit);
	}
}
