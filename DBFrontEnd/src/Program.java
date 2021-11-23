import java.sql.*;
import java.util.Scanner;


public class Program 
{
	static Scanner scan = new Scanner(System.in);
	static String userName;
	static String passWord;
	static int option;

	public static void main(String[] args) throws Exception 
	{
		System.out.println("Please enter your username:");
		userName = scan.nextLine();
		System.out.println("Please enter your password:");
		passWord = scan.nextLine();
		
		Connection yourIn = getConnection(userName, passWord);	
		
		
		System.out.printf("Please make a selection from the options below:\n"
						+ "0) Exit program\n"
						+ "1) Add an entity\n" 
						+ "2) Generate a grade report\n"
						+ "3) Find courses offered by department\n"
						+ "4) Add a grade to a student's report\n\n"
						+ "Please enter your selection:\n");
						option = scan.nextInt();
		while(option != 0)
		{
			switch (option)
			{
			case 0:
			{
				System.exit(0);
			}
			case 1: 
			{
					System.out.printf("\nWhich would you like to add:\n"
									+ "1) Student\n"
									+ "2) Department\n"
									+ "3) Course\n"
									+ "4) Course section\n\n"
									+ "Please enter your selection:\n");
					scan.nextInt();
					//////////////////////////////////////////////
					break;
			}
			case 2:
			{
					int nNumber;
					
					System.out.printf("\nPlease enter the N number of the student:\n");
					nNumber = scan.nextInt();
					gradeReport(nNumber, yourIn);
					break;
			}
			case 3:
			{
					String name = null;
					int code = 0;
					String whichOne = null;
					
					System.out.printf("\nDo you have the department name or code:\n");
					
					scan.nextLine();
					whichOne = scan.nextLine();
					
					if(whichOne.equalsIgnoreCase("name"))
					{
						System.out.printf("\nPlease enter the department name\n");
						name = scan.nextLine();
						availableCourses(name, code, yourIn);
					}
					else
					{
						System.out.printf("\nPlease enter the department code:\n");
						code = scan.nextInt();
						availableCourses(name, code, yourIn);
					}
					
					break;
			}
			case 4:
			{
					int nNumber;
					String name = null;
					String grade = null;
					int code = 0;
					String whichOne = null;
					
					System.out.printf("\nPlease enter the N number of the student:\n");
					nNumber = scan.nextInt();
					
					System.out.printf("\nPlease enter the letter grade the student will receive:\n");
					scan.nextLine();
					grade = scan.nextLine();
					
					System.out.printf("\nDo you have the department name or code:\n");
					whichOne = scan.nextLine();
					
					if(whichOne.equalsIgnoreCase("name"))
					{
						System.out.printf("\nPlease enter the department name\n");
						name = scan.nextLine();
						addGrade(nNumber, name, code, grade, yourIn);
					}
					else
					{
						System.out.printf("\nPlease enter the department code:\n");
						code = scan.nextInt();
						addGrade(nNumber, name, code, grade, yourIn);
					}
			}
			}
			System.out.printf("Please make a selection from the options below:\n"
					+ "0) Exit program\n"
					+ "1) Add an entity\n" 
					+ "2) Generate a grade report\n"
					+ "3) Find courses offered by department\n"
					+ "4) Add a grade to a student's report\n\n"
					+ "Please enter your selection:\n");
					option = scan.nextInt();
		} return;
	}
	
	
	public static void gradeReport(int number, Connection connected)
	{
		try
		{
			Statement queryGrade = connected.createStatement();
			String grades  = "select * from STUDENT WHERE N_NUMBER = '" + number + "'";
			ResultSet results = queryGrade.executeQuery(grades);
			
			if(results.next())
			{
				System.out.println("USER:" + results.getString(1));
			}
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void availableCourses(String courseName, int courseCode, Connection connected)
	{
		if(courseCode != 0)
		{
			try
			{
				Statement queryCourses = connected.createStatement();
				String available = "select ";
				
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				Statement queryCourses = connected.createStatement();
				String available = "select ";
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void addGrade(int studentNumber, String courseName, int courseCode, String courseGrade, Connection connected)
	{
		if(courseCode != 0)
		{
			try
			{
				Statement addIt = connected.createStatement();
				String insertGrade = "UPDATE ENROLLED_IN set GRADE = '" + courseGrade + 
									 "' WHERE N_NUMBER = '" + studentNumber + "'AND COURSE_NAME = '" + courseName + "'";
				addIt.executeUpdate(insertGrade);
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				Statement addIt = connected.createStatement();
				String insertGrade = "UPDATE ENROLLED_IN set GRADE = '" + courseGrade + 
									 "' WHERE N_NUMBER = '" + studentNumber + "'AND COURSE_NUMBER = '" + courseCode + "'";
			} 
			catch (SQLException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	public static Connection getConnection(String userName, String passWord) 
	{
		Connection connectDB = null;
		try {
				String driver = "oracle.jdbc.driver.OracleDriver";
				Class.forName(driver);
			
				String url = "jdbc:oracle:thin:@cisvm-oracle.unfcsd.unf.edu:1521:orcl";
				connectDB = DriverManager.getConnection(url,userName,passWord);
			
				System.out.println("Connected!");
			} 
			catch(Exception e)
			{
				System.out.println(e);
			}
		return connectDB;
	}
}
