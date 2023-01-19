package pack1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.AbstractListModel;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentList extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentList frame = new StudentList();
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
	public StudentList() {
		setTitle("Student List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (Student s : MainPage.students) {
			listModel.addElement(s.name+" "+s.surname);
		}
		
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(170, 31, 203, 122);
		contentPane.add(textArea);
		
		final JList list = new JList();
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				String nameSurname = list.getSelectedValue().toString();
				String output = "";
				for (Student s : MainPage.students) {
					String tempName = s.name+" "+s.surname;
					if(tempName.equals(nameSurname)){
						output+=tempName+"\n"+
								s.age+" "+s.gender+"\n"+
								s.languages+"\n"+
								s.department.title+" "+s.department.faculty;
					break;
					}
				}
				textArea.setText(output);
			}
		});
		list.setModel(listModel);
		list.setBounds(22, 30, 120, 220);
		contentPane.add(list);
		
		JLabel lblStudentList = new JLabel("Student List");
		lblStudentList.setBounds(22, 11, 120, 14);
		contentPane.add(lblStudentList);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnBack.setBounds(335, 227, 89, 23);
		contentPane.add(btnBack);
		
		JButton btnStudentRegister = new JButton("Student Register");
		btnStudentRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StudentForm stuForm = new StudentForm();
				stuForm.setVisible(true);
			}
		});
		btnStudentRegister.setBounds(205, 227, 120, 23);
		contentPane.add(btnStudentRegister);
		
		
	}
}
