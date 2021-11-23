import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI
{
	static String userName;
	static String passWord;
	static int option;
	static String options[] = new String[] {"Exit program", 
											"Add an entity", 
											"Generate a grade report", 
											"Courses offered by department", 
											"Add a grade to a student report"};
	public GUI()
	{
		ActionListener listener = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				return;
			}
		};
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		JComboBox optionsSelect = new JComboBox(options);
		var dropDown = optionsSelect;
		JButton button = new JButton("Select");
		
		optionsSelect.addActionListener(dropDown);
		
		panel.setBorder(BorderFactory.createEmptyBorder(400, 400, 400, 400));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(dropDown);
		panel.add(button);
		
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("IT Installer");
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void gradeReport(int number)
	{
		/////////////////////////////////
	}
	
	public static void availableCourses(String courseName, int courseNumber)
	{
		/////////////////////////////////
	}
	
	public static void addGrade(int studentNumber, String courseName, int courseCode, String courseGrade)
	{
		/////////////////////////////////
	}
	
}